package assg2;

class Circle{
	private double radius;
	private String color;
	
	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	public Circle(double r) {
		this.radius=r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
}

public class CircleUML {

	public static void main(String[] args) {
		Circle c=new Circle();
		System.out.println(c.getRadius());
		System.out.println(c.getArea());
		
		Circle c1=new Circle(3.5);
		System.out.println(c1.getRadius());
		System.out.println(c1.getArea());

	}

}
