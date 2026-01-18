package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.mos.qa.testtasks.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StackTests {

  private Stack stack;

  @BeforeEach
  public void setUp() {
    stack = new Stack(5);
  }

  @Test
  public void testEmptyStack() {
    assertTrue(stack.isEmpty());
    assertFalse(stack.isFull());
  }

  @Test
  public void testAddElement() {
    stack.addElement(10);
    assertFalse(stack.isEmpty());
    assertEquals(10, stack.readTop());
  }

  @Test
  public void testDeleteElement() {
    stack.addElement(5);
    stack.addElement(10);
    assertEquals(10, stack.deleteElement());
    assertEquals(5, stack.readTop());
  }

  @Test
  public void testMultipleOperations() {
    stack.addElement(1);
    stack.addElement(2);
    stack.addElement(3);
    assertEquals(3, stack.readTop());
    assertEquals(3, stack.deleteElement());
    assertEquals(2, stack.readTop());
    assertEquals(2, stack.deleteElement());
    assertEquals(1, stack.readTop());
    assertEquals(1, stack.deleteElement());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testIsFull() {
    stack.addElement(1);
    stack.addElement(2);
    stack.addElement(3);
    stack.addElement(4);
    stack.addElement(5);
    assertTrue(stack.isFull());
    assertFalse(stack.isEmpty());
  }

  @Test
  public void testLIFO() {
    stack.addElement(10);
    stack.addElement(20);
    stack.addElement(30);
    assertEquals(30, stack.deleteElement());
    assertEquals(20, stack.deleteElement());
    assertEquals(10, stack.deleteElement());
    assertTrue(stack.isEmpty());
  }
}
