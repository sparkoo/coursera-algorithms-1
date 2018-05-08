import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
        
        public Item getItem() { return item; }
        public Node getNext() { return next; }
        public Node getPrev() { return prev; }
        public void setItem(Item i) { this.item = i; }
        public void setNext(Node n) { this.next = n; }
        public void setPrev(Node p) { this.prev = p; }
    }

    public Deque() {
        // construct an empty deque
        first = null;
        last = null;
    }
    public boolean isEmpty() {
        // is the deque empty?
        if (first == null)
            return true;
        return false;
    }
    public int size() {
        // return the number of items on the deque
        if (isEmpty()) return 0;
        int count = 1;
        Node n = first;
        while (n != last) {
            count++;
            n = n.next;
        }
        return count;
    }
    public void addFirst(Item item) {
        // insert the item at the front
        if (item == null) throw new java.lang.NullPointerException();
        Node n = new Node();
        n.item = item;
        if (first != null) {
            n.next = first;
            first.prev = n;
            n.prev = null;
        first = n;
        } else {
            first = n;
            last = n;
            n.prev = null;
            n.next = null;
        }
    }    
    public void addLast(Item item) {
        // insert the item at the end
        if (item == null) throw new java.lang.NullPointerException();
        Node n = new Node();
        n.item = item;
        if (last != null) {
            n.prev = last;
            last.next = n;
            n.next = null;
            last = n;
        } else {
            first = n;
            last = n;
            n.prev = null;
            n.next = null;
        }
    }
    public Item removeFirst() {
        // delete and return the item at the front
        if (first == null) throw new java.util.NoSuchElementException();
        Item n = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        return n;
    }
    public Item removeLast() {
        // delete and return the item at the end   
        if (last == null) throw new java.util.NoSuchElementException();
        Item n = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        return n;
    }
    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
    
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (current == null) throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}