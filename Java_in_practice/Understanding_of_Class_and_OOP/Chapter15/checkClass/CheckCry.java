/*
 * instanceof : 해당 오브젝트가 지정한 클래스의 오브젝트인지를 조사하기 위한 연산자이다.
 * boolean flag = c instanceof X;
 * 여기서 c 는 오브젝트명이고, X 는 클래스명이다.
 * 왼쪽 오브젝트가 오른쪽 클래스 또는 서브 클래스의 오브젝트라면 true 를 반환한다.
 * 
 * instanceof 는 클래스 뿐만 아니라, 지정한 인터페이스를 오브젝트가 구현하고 있는지를 조사할 수도 있다.
 * boolean flag = c instanceof Y;
 * 여기서 c 는 오브젝트명이고, Y 는 인터페이스명이다.
 * 왼쪽 오브젝트가 오른쪽 인터페이스를 구현하고 있으면 true 를 반환한다.
 */

package checkClass;

interface Cry {
	void cry();
}

class Cat implements Cry {
	public void cry() {
		System.out.println("야옹");
	}
}

class Dog implements Cry {
	public void cry() {
		System.out.println("멍멍");
	}
}

public class CheckCry {

	public static void main(String[] args) {
		Cry test1 = new Cat();
		// Cry test1 = new Dog();
		
		if (test1 instanceof Cat) { // test1 은 Cat 클래스의 생성자로 생성한 인스턴스이다. 즉 슈퍼 클래스인 Cry 타입 변수이지만
			// 해당 변수가 가리키는 인스턴스는 Cat 타입 인스턴스이다. 따라서 test1 은 Cat 클래스의 인스턴스이기 때문에 true 를 반환한다.
			// 반면에 Dog 클래스의 생성자로 생성된 인스턴스일 경우, 이는 Cat 타입 인스턴스가 아닌 Dog 타입 인스턴스이기 때문에 false 를 반환한다.
			test1.cry();
		} else {
			System.out.println("고양이가 아닙니다.");
		}
	}
}
