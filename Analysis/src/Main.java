import java.lang.Math;

public class Main {
	public static void main(String[] args) {

		for (int N = 1; N < 1000000000; N*=2) {
			//Stopwatch stop = new Stopwatch();
			int sum = 0;
			for (int i = 1; i*i <= N; i = i*4)
			    sum++;
			System.out.println(N + " : " + sum);
		}

		double a = 6.5;
		
		double ratio = 1;
		double time = 1;
		double b;
		b = Math.log(8) / Math.log(2);
		System.out.println("test log2 = " + b);
		
		for (int i = 1; i < 1000000; i *= 2) {
			Stopwatch stop = new Stopwatch();
			Timing.trial(i, 146944);
			//System.out.println(i + " -> " + stop.elapsedTime());
			ratio = stop.elapsedTime() / time;
			time = stop.elapsedTime();
			//System.out.println("ratio = " + ratio);
			b = Math.log(ratio) / Math.log(2);
			System.out.println("b = " + b);
			
		}
	}
	public static double logOfBase(double base, double num) {  
	    return Math.log(num) / Math.log(base);  
	}
}
