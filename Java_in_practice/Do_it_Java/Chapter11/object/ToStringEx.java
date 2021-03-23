// java.lang 패키지
// 프로그래밍시 import 하지 않아도 자동으로 import 된다.
// import java.lang.*; 문장이 추가 된다.
// String, Integer, System 등 많이 사용하는 기본 클래스들이 속한 패키지이다.

// Object 클래스
// 모든 클래스의 최상위 클래스이다.
// java.lang.Object 클래스이다.
// 모든 클래스는 Object 클래스에서 상속 받는다.
// 모든 클래스는 Object 클래스의 메서드를 사용할 수 있다.
// 모든 클래스는 Object 클래스의 메서드 중 일부를 재정의할 수 있다. (final로 선언된 메서드는 재정의할 수 없다.)
// 컴파일러가 extends Object를 자동으로 추가한다.

// Object 클래스 메서드
// String toString() : 객체를 문자열로 표현하여 반환한다. 재정의하여 객체에 대한 설명이나 특정 멤버 변수 값을 반환한다.
// boolean equals(Object obj) : 두 인스턴스가 동일한지에 대한 여부를 반환한다. 재정의하여 논리적으로 동일한 인스턴스임을
// 정의할 수 있다.
// int hashCode() : 객체의 해시코드 값을 반환한다.
// Object clone() : 객체를 복제하여 동일한 멤버 변수 값을 가진 새로운 인스턴스를 생성한다.
// Class getClass() : 객체의 Class 클래스를 반환한다.
// void finalize() : 인스턴스가 힙 메모리에서 제거될 때 가비지 컬렉터 (GC) 에 의해 호출되는 메서드이다. 네트워크 연결 해제,
// 열려있는 파일 스트림 해제 등을 구현한다.
// void wait() : 멀티스레드 프로그램에서 사용하는 메서드이다. 스레드를 '기다리는 상태' (non runnable) 로 만든다.
// void notify() : wait() 메서드에 의해 기다리고 있는 스레드 (nonrunnable 상태) 를 실행 가능한 상태 (runnable) 로 가져온다.

// toString() 메서드
// Object 클래스의 메서드이다.
// getClass().getName() + '@' + Integer.toHexString(hashCode())
// -> object.Book@16f65612
//     클래스이름 @ 해시 코드 값
// 객체의 정보를 String으로 바꿔서 사용할 때 많이 쓰인다.
// String이나 Integer 클래스에는 이미 재정의되어 있다.
// String 클래스에서는 위의 객체 주소 정보가 아닌, 문자열 값을 반환한다.
// Integer 클래스에서는 위의 객체 주소 정보가 아닌, 정수 값을 반환한다.


package object;

class Book {
	String title;
	String author;
	
	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return title + "," + author;
	}
	
	
}

public class ToStringEx {

	public static void main(String[] args) {
		Book book = new Book("두잇 자바", "은종님");
		System.out.println(book); // 객체 자체를 프린트하면 객체의 주소 정보를 반환한다. 이는 객체를 인자값으로 프린트를 수행할때
		// toString() 메서드를 실행하는데, 일반 객체의 toString() 메서드는
		// getClass().getName() + '@' + Integer.toHexString(hashCode()) 이기 때문이다. 이때 toString() 메서드를
		// 재정의 해주면 재정의한 방식대로 값을 출력하게 된다.
		
		String str = new String("test"); // String 객체를 프린트하면 객체의 주소가 아닌 String 객체에 할당된 문자열을
		// 반환한다. 이는 String 클래스에 toString() 메서드가 재정의되어 있기 때문이다. 만약 일반 객체처럼 프린트를 통해 객체를
		// 반환하고 싶다면, toString() 메서드를 재정의해주면 된다.
		System.out.println(str);
	}

}
