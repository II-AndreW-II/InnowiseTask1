package by.andrew.task1.parser;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.factory.CustomArrayFactory;
import by.andrew.task1.validator.ArrayValidator;
import by.andrew.task1.validator.impl.ArrayValidatorImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ArrayParser {
    private static final Logger logger = LogManager.getLogger(ArrayParser.class);
    private static final String NUMBER_SEPARATOR_PATTERN = "[,\\s;\\-]+";
    private static final Pattern separatorPattern = Pattern.compile(NUMBER_SEPARATOR_PATTERN);
    private final ArrayValidator validator;

    public ArrayParser() {
        this.validator = new ArrayValidatorImpl();
    }

    public ArrayParser(ArrayValidator validator) {
        this.validator = validator;
    }

    public CustomArray parseLine(String line) throws CustomArrayException {
        if (line == null) {
            logger.error("Line is null");
            throw new CustomArrayException("Line is null");
        }

        if (validator.isEmptyLine(line)) {
            logger.info("Empty line parsed, returning empty array");
            return CustomArrayFactory.createCustomArray(new int[0]);
        }

        if (!validator.isValidLine(line)) {
            logger.error("Invalid line format: {}", line);
            throw new CustomArrayException("Invalid line format: " + line);
        }

        String[] parts = separatorPattern.split(line.trim());
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                try {
                    numbers.add(Integer.parseInt(trimmed));
                } catch (NumberFormatException e) {
                    logger.error("Cannot parse number from: {}", trimmed);
                    throw new CustomArrayException("Cannot parse number from: " + trimmed, e);
                }
            }
        }

        int[] array = numbers.stream().mapToInt(Integer::intValue).toArray();
        logger.info("Parsed {} numbers from line", array.length);
        return CustomArrayFactory.createCustomArray(array);
    }
}

