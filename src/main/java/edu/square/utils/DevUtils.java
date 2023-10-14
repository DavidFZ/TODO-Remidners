package edu.square.utils;

import java.awt.*;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

public class DevUtils {
    /**
     * Deletes the directory recursively
     *
     * @param dir            the directory to be deleted
     * @param isDeleteOnExit if true, the file will be deleted when the JVM exits
     */
    public static void deleteDir(File dir, boolean isDeleteOnExit) {
        //check if the file is directory
        if (dir == null || !dir.exists())
            throw new RuntimeException("file not exist");

        File[] files = dir.listFiles();

        // skip if the directory is empty
        if (files != null)
            for (File f : files) {
                if (f.isDirectory())
                    deleteDir(f, isDeleteOnExit);
                else deleteFile(f, isDeleteOnExit);
            }

        // delete the directory itself
        deleteFile(dir, isDeleteOnExit);
    }

    /**
     * Deletes the file
     *
     * @param file           the file to be deleted
     * @param isDeleteOnExit if true, the file will be deleted when the JVM exits
     */
    public static void deleteFile(File file, boolean isDeleteOnExit) {
        if (isDeleteOnExit)
            file.deleteOnExit();
        else
            file.delete();
    }

    /**
     * Checks if the directory exists
     *
     * @param dir
     * @return
     */
    public static boolean isDirExist(String dir) {
        File file = new File(dir);
        return file.exists();
    }

    /**
     * Returns the current timestamp
     *
     * @return current timestamp
     */
    public static Timestamp getTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
