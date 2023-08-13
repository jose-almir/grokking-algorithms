package arrays_and_lists;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedList {
    private static final Logger LOGGER = Logger.getLogger(LinkedList.class.getName());

    private static class Node {
        private int value;
        private Node next = null;
        private Node prev = null;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            String prevRep = prev != null ? String.valueOf(getPrev().hashCode()) : null;
            String nextRep = next != null ? String.valueOf(getNext().hashCode()) : null;
            return "Node{" +
                    "value=" + value +
                    ", next=" + nextRep +
                    ", prev=" + prevRep +
                    ", hash=" + hashCode() +
                    '}';
        }
    }

    private Node head = null;
    private Node tail = null;

    private int size;

    public void append(int value) {
        if (head == null) {
            head = new Node(value, null, null);
            tail = head;
        } else {
            Node node = new Node(value, null, tail);
            tail.next = node;
            tail = node;
        }
        ++size;
    }

    public void pop() {
        if (tail == null) {
            return;
        }

        if (tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }
        --size;
    }

    public int at(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Invalid index");

        if (index == 0) return head.value;
        if (index == size - 1) return tail.value;

        int currentIndex = 1;
        int element = 0;

        Node current = head.getNext();

        while (current != null) {
            if (currentIndex == index) {
                element = current.value;
                break;
            }
            current = current.getNext();
            currentIndex++;
        }

        return element;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        Node current = head;
        sb.append("  ").append(current);
        current = current.getNext();

        while (current != null) {
            sb.append(",\n  ").append(current);
            current = current.getNext();
        }

        sb.append("\n]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        LOGGER.log(Level.INFO, "Items inside the linked list O(n): {0}", l1);
        LOGGER.log(Level.INFO, "Item a the specified index O(n): {0}", l1.at(3));
    }
}
