package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {

  private final Calculator calculator = new Calculator();

  @Test
  public void testSum() {
    assertEquals(5, calculator.sum(2, 3));
    assertEquals(0, calculator.sum(0, 0));
    assertEquals(-1, calculator.sum(-3, 2));
    assertEquals(10, calculator.sum(5, 5));
  }

  @Test
  public void testMinus() {
    assertEquals(1, calculator.minus(3, 2));
    assertEquals(0, calculator.minus(5, 5));
    assertEquals(-5, calculator.minus(0, 5));
    assertEquals(10, calculator.minus(15, 5));
  }

  @Test
  public void testDivide() {
    assertEquals(2, calculator.divide(6, 3));
    assertEquals(5, calculator.divide(10, 2));
    assertEquals(0, calculator.divide(0, 5));
  }

  @Test
  public void testDivideByZero() {
    assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
  }

  @Test
  public void testMultiply() {
    assertEquals(6, calculator.multiply(2, 3));
    assertEquals(0, calculator.multiply(0, 5));
    assertEquals(-6, calculator.multiply(-2, 3));
    assertEquals(25, calculator.multiply(5, 5));
  }
}
