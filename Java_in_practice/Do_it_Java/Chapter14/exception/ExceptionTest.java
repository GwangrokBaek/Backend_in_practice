// try - with - resources 문
// 리소스를 자동 해제 하도록 제공해주는 구문이다.
// 자바 7 부터 제공된다.
// close() 를 명시적으로 호출하지 않아도 try {} 블럭에서 열린 리소스는 정상적인 경우와 예외가 발생한 경우 모두 자동 해제된다.
// 해당 리소스가 AutoCloseable 인터페이스를 구현해야 한다.
// FileInputStream 의 경우 AutoCloseable 을 구현하고 있기에 try - with - resources 문을 통해 자동 해제가 가능하다.

package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args){
		// throws는 예외를 미루는 방식으로 main 에서 사용할시, 예외가 JVM 으로 넘어가 시스템이 종료될 수 있다.
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) { // 파일이 없는데 열면 오류가 발생할 수 있으므로 try - catch 로 예외 처리.
			System.out.println(e);
			// e.printStackTrace(); 예외 처리에 대한 모든 계층 정보를 출력한다.
		} finally {
			try {
				fis.close();
			} catch (IOException e) { // 파일이 없는데 닫으면 오류가 발생할 수 있으므로 try - catch 로 예외 처리.
				e.printStackTrace();
			}
			System.out.println("finally");
		}
		System.out.println("end");
		
		// 하지만 위 코드는 file close 에 대해서도 예외 처리를 추가로 해줘야하므로 코드가 복잡해진다. 따라서 try - with - resources 문을 사용해서
		// 간단하게 구현할 수 있다.
		
		try (FileInputStream fis2 = new FileInputStream("a.txt")) { // try () 안에 파일에 대한 객체를 할당해주는 코드를 작성해주면 된다.
			
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("end");
		
	}

}
