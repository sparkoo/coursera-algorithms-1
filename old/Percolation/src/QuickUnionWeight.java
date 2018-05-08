

public class QuickUnionWeight extends QuickUnion {
    private int[] weight;

    public QuickUnionWeight(int size) {
	super(size);

	weight = new int [size];
	for (int i = 0 ; i < size ; i++)
	    weight[i] = 1;
    }

    @Override
    public void union(int p, int q) {
	int i = root(p);
	int j = root(q);
	if (p == q) return;
	if (weight[i] > weight[j]) {
	    id[i] = id[j];
	    weight[i] += weight[j];
	}else{
	    id[j] = id[i];
	    weight[j] += weight[i];
	}
    }
}
