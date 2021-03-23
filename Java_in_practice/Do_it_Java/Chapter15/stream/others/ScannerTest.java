// Scanner 클래스
// (입력을 받을 수 있는 또다른 클래스로서 System.in.read() 보다 자주 사용된다. 왜냐하면 여러 생성자 및 메서드를
// 지원하기 때문에 여러 대상 및 자료형에서 자료를 읽을 수 있기 때문이다.)
// java.util 패키지에 있는 입력 클래스
// 문자뿐 아니라 정수, 실수 등 다른 자료형도 읽을 수 있다.
// 여러 대상에서 자료를 읽을 수 있다. (콘솔, 파일 등)

// 생성자							설명
// Scanner(File source)			파일을 매개변수로 받아 Scanner를 생성한다.
// Scanner(InputStream source)	바이트 스트림을 매개변수로 받아 Scanner를 생성한다.
// Scanner(String source)		String을 매개변수로 받아 Scanner를 생성한다.

// Scanner 클래스의 경우, 여러 타입으로 자료를 읽을 수 있다.
// 메서드							설명
// boolean nextBoolean()		boolean 자료를 읽는다.
// byte nextByte()				한 바이트 자료를 읽는다.
// short nextShort()			short 자료형을 읽는다.
// int nextInt()				int 자료형을 읽는다.
// long nextLong()				long 자료형을 읽는다.
// float nextFloat()			float 자료형을 읽는다.
// double nextDouble()			double 자료형을 읽는다.
// String nextLine()			문자열 String을 읽는다.

// 이때 Scanner 클래스에는 delimiter 기능이 있어 쉼표를 구분자로 하여 입력을 받는다던지 등 입력 구분 기능을 지원한다.

package stream.others;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // System.in 을 통해 입력을 받을 것이라는 의미.
		
		String name = scanner.nextLine(); // 한 줄을 읽는다.
		int num = scanner.nextInt(); // 정수를 읽는다.
		
		System.out.println(name);
		System.out.println(num);
	}
}
