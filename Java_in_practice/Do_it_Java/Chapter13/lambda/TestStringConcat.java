package lambda;

public class TestStringConcat {

	public static void main(String[] args) {
		
		// 똑같은 기능을 객체 지향 프로그래밍 방식과 함수형 프로그래밍 방식으로 구현.
		// (공통) 메서드가 선언되어 있는 함수형 인터페이스를 만들어준다.
		// (객체 지향 프로그래밍) 별도의 클래스에서 인터페이스를 구현하여 선언된 메서드를 재정의해준다. 이후, 실제 사용할 때에는 인스턴스 생성 뒤 메서드를 호출해준다.
		// (함수형 프로그래밍) 별도의 클래스 구현 없이, 실제 사용할 때 람다식으로 함수를 구현해준 다음 이를 변수에 할당해준다. 이후, 인터페이스의 메서드를 호출해준다.
		
		StringConcatImpl sImpl = new StringConcatImpl(); // 객체 지향 프로그래밍 방식
		sImpl.makeString("hello", "java");
		
		StringConcat concat = (s1, s2) -> System.out.println(s1 + " " + s2); // 함수형 프로그래밍 방식
		concat.makeString("hello", "java");
		
		/*
		StringConcat concat2 = new StringConcat() { // 위의 함수형 프로그래밍 방식은 내부적으로 아래처럼 익명 내부 클래스를 생성한 뒤 메서드를 재정의한다.
		// 따라서 함수형 프로그래밍 방식을 사용하지 않고 그냥 익명 내부 클래스를 사용하는 경우도 종종 있다.

			@Override
			public void makeString(String s1, String s2) {
				System.out.println(s1 + " " + s2);
			}
		};
		concat2.makeString("hello", "java");
		*/
	}

}
