
public class A_CircleUsing {

	public static void main(String[] args) {
		team1.Circle c1 = new team1.Circle();
		c1.setRad(3.5);
		System.out.println("반지름 3.5 원 넓이: " + c1.getArea());
		
		team2.Circle c2 = new team2.Circle();
		c2.setRad(3.5);
		System.out.println("반지름 3.5 원 둘레: " + c2.getPerimeter());
	}
}
