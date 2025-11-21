package by.andrew.task1.validator.impl;

import by.andrew.task1.validator.ArrayValidator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final Logger logger = LogManager.getLogger(ArrayValidatorImpl.class);
    private static final String VALID_LINE_PATTERN = "^\\s*((-?\\d+)(\\s*[,\\s;\\-]+\\s*-?\\d+)*\\s*)?$";
    private static final Pattern pattern = Pattern.compile(VALID_LINE_PATTERN);

    @Override
    public boolean isValidLine(String line) {
        if (line == null) {
            logger.debug("Line is null");
            return false;
        }

        if (isEmptyLine(line)) {
            logger.debug("Line is empty");
            return true;
        }

        boolean isValid = pattern.matcher(line).matches();
        if (isValid) {
            logger.debug("Line is valid: {}", line);
        } else {
            logger.debug("Line is invalid: {}", line);
        }
        return isValid;
    }

    @Override
    public boolean isEmptyLine(String line) {
        return line != null && line.trim().isEmpty();
    }
}

