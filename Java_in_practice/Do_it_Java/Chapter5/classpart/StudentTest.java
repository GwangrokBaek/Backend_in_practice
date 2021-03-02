// 클래스(static 코드)를 생성(인스턴스화) 하면 인스턴스(dynamic memory)가 만들어진다.
// 인스턴스는 클래스가 힙 메모리에 할당된 것을 의미한다.
// 이때 여러개의 인스턴스를 생성할 수 있는데, 각각의 인스턴스는 모두 다른 메모리에 위치하게 된다.
// 클래스를 사용하기 위해서는 클래스를 생성하고 이때 클래스를 생성하기 위해 new 키워드를 반드시 사용해줘야 한다.

package classpart;

public class StudentTest {
	public static void main(String[] args) {
		// main 함수는 프로그램의 시작점을 의미.
		// 이때 main 함수의 형식은 항상 동일하다.
		
		int i = 1; // 기본 데이터 타입
		// 아래 Student는 참조형 데이터 타입이라 하고, 참조형 데이터 타입으로 선언한 변수인 studentLee를 참조변수라고 한다.
		// 참조변수는 지역 변수로서 스택 메모리에 저장이 되고, 이들이 생성자에 의해 생성된 힙 메모리에 위치하는 인스턴스를 가리킨다.
		// 즉, 인스턴스의 멤버 변수들 모두 힙 메모리에 위치하게 된다.
		// 이 힙 메모리에 위치해 있는 인스턴스에 대한 내용은 GC에 의해 해제된다.
		
		Student studentLee = new Student(); // Student()는 생성자(Constructor)
		studentLee.studentName = "이순신"; // 참조변수를 사용해 멤버 변수나 메소드를 사용할 수 있다.
		studentLee.address = "서울시 서초구 서초동";
		
		Student studentKim = new Student();
		studentKim.studentName = "김유신";
		studentKim.studentID = 101;
		studentKim.address = "미국 산호세";
		
		studentLee.showStudentInfo();
		studentKim.showStudentInfo();
		// 별도의 클래스에서 다른 클래스를 사용하는 것이 가능하다.
		// 또는 사용하는 클래스의 내부에서 main 함수를 작성하여 실행하는 것도 가능하다.
		
		// 참조 변수 : 인스턴스 생성시 선언하는 변수
		// 참조 값 : 인스턴스가 생성되는 힙 메모리 주소
		// 아래 코드를 통해 참조 변수를 이용한 참조 값(힙 메모리 주소)을 확인할 수 있다.
		
		System.out.println(studentLee); // 이때 16진수로 메모리 주소를 출력하는데 총 8자리로 16진수는 하나당 4비트이므로
										// 즉 주소의 크기는 32비트이다.
		System.out.println(studentKim);
	}
}

/*
 * 객체 : 객체 지향 프로그램의 대상, 생성된 인스턴스
 * 클래스 : 객체를 프로그래밍하기 위해 코드로 만든 상태
 * 인스턴스 : 클래스가 메모리에 생성된 상태
 * 멤버 변수 : 클래스의 속성, 특성
 * 메소드 : 멤버 변수를 이용하여 클래스의 기능을 구현한 것
 * 참조 변수 : 메모리에 생성된 인스턴스를 가리키는 변수
 * 참조 값 : 생성된 인스턴스의 메모리 주소 값
 */