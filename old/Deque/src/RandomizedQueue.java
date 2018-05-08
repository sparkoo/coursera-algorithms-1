import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int N;
    private int capacity;
    public RandomizedQueue() {
       // construct an empty randomized queue
       N = 0;
       capacity = 1;
       queue = (Item[]) new Object[capacity];
   }
   public boolean isEmpty() {
       // is the queue empty?
       return N == 0;
   }
   public int size() {
       // return the number of items on the queue
       return N;
   }
   public void enqueue(Item item) {
       // add the item
       if (item == null) throw new java.lang.NullPointerException();
       if (N + 1 > capacity) {
           resizePlus();
       }
       queue[N++] = item;
   }
   private void resizePlus() {
       capacity *= 2;
       Item[] newQueue = (Item[]) new Object[capacity];
       int index = 0;
       for (Item i : queue) {
           newQueue[index++] = i;
       }
       queue = newQueue;
   }
   private void resizeMinus() {
       capacity /= 2;
       Item[] newQueue = (Item[]) new Object[capacity];
       int index = 0;
       for (int i = 0; i < capacity; i++) {
           newQueue[index++] = queue[i];
       }
       queue = newQueue;
   }
   public Item dequeue() {
       // delete and return a random item
       if (isEmpty()) throw new java.util.NoSuchElementException();
       int i = StdRandom.uniform(N);
       Item ret = queue[i];
       queue[i] = queue[--N];
       queue[N] = null;
       if (capacity / 4 > N) {
           resizeMinus();
       }
       return ret;
   }
   public Item sample() {
       // return (but do not delete) a random item
       if (isEmpty()) throw new java.util.NoSuchElementException();
       return queue[StdRandom.uniform(N)];
   }
   public Iterator<Item> iterator() {
       // return an iterator over items in order from front to end
       return new ListIterator();
   }
   private class ListIterator implements Iterator<Item> {
       private int current = 0;
       private int[] shuffledIndexes = new int[N];
       
       public boolean hasNext() {
           if (current == 0) {
               for (int i = 0; i < N; i++)
                   shuffledIndexes[i] = i;
               StdRandom.shuffle(shuffledIndexes);
           }
           return current < N;
       }
       public Item next() {
           if (current == 0) {
               for (int i = 0; i < N; i++)
                   shuffledIndexes[i] = i;
               StdRandom.shuffle(shuffledIndexes);
           }
           if (current >= N || size() == 0) throw new java.util.NoSuchElementException();
           return queue[shuffledIndexes[current++]];
       }
       public void remove() {
           throw new java.lang.UnsupportedOperationException();
       }
   }
}