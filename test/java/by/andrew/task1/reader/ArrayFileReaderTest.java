package by.andrew.task1.reader;

import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFileReaderTest {
    private static final String VALID_FILE_PATH = "data/arrays.txt";
    private static final String INVALID_FILE_PATH = "data/nonexistent.txt";

    @Test
    void testReadLinesWithValidFile() throws CustomArrayException {
        String filePath = VALID_FILE_PATH;
        ArrayFileReader reader = new ArrayFileReader();
        List<String> result = reader.readLines(filePath);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testReadLinesWithInvalidFile() {
        String filePath = INVALID_FILE_PATH;
        ArrayFileReader reader = new ArrayFileReader();
        assertThrows(CustomArrayException.class, () -> reader.readLines(filePath));
    }

    @Test
    void testReadLinesWithNullPath() {
        String filePath = null;
        ArrayFileReader reader = new ArrayFileReader();
        assertThrows(CustomArrayException.class, () -> reader.readLines(filePath));
    }

    @Test
    void testReadLinesWithEmptyPath() {
        String filePath = "";
        ArrayFileReader reader = new ArrayFileReader();
        assertThrows(CustomArrayException.class, () -> reader.readLines(filePath));
    }
}

