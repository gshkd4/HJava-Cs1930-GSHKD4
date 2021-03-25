package hu.elte.haladojava.generic;

import java.util.ArrayList;

public class Stack<T> {
    private final ArrayList<T> elements;
    private final int capacity;

    public Stack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity cannot be negative: " + capacity);
        }

        this.capacity = capacity;
        this.elements = new ArrayList<>();
    }

    public void push(T element) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("the stack is full, element cannot be pushed");
        }

        elements.add(element);
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("the stack is empty, there is no element to pop");
        }

        T element = elements.get(elements.size() - 1);
        elements.remove(element);
        return element;
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean isFull() {
        return capacity <= elements.size();
    }
}