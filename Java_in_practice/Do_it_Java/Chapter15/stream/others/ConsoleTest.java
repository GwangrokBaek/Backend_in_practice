// Console 클래스
// System.in 을 사용하지 않고 콘솔에서 표준 입력을 할 수 있다.
// 이클립스와는 연동되지 않는다.
// command 창에서 입력한다. (cmd)
// 메서드							설명
// String readLine()			문자열을 읽는다.
// char[] readPassword()		사용자에게 문자열을 보여주지 않고 읽는다.
// Reader reader()				Reader 클래스를 반환한다.
// PrintWriter writer()			PrintWriter 클래스를 반환한다.

package stream.others;

import java.io.Console;

public class ConsoleTest {

	public static void main(String[] args) {
		Console console = System.console(); // 콘솔 클래스를 반환한다.
		
		System.out.println("이름:");
		String name = console.readLine();
		System.out.println("직업:");
		String job = console.readLine();
		System.out.println("비밀번호:");
		char[] pass = console.readPassword();
		String strPass = new String(pass);
		
		System.out.println(name);
		System.out.println(job);
		System.out.println(strPass);
	}
}
