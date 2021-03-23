// 스트림이란
// 네트워크에서 자료의 흐름이 물과 같다는 의미에서 유래하였다.
// 다양한 입출력 장치에 독립적으로 일관성 있는 입출력을 제공하는 방식이다.
// (13장에서 다룬 스트림은 특정 연산을 수행하기 위한 것인 반면, 15장의 스트림은 자료를 읽고 쓰기 위한 입출력 객체이다.)
// (이때 입출력은 다양한 디바이스 간에서 이루어지는데, 디바이스 종류마다 다른 입출력을 구현해야 한다면 호환성이 떨어지게 된다.
// 따라서 Virtual passway 개념을 사용하여 Virtual passway 를 경유하여 독립적으로 일관성 있게 자료를 주고 받을 수 있게끔 한다.)
// 입출력이 구현되는 곳 : 파일 디스크, 키보드, 마우스, 메모리 네트워크 등

// 스트림의 구분
// 대상 기준 : 입력 스트림 / 출력 스트림
// 자료의 종류 : 바이트 스트림 / 문자 스트림
// 기능 : 기반 스트림 / 보조 스트림

// 입력 스트림과 출력 스트림
// 입력 스트림 : 대상으로부터 자료를 읽어들이는 스트림이다.
// 출력 스트림 : 대상으로 자료를 출력하는 스트림이다.

/*				입력 스트림
 * 		자바       <----		입출력
 *   응용프로그램    ---->		 자료
 *   			출력 스트림
 */
// 이때 자바에서는 C++ 과는 달리 입력 스트림과 출력 스트림을 동시에 사용하지 못한다.

// 스트림의 종류
// 종류			예시
// 입력 스트림		FileInputStream, FileReader, BufferedInputStream, BufferedReader 등
// 출력 스트림		FileOutputStream, FileWriter, BufferedOutputStream, BufferedWriter 등

/*
 * 표준 입출력
 * 
 * System 클래스의 표준 입출력 멤버
 * public class System { // static 멤버이기 때문에 new 로 인스턴스를 생성하지 않아도 표준 입출력 멤버를 사용 가능하다.
 *     public static PrintStream out;
 *     public static InputStream in;
 *     public static PrintStream err;
 * }
 * 
 * System.out
 * 표준 출력 (모니터) 스트림
 * System.out.println("에러메시지");
 * 
 * System.in
 * 표준 입력 (키보드) 스트림
 * int d = System.in.read(); // 한 바이트 읽어내기
 * 
 * System.err
 * 표준 에러 출력 (모니터) 스트림
 * System.err.println("데이터");
 */

package stream.inputstream;

import java.io.IOException;

public class SystemInTest {

	public static void main(String[] args) {
		System.out.println("알파멧 하나를 쓰고 엔터를 누르세요.");
		int i = 0;
		try {
			while((i = System.in.read()) != '\n') { // System.in.read() 는 한 바이트씩 읽어 들이는데
				// 한번에 다 읽기 위해서 while 문을 통해 '\n' 을 만날때까지 입력 받도록 한다. 이때 System.in.read()
				// 메서드는 int 타입으로 입력된 데이터를 반환한다.
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
