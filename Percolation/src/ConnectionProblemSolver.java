public abstract class ConnectionProblemSolver {
	protected int[] id;
	
	public ConnectionProblemSolver(int size) {
		id = new int [size];
		for (int i = 0 ; i < size ; i++)
			id[i] = i;
	}
	
	public void print() {
		for (int i = 0 ; i < id.length ; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = 0 ; i < id.length ; i++) {
			System.out.print(id[i] + " ");
		}
		System.out.println("\n==============");
	}
	
	abstract public void union(int p, int q);
	abstract public boolean connected(int p, int q);
}
