/*
 * 클래스 정의 대상의 public 과 default 선언이 갖는 의미
 * public : 어디서든 인스턴스 생성이 가능하다.
 * default : 동일 패키지로 묶인 클래스 내에서만 인스턴스 생성을 허용한다.
 * 
 * 인스턴스 멤버 대상의 접근 제한자 선언
 * private : 클래스 내부
 * default : 클래스 내부, 동일 패키지
 * protected : 클래스 내부, 동일 패키지, 상속 받은 클래스
 * public : 클래스 내부, 동일 패키지, 상속 받은 클래스, 이외의 영역
 */

package team1;

public class AnotherClass1 {
	public int num1;
	private int num2;
	protected int num3;
	int num4;
	
	public void test1() { System.out.println("test1"); }
	private void test2() { System.out.println("test2"); }
	protected void test3() { System.out.println("test3"); }
	void test4() { System.out.println("test4"); }
}
