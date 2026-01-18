package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.mos.qa.testtasks.DynamicStack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicStackTests {

  private DynamicStack stack;

  @BeforeEach
  public void setUp() {
    stack = new DynamicStack();
  }

  @Test
  public void testEmptyStack() {
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
  }

  @Test
  public void testAddElement() {
    stack.addElement(10);
    assertFalse(stack.isEmpty());
    assertEquals(10, stack.readTop());
    assertEquals(1, stack.size());
  }

  @Test
  public void testDeleteElement() {
    stack.addElement(5);
    stack.addElement(10);
    assertEquals(10, stack.deleteElement());
    assertEquals(5, stack.readTop());
    assertEquals(1, stack.size());
  }

  @Test
  public void testExpandOnOverflow() {
    int initialCapacity = stack.capacity();
    for (int i = 0; i < initialCapacity + 1; i++) {
      stack.addElement(i);
    }
    assertTrue(stack.capacity() > initialCapacity);
    assertEquals(initialCapacity + 1, stack.size());
  }

  @Test
  public void testShrinkWhenMoreThanHalfEmpty() {
    int initialCapacity = stack.capacity();
    for (int i = 0; i < initialCapacity * 2; i++) {
      stack.addElement(i);
    }
    int expandedCapacity = stack.capacity();
    assertTrue(expandedCapacity > initialCapacity);
    
    for (int i = 0; i < expandedCapacity / 2 + 1; i++) {
      stack.deleteElement();
    }
    assertTrue(stack.capacity() < expandedCapacity);
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

  @Test
  public void testMultipleExpansions() {
    for (int i = 0; i < 100; i++) {
      stack.addElement(i);
    }
    assertEquals(100, stack.size());
    assertTrue(stack.capacity() >= 100);
  }

  @Test
  public void testShrinkAfterExpansion() {
    for (int i = 0; i < 20; i++) {
      stack.addElement(i);
    }
    int expandedCapacity = stack.capacity();
    
    while (!stack.isEmpty()) {
      stack.deleteElement();
    }
    assertTrue(stack.capacity() <= expandedCapacity);
  }

  @Test
  public void testReadTopOnEmptyStack() {
    assertThrows(IllegalStateException.class, () -> stack.readTop());
  }

  @Test
  public void testDeleteElementOnEmptyStack() {
    assertThrows(IllegalStateException.class, () -> stack.deleteElement());
  }

  @Test
  public void testCapacityChanges() {
    int initialCapacity = stack.capacity();
    for (int i = 0; i < initialCapacity + 5; i++) {
      stack.addElement(i);
    }
    assertTrue(stack.capacity() > initialCapacity);
    
    while (stack.size() > initialCapacity / 2) {
      stack.deleteElement();
    }
    assertTrue(stack.capacity() <= initialCapacity);
  }
}
