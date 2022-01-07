package br.com.logamigo.logamigo.utils;

import br.com.logamigo.logamigo.exceptions.FileException;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FileUtils {

    private FileUtils() {

    }

    private static final String DIR = "logs";
    private static final String EXTENSION_FILE = ".log";

    protected static File getFileById(final String lodId) {
        final File[] files = getFiles(lodId.concat("_*"));
        if (files == null) {
            return null;
        }

        return files[0];
    }

    protected static File[] getFiles(final String search) {

        final File dir = new File(DIR.concat("/"));
        final FileFilter fileFilter = new WildcardFileFilter(search == null
                ? "*".concat(EXTENSION_FILE)
                : search.concat(EXTENSION_FILE));

        return dir.listFiles(fileFilter);

    }

    protected static <T> String generatorFile(final T data, final String filename) {
        if (Objects.isNull(data)) {
            return null;
        }

        if (Objects.isNull(filename)) {
            return null;
        }


        final File folder = new File(DIR);
        if (!folder.exists()){
            folder.mkdirs();
        }

        final File file = new File(DIR.concat("/").concat(filename).concat(EXTENSION_FILE));


        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data.toString().concat("\n"));

            return "Log " + filename + EXTENSION_FILE + " gerado  com sucesso na pasta " + DIR + ".";

        } catch (final IOException e) {
            throw new FileException(e.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
