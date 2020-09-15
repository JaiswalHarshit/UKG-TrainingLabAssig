package assg1;

import java.util.Scanner;

class Grades{
	private int numStudents;
	private int grades[];
	
	Grades(int numStudents){
		this.numStudents=numStudents;
		grades=new int[numStudents];
	}
	
	public void getGrades() {
		for(int i=0;i<numStudents;i++)
		{
			Scanner grade = new Scanner(System.in);
			System.out.printf("Enter the grade of student %d :", i+1);
			int check = grade.nextInt();
			if(check>=0 && check<=100)
				grades[i]=check;
			else {
				
				System.out.println("Invalid grade, try again..");
				i--;
				continue;
			}
		}
	}
	
	public void getAverage() {
		double sum=0;
		for(int i=0;i<numStudents;i++) {
			sum=sum+grades[i];
		}
		System.out.println("The average is: "+ sum/numStudents);
	}
	
	
}

public class GradesAverage {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the numbe of students: ");
		
		int numStudents=input.nextInt();
		System.out.println(numStudents);
		
		Grades gr = new Grades(numStudents);
		gr.getGrades();
		gr.getAverage();
		
		

	}

}