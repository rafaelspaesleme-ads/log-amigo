package br.com.logamigo.logamigo.utils;

import br.com.logamigo.logamigo.exceptions.StringException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class StringUtils {

    private static final String TRIPLE_ARROW = " >>> ";

    private StringUtils() {

    }

    protected static String generatorID() {
        try {
            final Random random = SecureRandom.getInstanceStrong();

        final byte[] bytes = (Long.toHexString(random.nextLong()) + datetimeMillisecound()).getBytes();

        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, bytes.length).forEach(i -> {
            if (isNotSimbol(bytes[i])) {
                stringBuilder.append(String.valueOf(bytes[i]));
            }
        });

        return stringBuilder.substring(0, 7);

        } catch (NoSuchAlgorithmException e) {
            throw new StringException(e.getMessage());
        }
    }
    private static String datetimeMillisecound() {
        final LocalDateTime now = LocalDateTime.now();
        return String.valueOf(now.getYear() + now.getMonthValue() + now.getDayOfMonth() + now.getHour() + now.getMinute() + now.getSecond() + now.getNano());
    }

    private static <T> boolean isNotSimbol(final T t) {
        if (Objects.isNull(t)) {
            return false;
        }
        return !t.toString().contains(" '!@#$%*()_-+=§£¢¬\\|/;:.,<>°ºª´`^~*?\"");
    }

    protected static String tripleArrow() {
        return TRIPLE_ARROW;
    }
}
