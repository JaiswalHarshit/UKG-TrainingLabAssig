package assg2b;

import java.util.ArrayList;
import java.util.List;

interface Payable{
	public double getPayment();
}

class Invoice implements Payable{

	private String partNum;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

	@Override
	public double getPayment() {
		System.out.println("PartNumber: "+partNum);
		System.out.println("PartDescription: "+partDescription);
		System.out.println("quantity: "+quantity);
		System.out.println("PricePerItem: "+pricePerItem);
		
		return quantity*pricePerItem;
	}
	
}

abstract class Employee2 implements Payable{

	protected double salary;
	
	abstract public double getSalary();
	abstract public void setSalary(double salary);
	
}

class SalriedEmp extends Employee2{
	private int noOfWeeks;
	private double rate;
	
	SalriedEmp(int noOfWeeks,double rate) {
		this.noOfWeeks = noOfWeeks;
		this.rate=rate;
	}
	@Override
	public double getPayment() {
		
		return rate*noOfWeeks;
	}

	@Override
	public double getSalary() {
		
		return rate;
	}

	@Override
	public void setSalary(double rate) {
		this.rate=rate;
		
	}
	
}

class HourlyEmp extends Employee2{

	private float noOfHours;
	private double rate;

	HourlyEmp(float noOfHours, double rate) {
		this.noOfHours = noOfHours;
		this.rate = rate;
	}
	
	@Override
	public double getPayment() {
		
		return rate*noOfHours;
	}

	@Override
	public double getSalary() {
		
		return rate*noOfHours*7;
	}

	@Override
	public void setSalary(double rate) {
		this.rate=rate;
	}
	
}

class CommissionEmp extends Employee2{

	private double a;
	private double b;

	CommissionEmp(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double getPayment() {
		return ((a/b)*100*100);
		
	}

	@Override
	public double getSalary() {
		return ((a/b)*100*100)*7;
	}

	@Override
	public void setSalary(double a) {
		this.a=a;
	}
	
}

public class PaymentSystem {

	public static void main(String[] args) {
		
List<SalriedEmp> se=new ArrayList<SalriedEmp>();
		
		se.add(new SalriedEmp(5, 10000));
		se.add(new SalriedEmp(7, 12000));
		se.add(new SalriedEmp(2, 11000));
		se.add(new SalriedEmp(3, 16000));
		
		System.out.println("Salried Employee");
		for(SalriedEmp temp:se) {
			System.out.println(temp.getPayment());
		}
		
List<HourlyEmp> he=new ArrayList<HourlyEmp>();
		
		he.add(new HourlyEmp(5, 10000));
		he.add(new HourlyEmp(7, 12000));
		he.add(new HourlyEmp(2, 11000));
		he.add(new HourlyEmp(3, 16000));
		
		System.out.println("Hourly Employee");
		for(HourlyEmp temp:he) {
			System.out.println(temp.getPayment());
		}
		
List<CommissionEmp> ce=new ArrayList<CommissionEmp>();
		
		ce.add(new CommissionEmp(5, 10000));
		ce.add(new CommissionEmp(7, 12000));
		ce.add(new CommissionEmp(2, 11000));
		ce.add(new CommissionEmp(3, 16000));
		
		System.out.println("Commission Employee");
		for(CommissionEmp temp:ce) {
			System.out.println(temp.getPayment());
		}
		
		Invoice i=new Invoice();
		i.setPartNum("Abc123");
		i.setPartDescription("new Part");
		i.setQuantity(7);
		i.setPricePerItem(4500);
		System.out.println("-----------------------");
		System.out.println(i.getPayment());
	}

}
