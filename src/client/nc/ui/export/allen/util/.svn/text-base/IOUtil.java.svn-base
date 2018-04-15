package nc.ui.export.allen.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;


/**
 * A Util class for IO.
 * */
public class IOUtil {

    /**
     * close reader.
     * */
    public static void close(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    /**
     * close writer.
     * */
    public static void close(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    /**
     * close OutputStream.
     * */
    public static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    /**
     * close InputStream.
     * */
    public static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    /**
     * Check file is file. Note: not a dir.
     * 
     * @throws RuntimeException if it is not file.
     * */
    public static void checkIsFile(File file) {
        if (file.isDirectory()) {
            throw new RuntimeException("File is not file. File name = " + file.getAbsolutePath());
        }
    }

    /**
     * Check file is dir. Note: not a file.
     * 
     * @throws RuntimeException if it is not dir.
     * */
    public static void checkIsDir(File file) {
        if (file.isFile()) {
            throw new RuntimeException("File is not dir. File name = " + file.getAbsolutePath());
        }
    }

    /**
     * try to create new file if file doesn't exist.
     */
    public static void createNewFileIfNotExist(String filePath) {
        File file = new File(filePath);
        createNewFileIfNotExist(file);
    }

    /**
     * try to create new file if file doesn't exist.
     */
    public static void createNewFileIfNotExist(File file) {
        if (file == null) {
            throw new NullPointerException();
        }

        // Fix the p. So the file can get its parent file.
        file = new File(file.getAbsolutePath());

        checkIsFile(file);

        if (!file.exists()) {
            try {
                File parentDir = file.getParentFile();

                createNewDirIfNotExist(parentDir);

                if (!file.createNewFile()) {
                    throw new RuntimeException("bad luck.");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * try to create new dir if not exist.
     * */
    public static void createNewDirIfNotExist(File dir) {

        if (dir == null) {
            throw new NullPointerException();
        }

        checkIsDir(dir);

        if (!dir.exists()) {
            // Fix the p. So the file can get its parent file.
            dir = new File(dir.getAbsolutePath());

            File parentDir = dir.getParentFile();

            createNewDirIfNotExist(parentDir);

            if (!dir.mkdir()) {
                throw new RuntimeException("bad luck.");
            }
        }
    }

}
