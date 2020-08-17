package com.company.Lesson_8;


public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(String val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            tail.setPrev(null);
            size++;
            return;
        }

        Node prev = tail;
        Node newNode = new Node(val);
        tail.setNext(newNode );
        tail = newNode;
        tail.setPrev(prev.getValue());
        size++;
    }

    public void add(int index, String val) {
        if (index > size) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, size));
        }

        if (index == 0) {
            if (head == null) {
                add(val);
            } else {
                head.setValue(val);
            }
            tail.setPrev(null);
            return;
        }

        int currentIndex = 1;
        Node current = head.getNext();

        while (currentIndex != index) {
            current = current.getNext();
            currentIndex++;
        }

        if (current == null) {
            add(val);
        } else {
            current.setValue(val);
//            current.getNext().setPrev(current);
            current.getNext().setPrev(current.getValue());
        }
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new Iterator(head);
    }

    /**
     * @deprecated breaks performance because has linier complexity
     * Will go thru all elements before find last one
     */
//    private void add(String val, Node prev, Node current) {
//        if (current == null) {
//            prev.setNext(new Node(val));
//            return;
//        }
//        add(val, current, current.getNext());
//    }

    private static class Node {
        private String value;
        private Node next;
//        private Node prev;
        private String prev;

        public Node(String value) {
            this.value = value;
        }

//        public Node(Node prev, String value, Node next) {
//            this.value = value;
//            this.next = next;
//            this.prev = prev;
//        }
        public Node(String prev, String value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

//        public Node getPrev() {
//            return prev;
//        }
        public String getPrev() {
            return prev;
        }

//        public void setPrev(Node prev) {
//            this.prev = prev;
//        }
        public void setPrev(String prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OneDirectionalList{" +
                "head=" + head +
                '}';
    }

    public static class Iterator {
        private Node head;
        private Node current;

        private Iterator() {
        }

        private Iterator(Node current) {

            this.head = current;
        }

        public boolean hasNext() {
            if (current == null) {
                return head != null;
            }
            return current.getNext() != null;
        }

        public String next() {
            if (current == null) {
                current = head;
            } else {
                current = current.getNext();
            }
            return current.getValue();
        }
    }
}
