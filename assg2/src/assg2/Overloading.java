package assg2;

import java.util.Scanner;

class Student{
	private String name;
	private String id;
	private double grade;
	
	Student(String name, String id, double grade) {
		this.name = name;
		this.id = id;
		this.grade = grade;
	}
	
	Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	Student(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("Name:"+name+" Id: "+id+" Grade: "+grade);
	}
	
	public void display(int year) {
		System.out.println("Name:"+name+" Id: "+id+" Grade: "+grade+" Year: "+year);
	}
	
}

public class Overloading {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Student s=null;
		System.out.println("Enter “1”, to Enter Name, Id and Grade");
		System.out.println("Enter “2”, to Enter Name and Id");
		System.out.println("Enter “3”, to Enter Name");
		
		int ch=in.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter Name, Id and Grade");
			String name=in.next();
			String id=in.next();
			double grade=in.nextDouble();
			s=new Student(name,id,grade);
			System.out.println("Record inserted.....");
			break;
		case 2:
			System.out.println("Enter Name, Id");
			String name2=in.next();
			String id2=in.next();
			s=new Student(name2,id2);
			System.out.println("Record inserted.....");
			break;
		case 3:
			System.out.println("Enter Name");
			String name3=in.next();
			s=new Student(name3);
			System.out.println("Record inserted.....");
			break;
		default:
			System.out.println("Wrong input..");
		}
		
		System.out.println("Enter-1 to input year and Enter-2 to not input year");
		int c=in.nextInt();
		if(c==2) {
			s.display();
		}
		else if(c==1) {
			System.out.println("Enter year");
			int year=in.nextInt();
			s.display(year);
		}
		
	}

}
