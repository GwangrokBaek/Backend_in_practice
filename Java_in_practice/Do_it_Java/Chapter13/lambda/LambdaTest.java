// 함수를 변수처럼 사용하는 람다식
/*
 * 프로그램에서 변수의 사용
 * 변수를 사용하는 경우									예시
 * 특정 자료형으로 변수 선언 후 값 대입하여 사용하기			int a = 10;
 * 매개변수로 전달하기									int add(int x, int y);
 * 메서드의 반환 값으로 반환하기							return num;
 * 
 * 인터페이스형 변수에 람다식 대입
 * interface PrintString {
 *     void showString(String str);
 * }
 * 				|
 * 
 * s -> System.out.println(s)
 * 
 * PrintString lambdaStr = s -> System.out.println(s); // 인터페이스형 변수에 람다식 대입
 * lambdaStr.showString("hello lambda_1");
 */

package lambda;

interface PrintString {
	void showString(String str); // 함수형 인터페이스에서 메서드는 선언만 해준 뒤, 아래에서 람다식을 작성하고 이를 함수형 인터페이스형 변수에 할당할 경우, 해당 람다식이 메서드의 구현부로 정의된다.
}

public class LambdaTest {

	public static void main(String[] args) {
		PrintString lambdaPrint = str -> System.out.println(str); // 람다식을 변수에 대입하여 사용
		lambdaPrint.showString("test");
		
		showMyString(lambdaPrint);
		
		PrintString reStr = returnPrint();
		reStr.showString("hello");
	}
	
	public static void showMyString(PrintString lambda) { // 람다식을 매개변수로 전달하여 사용
		lambda.showString("test2");
	}
	
	public static PrintString returnPrint() { // 람다식을 메서드의 반환 값으로 반환하여 사용
		return s -> System.out.println(s + " world");
	}
	// 함수형 프로그래밍의 입장에서는 람다식을 변수에 대입하고, 매개변수로 전달하고, 메서드의 반환 값으로 반환하는 것이지만 자바의 입장에서 보면 람다식은
	// 익명 내부 클래스를 생성하여 클래스의 메서드를 재정의하는 것이므로, 익명 내부 클래스에 대한 객체를 변수에 대입하고, 매개변수로 전달하고, 메서드의 반환 값으로 반환하는 것이라
	// 보면 이해하기 쉽다.
}
