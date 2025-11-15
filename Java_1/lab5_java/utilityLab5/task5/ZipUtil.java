package utilityLab5.task5;

import java.io.*;
import java.util.zip.*;

public class ZipUtil {
    public static void writeObjectToZip(String zipFileName, String entryName, Object obj) {
        try (
                FileOutputStream fos = new FileOutputStream(zipFileName);
                ZipOutputStream zos = new ZipOutputStream(fos)
        ) {
            zos.putNextEntry(new ZipEntry(entryName));

            ObjectOutputStream oos = new ObjectOutputStream(zos);
            oos.writeObject(obj);

            zos.closeEntry();
            System.out.println("Об'єкт записано у ZIP: " + zipFileName);
        } catch (IOException e) {
            System.err.println("Помилка запису до ZIP: " + e.getMessage());
        }
    }


    public static Object readObjectFromZip(String zipFileName, String entryName) {
        try (
                FileInputStream fis = new FileInputStream(zipFileName);
                ZipInputStream zis = new ZipInputStream(fis)
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals(entryName)) {
                    try (ObjectInputStream ois = new ObjectInputStream(zis)) {
                        Object obj = ois.readObject();
                        System.out.println("Об'єкт зчитано з ZIP: " + zipFileName);
                        return obj;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка читання з ZIP: " + e.getMessage());
        }
        return null;
    }
}

