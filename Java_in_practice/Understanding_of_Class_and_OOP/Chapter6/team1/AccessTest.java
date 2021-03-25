package team1;

import team2.AnotherClass2;

public class AccessTest {
	public int num1;
	private int num2;
	protected int num3;
	int num4;
	
	public void test1() { System.out.println("test1"); }
	private void test2() { System.out.println("test2"); }
	protected void test3() { System.out.println("test3"); }
	void test4() { System.out.println("test4"); }
	
	public static void main(String[] args) {
		AccessTest at = new AccessTest();
		// 동일 클래스 내부에서는 접근 제한자에 상관없이 접근 가능.
		at.num1 = 1;
		at.num2 = 2;
		at.num3 = 3;
		at.num4 = 4;
		
		AnotherClass1 ac1 = new AnotherClass1();
		ac1.num1 = 1;
		// ac1.num2 = 2; private 변수는 동일 클래스 내부에서만 사용 가능.
		ac1.num3 = 3;
		ac1.num4 = 4;
		
		AnotherClass2 ac2 = new AnotherClass2();
		ac2.num1 = 1;
		// 다른 패키지에서도 접근 가능한 것은 public 만 가능.
		// ac2.num2 = 2;
		// ac2.num3 = 3;
		// ac2.num4 = 4;
	}
}
