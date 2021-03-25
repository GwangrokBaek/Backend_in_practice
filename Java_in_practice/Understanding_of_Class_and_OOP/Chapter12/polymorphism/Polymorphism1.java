/*
 * 다형성 (Polymorphism)
 * 상속한 클래스의 오브젝트는 슈퍼 클래스로도, 서브 클래스로도 다룰 수 있다. 이렇게 하나의 오브젝트와 메서드가 많은 형태를 가지고 있는 것을
 * 다형성이라고 한다.
 * 
 * 슈퍼 클래스의 오브젝트 생성 (업캐스팅)
 * 서브 클래스의 오브젝트는 슈퍼 클래스의 오브젝트에 대입할 수 있다.
 * Super a = new Sub();
 * 하지만 슈퍼 클래스의 오브젝트를 서브 클래스의 오브젝트에 대입할 수는 없다.
 * 생성된 오브젝트에는 서브 클래스에서 새롭게 정의한 변수가 없기 때문에 에러가 발생하기 때문이다. 
 */

package polymorphism;

abstract class Calc {
	int a = 5;
	int b = 6;
	
	abstract void plus();
}

class MyCalc extends Calc {
	void plus() { System.out.println(a + b); }
	void minus() { System.out.println(a - b); }
}

public class Polymorphism1 {

	public static void main(String[] args) {
		MyCalc myCalc1 = new MyCalc();
		myCalc1.plus();
		myCalc1.minus();
		
		// 하위 클래스 객체를 상위 클래스 객체에 대입
		Calc myCalc2 = new MyCalc();
		myCalc2.plus();
		// minus() 메서드는 하위 클래스에만 정의되어 있으므로 상위 클래스 타입 변수에서 참조 불가능. 메모리 상에는 존재하지만 접근 불가능.
		// Calc myCalc2 는 상위 클래스 타입의 참조 변수로 스택 영역에 위치. 이때 하위 클래스에 의해 생성된 인스턴스는 하위 클래스의 객체로서
		// 힙 영역에 위치한다.
		// myCalc2.minus();
	}
}
