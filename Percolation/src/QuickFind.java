

public class QuickFind extends ConnectionProblemSolver{
	
    public QuickFind(int size) {
	super(size);
    }

    @Override
    public void union(int p, int q) {
	if (connected(p,q))
	    return;
	int pp = id[p];		
	for (int i = 0 ; i < id.length ; i++)
	    if (id[i] == pp)
		id[i] = id[q];
    }

    @Override
    public boolean connected(int p, int q) {
	//System.out.println(p + " " + q);
	return id[p] == id[q];
    }
}
