package ru.mos.qa.testtasks;

public class DynamicStack {
  private int[] stackArray;
  private int top;
  private static final int INITIAL_SIZE = 4;

  public DynamicStack() {
    this.stackArray = new int[INITIAL_SIZE];
    this.top = -1;
  }

  public DynamicStack(int initialSize) {
    this.stackArray = new int[initialSize];
    this.top = -1;
  }

  public void addElement(int element) {
    if (isFull()) {
      expand();
    }
    stackArray[++top] = element;
  }

  public int deleteElement() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    int element = stackArray[top--];
    if (shouldShrink()) {
      shrink();
    }
    return element;
  }

  public int readTop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stackArray[top];
  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public boolean isFull() {
    return (top == stackArray.length - 1);
  }

  public int size() {
    return top + 1;
  }

  public int capacity() {
    return stackArray.length;
  }

  private void expand() {
    int newSize = stackArray.length * 2;
    int[] newArray = new int[newSize];
    System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
    stackArray = newArray;
  }

  private boolean shouldShrink() {
    return stackArray.length > INITIAL_SIZE && 
           top < stackArray.length / 2 && 
           top >= 0;
  }

  private void shrink() {
    int newSize = stackArray.length / 2;
    int[] newArray = new int[newSize];
    System.arraycopy(stackArray, 0, newArray, 0, top + 1);
    stackArray = newArray;
  }
}
