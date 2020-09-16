package assg2b;

import java.util.ArrayList;
import java.util.List;

interface Employee {
	public void weeklySalary();

	public void setRate(double rate);

	public void increaseSalary(float percent);
}

class SalriedEmployee implements Employee {
	private int noOfWeeks;
	private double rate;

	SalriedEmployee(int noOfWeeks,double rate) {
		this.noOfWeeks = noOfWeeks;
		this.rate=rate;
	}

	@Override
	public void weeklySalary() {
		System.out.println("Weekly salary: " + rate);
	}

	@Override
	public void setRate(double rate) {
		this.rate=rate;
	}

	@Override
	public void increaseSalary(float percent) {
		rate=rate+((rate*percent)/100);
	}

}

class HourlyEmployee implements Employee {
	private float noOfHours;
	private double rate;

	HourlyEmployee(float noOfHours, double rate) {
		this.noOfHours = noOfHours;
		this.rate = rate;
	}

	@Override
	public void weeklySalary() {
		System.out.println("Weekly salary: " + rate * noOfHours);
	}

	@Override
	public void setRate(double rate) {
		this.rate=rate;
	}

	@Override
	public void increaseSalary(float percent) {
		rate=rate+((rate*percent)/100);
	}

}

class CommisionEmployee implements Employee {
	private double a;
	private double b;

	CommisionEmployee(double a, double b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void weeklySalary() {
		System.out.println("Weekly salary: " + ((a/b)*100*100));
	}

	@Override
	public void setRate(double rate) {
		this.a=rate;
	}

	@Override
	public void increaseSalary(float percent) {
		a=a+((a*percent)/100);
	}

}

public class EmployeeRecordSystem {

	public static void main(String[] args) {
		
		List<SalriedEmployee> se=new ArrayList<SalriedEmployee>();
		
		se.add(new SalriedEmployee(5, 10000));
		se.add(new SalriedEmployee(7, 12000));
		se.add(new SalriedEmployee(2, 11000));
		se.add(new SalriedEmployee(3, 16000));
		
		System.out.println("Salried Employee");
		for(SalriedEmployee temp:se) {
			temp.weeklySalary();
		}
		
		List<HourlyEmployee> he=new ArrayList<HourlyEmployee>();
		
		he.add(new HourlyEmployee(10.5F, 1000));
		he.add(new HourlyEmployee(7F, 12000));
		he.add(new HourlyEmployee(2.5F, 11000));
		he.add(new HourlyEmployee(13F, 1600));
		
		System.out.println("Hourly Employee");
		for(HourlyEmployee temp:he) {
			temp.weeklySalary();
		}
		
		List<CommisionEmployee> ce=new ArrayList<CommisionEmployee>();
		
		ce.add(new CommisionEmployee(10.5, 15));
		ce.add(new CommisionEmployee(7, 9));
		ce.add(new CommisionEmployee(2, 11));
		ce.add(new CommisionEmployee(13, 16));
		
		System.out.println("Commision Employee");
		for(CommisionEmployee temp:ce) {
			temp.weeklySalary();
		}
		
	}

}
