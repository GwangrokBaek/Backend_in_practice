/*
 * 추상 클래스 : 처리 내용을 기술하지 않고, 호출하는 방법만을 정의한 메서드를 추상 메서드라고 한다.
 * 이때 추상 메서드를 한개라도 가진 클래스를 추상 클래스라고 한다.
 * 
 * 추상 메서드, 추상 클래스는 abstract 라는 수식자를 사용하여 정의한다.
 * 
 * 추상 클래스와 오버라이딩
 * 추상 클래스를 상속하는 클래스는 추상 메서드를 반드시 오버라이딩해서 구현해야 한다.
 * 
 * 추상 클래스의 이해와 사용
 * 추상 메서드 선언 : 슈퍼 클래스 (추상 클래스) 에서 기능은 하지 않지만 만들어야 할 메서드를 기술해 놓는다.
 * 추상 메서드 구현 : 서브 클래스 (구상 클래스) 에서 상속받은 메서드를 고객의 취향에 맞게 구현한다.
 * 고객이 말하지 않아도 추상 클래스는 무조건 구현해야 하기 때문에 까먹고 안 만들 일이 없다.
 */

package abstractClass;

abstract class Animal {
	int age;
	abstract void cry();
}

class Dog extends Animal {
	void cry() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {
	void cry() {
		System.out.println("야옹");
	}
}

public class AbstractClassEx {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.cry();
		
		Cat cat = new Cat();
		cat.cry();
	}

}
