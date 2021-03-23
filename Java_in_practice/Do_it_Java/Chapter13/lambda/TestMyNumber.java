// 람다식 (lambda expression)
// 자바에서 함수형 프로그래밍 (functional programming) 을 구현하는 방식이다.
// 자바 8 부터 지원한다.
// 클래스를 생성하지 않고 함수의 호출만으로 기능을 수행할 수 있다.

// 함수형 프로그래밍
// 순수 함수 (pure function) 를 구현하고 호출함으로써 외부 자료에 부수적인 영향을 주지 않고 매개 변수만을 사용하도록 만든 함수를 기반으로 구현한다.
// 입력 받은 자료를 기반으로 수행되고, 외부에 영향을 미치지 않으므로 병렬처리등에 사용 가능하다.
// 안정적이며 확장성이 있는 프로그래밍 방식이다.

// 람다식 구현하기
// 익명 함수 만들기
// 매개변수와 매개변수를 활용한 실행문으로 구현한다. // (매개변수) -> {실행문;}
/*
 * 두 수를 입력받아 더하는 add() 함수
 * 
 * int add(int x, int y) {
 *     return x + y;
 * }
 * 			|
 * 
 * (int x, int y) -> {return x + y;}
 */
// 함수 이름과 반환형을 없애고 -> 를 사용한다.
// {} 까지 실행문을 의미한다.

/*
 * 람다식 문법
 * 매개변수가 하나인 경우 자료형과 괄호를 생략할 수 있다.
 * str -> {System.out.println(str);}
 * 
 * 매개변수가 두개인 경우에는 괄호를 생략할 수 없다.
 * x, y -> {System.out.println(x + y);} // 잘못된 형식
 * 
 * 중괄호 안의 구현부가 한 문장인 경우에는 중괄호를 생략할 수 있다.
 * str -> System.out.println(str);
 * 
 * 중괄호 안의 구현부가 한 문장이더라도 return 문은 중괄호를 생략할 수 없다.
 * str -> return str.length(); // 잘못된 형식
 * 
 * 중괄호 안의 구현부가 반환문 하나라면 return과 중괄호 모두를 생략할 수 있다.
 * (x, y) -> x + y; // 두 값을 더하여 반환.
 * str -> str.length(); // 문자열의 길이를 반환.
 */

package lambda;

public class TestMyNumber {

	public static void main(String[] args) {
		
		int i = 50;
		// MyNumber maxNum = (x, i) -> (x >= i)? x : i; // 외부 인스턴스 변수는 람다식에서 사용 불가능하다. 함수형 프로그래밍의 의미 자체가 매개변수만을 이용하고,
		// 외부 변수 등의 영향을 받지 않음으로써 안정적이며 확장성 있는 프로그래밍 방식이라는 점도 있지만, 아래에서 볼 수 있듯이 람다식은 익명 내부 클래스를 생성하고 함수형
		// 인터페이스의 메서드를 재정의 하는 방식으로 수행되는데, 익명 내부 클래스에서는 외부 인스턴스 변수를 사용하지 못하므로 람다식에서 외부 인스턴스 변수의 사용은 불가능하다.
		
		MyNumber maxNum = (x, y) -> (x >= y)? x : y; // 함수형 인터페이스에 선언된 메서드에 대응된다.
		// 이 람다식은 삼항 연산자를 람다식으로서 표현하였으며, return 과 중괄호를 생략하였다.
		
		int max = maxNum.getMaxNumber(10, 20);
		System.out.println(max);
		
		/* 자바에서는 객체를 생성해야 메서드를 호출할 수 있는데, 위에서처럼 람다식을 이용해 메서드를 구현하고 호출하면 아래처럼 내부에서는 익명 내부 클래스가 생성되어
		 * 람다식에서 구현한 메서드가 익명 내부 클래스에서 함수형 인터페이스의 메서드를 재정의하여 실행된다.
		MyNumber aaa = new MyNumber() {
			@Override
			public int getMaxNumber(int num1, int num2) {
				int temp = (num1 >= num2) ? num1 : num2;
				return temp;
			}			
		};
		*/
	}

}
