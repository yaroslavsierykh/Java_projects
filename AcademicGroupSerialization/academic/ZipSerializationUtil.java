package academic;

import java.io.*;
import java.util.zip.*;

/**
 * Utility class for writing and reading serialized objects inside a ZIP archive.
 */
public class ZipSerializationUtil {

    /**
     * Writes a serializable object into a ZIP file as a single entry.
     *
     * @param zipFileName ZIP archive name
     * @param entryName   file name inside the ZIP
     * @param obj         object to serialize
     */
    public static void writeObjectToZip(String zipFileName, String entryName, Object obj) {
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            zos.putNextEntry(new ZipEntry(entryName));

            ObjectOutputStream oos = new ObjectOutputStream(zos);
            oos.writeObject(obj);

            zos.closeEntry();
            System.out.println("Object successfully written to ZIP: " + zipFileName);

        } catch (IOException e) {
            System.err.println("Error writing to ZIP: " + e.getMessage());
        }
    }

    /**
     * Reads and deserializes an object from a ZIP archive.
     *
     * @param zipFileName ZIP archive name
     * @param entryName   name of the entry to read
     * @return deserialized object or null if not found or error
     */
    public static Object readObjectFromZip(String zipFileName, String entryName) {
        try (FileInputStream fis = new FileInputStream(zipFileName);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals(entryName)) {

                    try (ObjectInputStream ois = new ObjectInputStream(zis)) {
                        Object obj = ois.readObject();
                        System.out.println("Object successfully read from ZIP: " + zipFileName);
                        return obj;
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from ZIP: " + e.getMessage());
        }

        return null;
    }
}
