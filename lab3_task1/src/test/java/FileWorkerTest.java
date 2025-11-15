import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileWorkerTest {

    private static final String TXT_FILE = "test_stops.txt";
    private static final String XML_FILE = "test_stops.xml";
    private static final String JSON_FILE = "test_stops.json";

    private static FileWorker fileWorker;
    private static Stop stop;

    @BeforeAll
    static void init() {
        fileWorker = new FileWorker();
        stop = new Stop("Центральна", 100);
    }

    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Paths.get(TXT_FILE));
        Files.deleteIfExists(Paths.get(XML_FILE));
        Files.deleteIfExists(Paths.get(JSON_FILE));
    }

    @Test
    @Order(1)
    void testWriteAndReadTxt() throws IOException {
        fileWorker.writeToTextFileByStream(stop, TXT_FILE);

        List<String> lines = Files.readAllLines(Paths.get(TXT_FILE));
        assertFalse(lines.isEmpty());
        assertTrue(lines.get(0).contains("Центральна"));
    }

    @Test
    @Order(2)
    void testWriteAndReadXml() throws IOException {
        fileWorker.writeToFileXml(stop, XML_FILE);

        String content = Files.readString(Paths.get(XML_FILE));
        assertTrue(content.contains("Центральна"));
        assertTrue(content.contains("100"));
    }

    @Test
    @Order(3)
    void testWriteAndReadJson() throws IOException {
        fileWorker.writeToFileJson(stop, JSON_FILE);

        String content = Files.readString(Paths.get("person.json"));
        assertTrue(content.contains("Центральна"));
        assertTrue(content.contains("100"));

        // перейменовуємо файл після тесту (бо в методі фіксована назва)
        Files.move(Paths.get("person.json"), Paths.get(JSON_FILE), StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    @Order(4)
    void testWriteStopsToXmlFile() throws IOException {
        Stop[] stops = {
                new Stop("Центральна", 100),
                new Stop("Вокзал", 40)
        };
        fileWorker.writeStopsToXmlFile(stops, XML_FILE);

        String xml = Files.readString(Paths.get(XML_FILE));
        assertTrue(xml.contains("Центральна"));
        assertTrue(xml.contains("Вокзал"));
    }

    @Test
    @Order(5)
    void testWriteStopsToJsonFile() throws IOException {
        Stop[] stops = {
                new Stop("Проспект", 50),
                new Stop("Площа", 20)
        };
        fileWorker.writeStopsToJsonFile(stops, JSON_FILE);

        String json = Files.readString(Paths.get(JSON_FILE));
        assertTrue(json.contains("Проспект"));
        assertTrue(json.contains("Площа"));
    }
}
