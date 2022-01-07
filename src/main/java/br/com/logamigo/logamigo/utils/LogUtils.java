package br.com.logamigo.logamigo.utils;

import br.com.logamigo.logamigo.enums.LangEnum;

import java.io.File;
import java.time.LocalDateTime;

import static br.com.logamigo.logamigo.enums.TypeLogEnum.ERROR;
import static br.com.logamigo.logamigo.enums.TypeLogEnum.INFO;
import static br.com.logamigo.logamigo.enums.TypeLogEnum.SUCCESS;
import static br.com.logamigo.logamigo.enums.TypeLogEnum.WARNING;
import static br.com.logamigo.logamigo.utils.ConsoleLogUtils.displayMessage;
import static br.com.logamigo.logamigo.utils.FileUtils.*;
import static br.com.logamigo.logamigo.utils.StringUtils.generatorID;
import static java.lang.System.*;

public class LogUtils {

    private static final String FILENAME = generatorID().concat("_").concat(LocalDateTime.now().toString())
            .replaceAll("-", "")
            .replaceAll(":", "")
            .replaceAll("\\.","");

    private LogUtils() {
    }

    public static void ofWarning(final String message, final LangEnum lang) {

        final String msg = displayMessage(message, WARNING, lang);

        out.println(msg);

        out.println(displayMessage(createFile(msg), WARNING, lang));

    }

    public static void ofInfo(final String message, final LangEnum lang) {

        final String msg = displayMessage(message, INFO, lang);

        out.println(msg);

        out.println(displayMessage(createFile(msg), INFO, lang));

    }

    public static void ofError(final String message, final LangEnum lang) {

        final String msg = displayMessage(message, ERROR, lang);

        out.println(msg);

        out.println(displayMessage(createFile(msg), ERROR, lang));

    }

    public static void ofSuccess(final String message, final LangEnum lang) {

        final String msg = displayMessage(message, SUCCESS, lang);

        out.println(msg);

        out.println(displayMessage(createFile(msg), SUCCESS, lang));

    }

    public static File findLogFileById(final String logId) {
        return getFileById(logId);
    }

    public static File[] findLogsFiles() {
        return getFiles(null);
    }

    private static String createFile(final String msg) {
        return generatorFile(msg, FILENAME);
    }

}
