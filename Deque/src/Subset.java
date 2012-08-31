
public class Subset {
    public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        d.addFirst("prvni");
        d.addFirst("druhy");
        d.addLast("posledni");
        d.addFirst("treti");
        System.out.println("rf: " + d.removeLast());
        d.printAll();
    }
    
}
