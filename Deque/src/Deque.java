import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	
	private class Node {
	    Item item;
	    Node next;
	    Node prev;
	}
	
    public Deque() {
        // construct an empty deque
        first = last;
        last = first;
    }
    public boolean isEmpty() {
        // is the deque empty?
        if (first == last)
            return true;
        return false;
    }
    public int size() {
        // return the number of items on the deque
        int count = 0;
        Node n = first;
        while(n != last) {
            count++;
            n = n.next;
        }
        return count;
    }
    public void addFirst(Item item) {
        // insert the item at the front
        Node n = new Node();
        n.item = item;
        n.next = first;
        n.prev = null;
        first = n;
    }    
    public void addLast(Item item) {
        // insert the item at the end
        Node n = new Node();
        n.item = item;
        n.next = null;
        n.prev = last;
        last = n;
    }
    public Item removeFirst() {
        // delete and return the item at the front
        Node n = first;
        first = first.next;
        first.prev = null;
        return n.item;
    }
    public Item removeLast() {
        // delete and return the item at the end
        Node n = last;
        last = last.prev;
        last.next = null;
        return n.item;
        
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
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    public void printAll() {
        for (Item i : this) {
            System.out.println(i);
        }
    }
}