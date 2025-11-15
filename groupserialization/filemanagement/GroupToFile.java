package groupserialization.filemanagement;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class GroupToFile {

    public static void readFromFile(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser()  ;

            DefaultHandler handler = new DefaultHandler() {
                boolean name = false;
                boolean surname = false;
                boolean birthdate= false;
                boolean major = false;
                boolean averageMark = false;
                boolean groupName = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("name")) name  = true;
                    if (qName.equalsIgnoreCase("surname")) surname = true;
                    if (qName.equalsIgnoreCase("birthdate")) birthdate = true;
                    if (qName.equalsIgnoreCase("major")) major = true;
                    if (qName.equalsIgnoreCase("averageMark")) averageMark = true;
                    if (qName.equalsIgnoreCase("groupName")) groupName = true;
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String text = new String(ch, start, length);

                    if (!text.isEmpty()) {
                        if (groupName) {
                            System.out.println("Group Name : " + text + "\n");
                            groupName = false;
                        } else if (name) {
                            System.out.println("Ім'я студента: " + text);
                            name = false;
                        } else if (surname) {
                            System.out.println("Прізвище студента: " + text);
                            surname = false;
                        } else if (birthdate) {
                            System.out.println("Дата народження студента: " + text);
                            birthdate = false;
                        } else if (major) {
                            System.out.println("Спеціальність: " + text);
                            major = false;
                        } else if (averageMark) {
                            System.out.println("Середній бал: " + text);
                            averageMark = false;
                            System.out.println("-------------------------------------------------");
                        }
                    }

                }
            };

            parser.parse(new File(fileName), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readAndAddNewStudent(String fileName, String name, String surname, String birthdate, String major, String averageMark) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));

            Element root = document.getDocumentElement();

            Element newStudent = document.createElement("student");

            Element nameElement = document.createElement("name");
            nameElement.setTextContent(name);

            Element surnameElement = document.createElement("surname");
            surnameElement.setTextContent(surname);

            Element birthdateElement = document.createElement("birthdate");
            birthdateElement.setTextContent(birthdate);

            Element majorElement = document.createElement("major");
            majorElement.setTextContent(major);

            Element averageMarkElement = document.createElement("averageMark");
            averageMarkElement.setTextContent(averageMark);

            newStudent.appendChild(nameElement);
            newStudent.appendChild(surnameElement);
            newStudent.appendChild(birthdateElement);
            newStudent.appendChild(majorElement);
            newStudent.appendChild(averageMarkElement);

            root.appendChild(newStudent);

            String newFileName = fileName.replace(".xml", "_new.xml");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File(newFileName)));
            System.out.printf("\n=== Студента успішно додано, новий файл: %s ===\n\n",  newFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void main(String[] args) {
        String fileName = "group.xml";
        readFromFile(fileName);

        readAndAddNewStudent("group.xml", "Ярослав", "Сєрих", "2006-06-05", "Development and startup", "97.4");

        readFromFile("group_new.xml");
    }

}
