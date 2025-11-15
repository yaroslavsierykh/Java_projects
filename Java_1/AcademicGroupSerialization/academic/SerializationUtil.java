package academic;

import java.io.*;

/**
 * Utility class that provides object serialization and deserialization.
 */
public class SerializationUtil {

    /**
     * Serializes an object and saves it to a file.
     *
     * @param obj      object to serialize
     * @param filename target file name
     */
    public static void saveToFile(Object obj, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(obj);
            System.out.println("Object successfully serialized into file: " + filename);
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
    }

    /**
     * Loads and deserializes an object from a file.
     *
     * @param filename file to read from
     * @return deserialized object, or null if failed
     */
    public static Object loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
            return null;
        }
    }
}
