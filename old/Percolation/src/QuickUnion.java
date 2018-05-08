

public class QuickUnion extends ConnectionProblemSolver{
	public QuickUnion(int size) {
		super(size);
	}
	
	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (p == q) return;
		id[i] = id[j];
	}
	
	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	protected int root(int p) {
		while(id[p] != p)
			p = id[p];
		return p;
	}
}
