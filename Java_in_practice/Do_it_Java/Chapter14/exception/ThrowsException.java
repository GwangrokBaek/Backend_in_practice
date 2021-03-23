// 예외 처리 미루기
// throws 를 사용하여 예외 처리 미루기.
// 메서드 선언부에 throws 를 추가한다.
// 예외가 발생한 메서드에서 예외 처리를 하지않고, 이 메서드를 호출한 곳에서 예외 처리를 한다는 의미이다.
// main() 에서 throws 를 사용하면 가상머신에서 처리된다.
// 이때 throws 는 예외를 미룰때 메서드 선언부에서 사용하는 것이고, throw 는 강제적으로 예외를 발생시킬때 사용한다.

package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
		// 아래에서 파일 열기와, 클래스 가져오기 기능을 수행하는데 이때 파일이 없는 경우와 클래스가 없는 경우의 예외 처리를 해주어야 한다.
		// 이들에 대한 예외 처리를 throws 를 통해 미루고, 실제로 사용하는 쪽에서 try - catch 문으로 예외 처리를 하게끔 하는 프로그래밍 방식이 있다.
		// 사용하는 쪽에서 로그 처리 등 원하는 코드를 작성하여 예외 처리를 할 수 있기에, 실제로 사용하는 쪽에서 try - catch 문으로 예외 처리를 하는
		// 경우가 종종 있다.
		
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}
	
	public static void main(String[] args) {
		
		ThrowsException ex = new ThrowsException();
		try { // 위에 클래스 구현 단계에서 예외 처리를 해주지 않고, throws 를 통해 예외를 미루었으므로 사용하는 단계에서 try - catch 문을 통해
			// 이에 대한 예외 처리를 해주어야 한다.
			
			ex.loadClass("b.txt", "java.lang.String");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) { // 정확히 어떤 예외가 발생하는지 모르는 경우에는 Exception 을 통해 이를 처리할 수 있다. 왜냐하면 Exception 은
			// 모든 예외의 최상위 클래스이기 때문이다. 이때 Exception 에 대한 예외 처리는 제일 아래에 구현해주어야 한다. 왜냐하면 맨 위에 있을 경우
			// 오류가 발생하는데, 다른 예외들이 업캐스팅되어 별도로 구현해준 하위 예외 처리문에 접근하지 못하기 때문이다.
			
			System.out.println(e);
		}
		System.out.println("end");
	}

}
