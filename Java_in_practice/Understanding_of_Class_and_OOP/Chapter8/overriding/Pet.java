/*
 * 오버라이딩 : 오버라이딩이란 상속된 메서드와 동일한 이름, 동일한 인수를 가지는 메서드를 정의하여 메서드를 덮어쓰는 것이다.
 * 반환값의 형도 같아야만 한다.
 * 
 * 오버라이드는 상속 받은 메서드를 하위 클래스에서 단순히 재사용하지 않고 재정의하여 다른 연산을 수행하고 싶을때 사용한다.
 * 즉 하위 클래스에서 상위 클래스의 특정 메서드를 다시 정의하는 것이다.
 * - 기능의 변경
 * - 기능의 추가
 * 
 * 오버라이드는 많은 객체지향 디자인 패턴에 매우 자주 사용되는 기법이다. 오버라이드는 추상 클래스와 합쳐져서 객체지향 방법론에서
 * 장점으로 많이 거론되는 확장성을 실현하는데 많은 도움을 주게 되므로, 오버라이드 개념에 대한 이해는 필수적이다.
 * 
 * 오버라이딩과 오버로딩 구분
 * 오버라이딩 : 상속의 관계에서 발생한다. 부모에서 자식으로 연결된다.
 * 오버로딩 : 한 클래스 내에서 동일한 이름의 메서드가 여러개 존재한다. 모든 메서드가 수평적인 관계이다.
 * 
 */

package overriding;

class Animal {
	String name;
	int age;
	
	void printPet() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}

class Dog extends Animal {
	String variety;
	
	// 함수의 오버라이딩
	void printPet() {
		super.printPet();
		System.out.println("종류 : " + variety);
	}
}

public class Pet {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "진돌이";
		dog.age = 5;
		dog.variety = "진돗개";
		dog.printPet();
	}
}
