package task1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class FileWorker {
    private static final Logger logger = LoggerFactory.getLogger(FileWorker.class);

    // ---------- ТЕКСТОВИЙ ФАЙЛ (STREAM API) ----------

    public void writeToTextFileByStream(Stop stop, String fileName) {
        Path textFile = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(textFile, StandardCharsets.UTF_8)) {
            writer.write(stop.toString());
            writer.newLine();
            logger.info("Записано у файл (Stream API): {}", textFile.toAbsolutePath());
        } catch (IOException e) {
            logger.error("Помилка запису текстового файлу", e);
        }
    }

    public void readFromTextFileByStream(String fileName) {
        Path textFile = Paths.get(fileName);
        try (Stream<String> lines = Files.lines(textFile, StandardCharsets.UTF_8)) {
            List<String> all = lines.toList();
            logger.info("Зчитано {} рядків з файлу", all.size());
            all.forEach(line -> System.out.println("Файл: " + line));
        } catch (IOException e) {
            logger.error("Помилка читання текстового файлу", e);
        }
    }


    public String writeToXmlString(Stop stop) {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Stop.class});
        xStream.alias("stop", Stop.class);
        return xStream.toXML(stop);
    }

    public void writeToFileXml(Stop stop, String fileName) {
        Path xmlFile = Paths.get(fileName);
        try {
            String xmlString = writeToXmlString(stop);
            Files.writeString(xmlFile, xmlString, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            logger.info("XML збережено у файл: {}", xmlFile.toAbsolutePath());
        } catch (IOException e) {
            logger.error("Помилка запису XML файлу", e);
        }
    }

    public void readFromFileXml(String fileName) {
        Path xmlFile = Paths.get(fileName);
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Stop.class});
        xStream.alias("stop", Stop.class);

        try (Reader reader = Files.newBufferedReader(xmlFile, StandardCharsets.UTF_8)) {
            Stop stop = (Stop) xStream.fromXML(reader);
            System.out.println("Зчитано з XML: " + stop);
            logger.info("Десеріалізовано з XML: {}", stop);
        } catch (IOException e) {
            logger.error("Помилка читання XML файлу", e);
        }
    }

    // ---------- JSON (ОДИН ОБ’ЄКТ) ----------

    public void writeToFileJson(Stop stop, String fileName) {
        Path jsonFile = Paths.get(fileName);
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.allowTypes(new Class[]{Stop.class});
        xStream.alias("stop", Stop.class);

        try {
            StringWriter writer = new StringWriter();
            xStream.toXML(stop, writer);
            String json = writer.toString();

            Files.writeString(jsonFile, json, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            logger.info("JSON збережено у файл: {}", jsonFile.toAbsolutePath());
        } catch (IOException e) {
            logger.error("Помилка запису JSON файлу", e);
        }
    }

    public void readFromFileJson(String fileName) {
        Path jsonFile = Paths.get(fileName);
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.allowTypes(new Class[]{Stop.class});
        xStream.alias("stop", Stop.class);

        try (Reader reader = Files.newBufferedReader(jsonFile, StandardCharsets.UTF_8)) {
            Stop stop = (Stop) xStream.fromXML(reader);
            System.out.println("Зчитано з JSON: " + stop);
            logger.info("Десеріалізовано з JSON: {}", stop);
        } catch (IOException e) {
            logger.error("Помилка читання JSON файлу", e);
        }
    }

    // ---------- МАСИВИ ОБ'ЄКТІВ ----------

    public void writeStopsToXmlFile(Stop[] stops, String fileName) {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Stop[].class, Stop.class});
        xStream.alias("stops", Stop[].class);
        xStream.alias("stop", Stop.class);

        try {
            String xml = xStream.toXML(stops);
            Files.writeString(Paths.get(fileName), xml, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            logger.info("Масив Stop записано в XML: {}", fileName);
        } catch (IOException e) {
            logger.error("Помилка запису XML масиву", e);
        }
    }

    public void writeStopsToJsonFile(Stop[] stops, String fileName) {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.allowTypes(new Class[]{Stop[].class, Stop.class});
        xStream.alias("stops", Stop[].class);
        xStream.alias("stop", Stop.class);

        try {
            String json = xStream.toXML(stops);
            Files.writeString(Paths.get(fileName), json, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            logger.info("Масив Stop записано в JSON: {}", fileName);
        } catch (IOException e) {
            logger.error("Помилка запису JSON масиву", e);
        }
    }

    public Stop[] readStopsFromXmlFile(String fileName) {
        Path xmlFile = Paths.get(fileName);
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Stop[].class, Stop.class});
        xStream.alias("stops", Stop[].class);
        xStream.alias("stop", Stop.class);

        try (Reader reader = Files.newBufferedReader(xmlFile, StandardCharsets.UTF_8)) {
            Stop[] stops = (Stop[]) xStream.fromXML(reader);
            System.out.println("Зчитано масив із XML (" + stops.length + " елементів):");
            for (Stop s : stops) System.out.println("  * " + s);
            return stops;
        } catch (IOException e) {
            logger.error("Помилка читання XML масиву", e);
        }
        return new Stop[0];
    }

    // ✅ Новий метод для читання масиву Stop з JSON
    public Stop[] readStopsFromJsonFile(String fileName) {
        Path jsonFile = Paths.get(fileName);
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.allowTypes(new Class[]{Stop[].class, Stop.class});
        xStream.alias("stops", Stop[].class);
        xStream.alias("stop", Stop.class);

        try (Reader reader = Files.newBufferedReader(jsonFile, StandardCharsets.UTF_8)) {
            Stop[] stops = (Stop[]) xStream.fromXML(reader);
            System.out.println("Зчитано масив із JSON (" + stops.length + " елементів):");
            for (Stop s : stops) System.out.println("  * " + s);
            return stops;
        } catch (IOException e) {
            logger.error("Помилка читання JSON масиву", e);
        }
        return new Stop[0];
    }
}
