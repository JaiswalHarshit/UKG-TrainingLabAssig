package assg2;

import java.util.Scanner;

class Vehicle {
	private int noOfWheel;
	private int noOfPassenger;
	protected int model;
	protected String make;

	Vehicle(int noOfWheel, int noOfPassenger, int model, String make) {
		this.noOfWheel = noOfWheel;
		this.noOfPassenger = noOfPassenger;
		this.model = model;
		this.make = make;
	}

	public void display() {
		System.out.println("Make: " + make + " Model: " + model + " noOfWheel :" + noOfWheel + " noOfPassenger: " + noOfPassenger);
	}
}

class Car extends Vehicle {
	protected int noOfDoor;

	public Car(int noOfWheel, int noOfPassenger, int model, String make, int noOfDoor) {
		super(noOfWheel, noOfPassenger, model, make);
		this.noOfDoor = noOfDoor;
	}

	public void display() {
		System.out.println("Make: " + make + " Model: " + model + " noOfDoor :" + noOfDoor);
	}
}

class Convertible extends Car {
	private boolean isHoodOpen;

	public Convertible(int noOfWheel, int noOfPassenger, int model, String make, int noOfDoor, boolean isHoodOpen) {
		super(noOfWheel, noOfPassenger, model, make, noOfDoor);
		this.isHoodOpen = isHoodOpen;
	}

	public void display() {
		System.out.println(
				"Make: " + make + " Model: " + model + " noOfDoor :" + noOfDoor + " isHoodOpen :" + isHoodOpen);
	}
}

class SportCar extends Car {
	SportCar(int noOfWheel, int noOfPassenger, int model, String make) {
		super(noOfWheel, noOfPassenger, model, make, 2);
	}
}

public class Overriding {

	public static void main(String[] args) {
		System.out.println("Enter “1”, to crate Vehicle object");
		System.out.println("Enter “2”, to create Car object");
		System.out.println("Enter “3”, to create Convertible object");
		System.out.println("Enter “4”, to create SportCar object");

		
		Scanner input = new Scanner(System.in);
		int ch = input.nextInt();
		
		switch (ch) {
		case 1:
			System.out.println("Enter noOfWheel,noOfPassenger,model and make");
			int nw=input.nextInt();
			int np=input.nextInt();
			int model=input.nextInt();
			String make=input.next();
			Vehicle v= new Vehicle(nw,np,model,make);
			v.display();
			break;
		case 2:
			System.out.println("Enter noOfWheel,noOfPassenger,model,make and noOfDoor");
			int nw2=input.nextInt();
			int np2=input.nextInt();
			int model2=input.nextInt();
			String make2=input.next();
			int nd=input.nextInt();
			Car c= new Car(nw2,np2,model2,make2,nd);
			c.display();
			break;
		case 3:
			System.out.println("Enter noOfWheel,noOfPassenger,model,make,noOfDoor and isHoodOpen");
			int nw3=input.nextInt();
			int np3=input.nextInt();
			int model3=input.nextInt();
			String make3=input.next();
			int nd2=input.nextInt();
			boolean ho=input.nextBoolean();
			Convertible cb= new Convertible(nw3,np3,model3,make3,nd2,ho);
			cb.display();
			break;
		case 4:
			System.out.println("Enter noOfWheel,noOfPassenger,model and make");
			int nw4=input.nextInt();
			int np4=input.nextInt();
			int model4=input.nextInt();
			String make4=input.next();
			SportCar sc= new SportCar(nw4,np4,model4,make4);
			sc.display();
			break;
		default:
			System.out.println("Wrong Input.....");
		}

	}

}
