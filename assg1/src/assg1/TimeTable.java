package assg1;

class Table{
	
	public void printTable() {
		System.out.print("* |");
		
		for(int i=1;i<10;i++)
			System.out.print(" "+ i);
			System.out.println();
			System.out.println("---------------------------");
		for(int i=1;i<10;i++ )
		{
			System.out.print(i +" |");
			for(int j=1;j<10;j++)
			{
				System.out.print(" "+i*j);
			}
			System.out.println();
		}
	}
}

public class TimeTable {

	public static void main(String[] args) {
		Table tab= new Table();
		tab.printTable();
	}

}
