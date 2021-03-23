// StringBuilder, StringBuffer 사용하기
// 내부적으로 가변적인 char[] 배열을 가지고 있는 클래스이다.
// 문자열을 여러 번 연결하거나 변경할때 사용하면 유용하다.
// 매번 새로 생성하지 않고 기존 배열을 변경하므로 garbage가 생기지 않는다.
// StringBuffer는 멀티 쓰레드 프로그래밍에서 동기화 (synchronization) 를 보장한다. (StringBuffer의 값에 접근할 때
// 자원에 대한 락 기능을 지원한다는 뜻이다. 하지만, 단일 쓰레드에도 락 기능이 수행되기 때문에 오버헤드가 발생할 수 있다.)
// 단일 쓰레드 프로그램에서는 StringBuilder를 사용하기를 권장한다.
// toString() 메서드로 String으로 반환할 수 있다. (StringBuilder나 StringBuffer는 String 클래스가 아니기 때문에
// 프로그램에서 String 타입이 필요한 경우, toString() 메서드를 사용해 String으로 반환해주면 된다.)

// Wrapper 클래스
// 기본 자료형 (primitive data type) 에 대한 클래스이다.
/*
 * 기본형		Wrapper 클래스
 * boolean	Boolean
 * byte		Byte
 * char 	Character
 * short	Short
 * int		Integer
 * long		Long
 * float	Float
 * double	Double
 */

// 오토 박싱 (autoboxing) 과 언박싱 (unboxing)
// Integer는 객체이고, int는 4바이트 기본 자료형이다.
// 두 개의 자료를 같이 연산할때 자동으로 변환이 일어난다.
/*
 * Integer num1 = new Integer(100);
 * int num2 = 200;
 * int sum = num1 + num2; 이때 Wrapper 클래스인 num1이 num1.intValue() 를 통해 기본 자료형 int로 변환된다. (언박싱)
 * Integer num3 = num2; 이때 기본 자료형인 num2가 Integer.valueOf(num2) 를 통해 Integer 클래스로 변환된다. (오토박싱)
 */

package string;

public class StringBuilderTest {

	public static void main(String[] args) {
		String str1 = new String("java");
		System.out.println(System.identityHashCode(str1));
		
		StringBuilder buffer = new StringBuilder(str1);
		System.out.println(System.identityHashCode(buffer));
		
		buffer.append(" and");
		buffer.append(" android");
		System.out.println(System.identityHashCode(buffer));
		
		String str2 = buffer.toString(); // StringBuilder의 문자열을 출력하기 위해 toString 메서드를 사용하여
		// String을 반환해준다.
		System.out.println(str2);
		
		Integer i = new Integer(100); // 자바 9 부터 Integer 타입 변수에 Integer 생성자를 사용해 값을 할당하는 것을
		// 사용하지 않을 것이라며 Integer 생성자에 줄이 그어진다.
		Integer i2 = 100; // 자바 9 부터는 생성자 호출없이 숫자 할당만으로도 Integer 클래스의 인스턴스 생성이 가능하다.
	}

}
