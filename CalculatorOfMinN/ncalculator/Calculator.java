        package ncalculator;

        import javax.swing.*;
        import java.awt.*;

        public class Calculator extends JFrame {
            private JTextField resultField;
            private JTextField limitField;
            private JTextArea logArea;
            private JButton calculateButton;
            private JButton clearButton;
            private CalculationWorker currentWorker;
            private int limitValue;

            public Calculator() {
                setupGUI();
                setTitle("Калькулятор мінімального n");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(520, 430);
                setLocationRelativeTo(null);
            }

            private void setupGUI() {
                JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JLabel titleLabel = new JLabel("Знайти мінімальне n: n² + 2⁴ + 3³ + n > користувач ввів", JLabel.CENTER);
                titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
                mainPanel.add(titleLabel, BorderLayout.NORTH);

                JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

                JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                inputPanel.add(new JLabel("Введіть межу (число):"));
                limitField = new JTextField(10);
                inputPanel.add(limitField);
                centerPanel.add(inputPanel, BorderLayout.NORTH);

                JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                resultPanel.add(new JLabel("Результат:"));
                resultField = new JTextField(15);
                resultField.setEditable(false);
                resultPanel.add(resultField);
                centerPanel.add(resultPanel, BorderLayout.CENTER);

                JPanel buttonPanel = new JPanel(new FlowLayout());
                calculateButton = new JButton("Розрахувати");
                clearButton = new JButton("Очистити");

                calculateButton.addActionListener(e -> startCalculation());
                clearButton.addActionListener(e -> clearAll());

                buttonPanel.add(calculateButton);
                buttonPanel.add(clearButton);
                centerPanel.add(buttonPanel, BorderLayout.SOUTH);

                mainPanel.add(centerPanel, BorderLayout.CENTER);

                logArea = new JTextArea(10, 40);
                logArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(logArea);
                scrollPane.setBorder(BorderFactory.createTitledBorder("Процес обчислення:"));
                mainPanel.add(scrollPane, BorderLayout.SOUTH);

                add(mainPanel);
            }

            private double calculateFormula(int n) {
                return n * n + 16 + 27 + n;
            }

            private boolean checkCondition(int n) {
                return calculateFormula(n) > limitValue;
            }

            private void startCalculation() {
                String inputText = limitField.getText().trim();

                if (inputText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Будь ласка, введіть число для порівняння.", "Помилка вводу", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    limitValue = Integer.parseInt(inputText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Введіть коректне ціле число!", "Помилка вводу", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                calculateButton.setEnabled(false);
                clearButton.setEnabled(false);

                logArea.append("Початок пошуку...\n");
                logArea.append("Умова: n² + 16 + 27 + n > " + limitValue + "\n");
                logArea.append("----------------------------\n");

                currentWorker = new CalculationWorker();
                currentWorker.execute(); 
            }

            private void clearAll() {
                if (currentWorker != null && !currentWorker.isDone()) {
                    currentWorker.cancel(true);
                }
                resultField.setText("");
                logArea.setText("");
                limitField.setText("");
                calculateButton.setEnabled(true);
                clearButton.setEnabled(true);
            }

            private void addToLog(String message) {
                logArea.append(message + "\n");
                logArea.setCaretPosition(logArea.getDocument().getLength());
            }

            private class CalculationWorker extends SwingWorker<Integer, String> {
                @Override
                protected Integer doInBackground() {
                    int left = 0;
                    int right = 1;
                    int maxIterations = 100000;

                    while (right <= maxIterations && !checkCondition(right)) {
                        publish("Перевірка n = " + right + " → " + (int) calculateFormula(right) + " ≤ " + limitValue);
                        right *= 2;
                        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                    }

                    if (right > maxIterations) {
                        publish("Не вдалося знайти діапазон для пошуку.");
                        return -1;
                    }

                    publish("Знайдено діапазон [" + (right / 2) + ", " + right + "] де відбувається перехід.");
                    publish("----------------------------");

                    left = right / 2;

                    while (left < right && !isCancelled()) {
                        int mid = (left + right) / 2;
                        double value = calculateFormula(mid);
                        publish("n = " + mid + " → " + (int) value);

                        if (checkCondition(mid)) {
                            right = mid;
                            publish("Виконується ✓ (шукаємо менше)");
                        } else {
                            left = mid + 1;
                            publish("Не виконується ✗ (збільшуємо n)");
                        }

                        try {
                            Thread.sleep(120);
                        } catch (InterruptedException e) {
                            if (isCancelled()) return -1;
                        }
                    }

                    return left;
                }

                @Override
                protected void process(java.util.List<String> chunks) {
                    for (String message : chunks) addToLog(message);
                }

                @Override
                protected void done() {
                    try {
                        if (!isCancelled()) {
                            Integer result = get();
                            if (result != null && result > 0) {
                                resultField.setText(String.valueOf(result));
                                addToLog("Знайдено мінімальне n: " + result);
                                addToLog("Перевірка: " + result + "² + 16 + 27 + " + result + " = " +
                                        (int) calculateFormula(result) + " > " + limitValue);
                            } else {
                                resultField.setText("Не знайдено");
                                addToLog("Рішення не знайдено");
                            }
                        }
                    } catch (Exception e) {
                        resultField.setText("Помилка");
                        addToLog("Сталася помилка: " + e.getMessage());
                    } finally {
                        calculateButton.setEnabled(true);
                        clearButton.setEnabled(true);
                        addToLog("----------------------------\n");
                    }
                }
            }

            public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
            }
        }
