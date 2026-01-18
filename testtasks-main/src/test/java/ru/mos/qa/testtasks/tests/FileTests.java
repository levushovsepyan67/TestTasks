package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {

  @Test
  public void fileContainsPerseverance() throws IOException {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("TraineeCharacteristics.txt");
    assert inputStream != null;
    String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    assertTrue(content.contains("Упорство"));
  }
}
