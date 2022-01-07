package br.com.logamigo.logamigo.utils;

import br.com.logamigo.logamigo.enums.LangEnum;
import br.com.logamigo.logamigo.enums.TypeLogEnum;

import java.time.LocalDateTime;

import static br.com.logamigo.logamigo.enums.LangEnum.ENG;
import static br.com.logamigo.logamigo.enums.TypeLogEnum.ERROR;
import static br.com.logamigo.logamigo.enums.TypeLogEnum.INFO;
import static br.com.logamigo.logamigo.enums.TypeLogEnum.SUCCESS;
import static br.com.logamigo.logamigo.enums.TypeLogEnum.WARNING;
import static br.com.logamigo.logamigo.utils.ColorsUtils.BLUE_BRIGHT;
import static br.com.logamigo.logamigo.utils.ColorsUtils.GREEN_BRIGHT;
import static br.com.logamigo.logamigo.utils.ColorsUtils.RED_BRIGHT;
import static br.com.logamigo.logamigo.utils.ColorsUtils.YELLOW_BRIGHT;
import static br.com.logamigo.logamigo.utils.EmojisUtils.ofErr;
import static br.com.logamigo.logamigo.utils.EmojisUtils.ofIn;
import static br.com.logamigo.logamigo.utils.EmojisUtils.ofOk;
import static br.com.logamigo.logamigo.utils.EmojisUtils.ofWarn;
import static br.com.logamigo.logamigo.utils.StringUtils.*;
import static java.lang.System.*;

public class ConsoleLogUtils {

    private ConsoleLogUtils() {
    }

    public static void ofWarning(final String message, final LangEnum lang) {
        out.println(displayMessage(message, WARNING, lang));
    }

    public static void ofInfo(final String message, final LangEnum lang) {
        out.println(displayMessage(message, INFO, lang));
    }

    public static void ofError(final String message, final LangEnum lang) {
        out.println(displayMessage(message, ERROR, lang));
    }

    public static void ofSuccess(final String message, final LangEnum lang) {
        out.println(displayMessage(message, SUCCESS, lang));
    }

    protected static String displayMessage(final String message, final TypeLogEnum type, final LangEnum lang) {
        return selectInitialMessage(type, lang) + " - " + LocalDateTime.now() +" ID: " + generatorID() + " [  = = = = = --- LogAmigo]: ".concat(message);
    }

    protected static String selectInitialMessage(final TypeLogEnum type, final LangEnum lang) {
        if (WARNING.equals(type)) {
            return YELLOW_BRIGHT + tripleArrow() + ofWarn() + " [!] LOG " + (ENG.name().equals(lang.name()) ? WARNING.getDescriptionEng() : WARNING.getDescriptionPtBr()) + " " + ofWarn();
        }
        if (INFO.equals(type)) {
            return BLUE_BRIGHT + tripleArrow() + ofIn() + " [i] LOG " + (ENG.name().equals(lang.name()) ? INFO.getDescriptionEng() : INFO.getDescriptionPtBr()) + " " + ofIn();
        }
        if (ERROR.equals(type)) {
            return RED_BRIGHT + tripleArrow() + ofErr() + " [x] LOG " + (ENG.name().equals(lang.name()) ? ERROR.getDescriptionEng() : ERROR.getDescriptionPtBr()) + " " + ofErr();
        }
        if (SUCCESS.equals(type)) {
            return GREEN_BRIGHT + tripleArrow() + ofOk() + " [v] LOG " + (ENG.name().equals(lang.name()) ? SUCCESS.getDescriptionEng() : SUCCESS.getDescriptionPtBr()) + " " + ofOk();
        }
        return null;
    }
}
