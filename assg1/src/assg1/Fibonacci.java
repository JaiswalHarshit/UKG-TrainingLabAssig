package assg1;

class Fibo{
	private int a;
	private int b;
	private int c;
	double sum;
	
	Fibo()
	{
		a=1;
		b=1;
		sum=2;
		System.out.println("The first 20 Fibonacci numbers are:");
		System.out.print(a+" ");
		System.out.print(b+" ");
	}

	
	public void series() {
		for(int i=2;i<20;i++)
		{ 
			c=a+b;
			sum=sum+c;
			System.out.print(c+" ");
			a=b;
			b=c;
			
		}
	}
	public void printAvg()
	{
		System.out.println("");
		System.out.println("The average is: " + sum/20);
	}
}

public class Fibonacci {

	public static void main(String[] args) {
		Fibo fib = new Fibo();
		fib.series();
		fib.printAvg();

	}

}
