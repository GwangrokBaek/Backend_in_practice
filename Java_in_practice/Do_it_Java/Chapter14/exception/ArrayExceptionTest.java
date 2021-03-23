// 오류란 무엇인가
// 컴파일 오류 (compile error) : 프로그램 코드 작성 중 발생하는 문법적 오류.
// 실행 오류 (runtime error) : 실행 중인 프로그램이 의도하지 않은 동작을 하거나 (bug) 프로그램이 중지되는 오류.
// 실행 오류가 발생했을때 나타나는 비정상 종료는 서비스 운영에 치명적이다.
// 오류가 발생할 수 있는 경우에 로그 (log) 를 남겨 추후 이를 분석하여 원인을 찾아야 한다.
// 자바는 예외 처리를 통하여 프로그램의 비정상 종료를 막고 log 를 남길 수 있다.

// 오류와 예외 클래스
// 시스템 오류 (error) : 가상 머신에서 발생한다. 프로그래머가 처리할 수 없다. ex) 동적 메모리가 없는 경우, 스택 오버 플로우 등
// 예외 (exception) : 프로그램에서 제어할 수 있는 오류이다. ex) 읽어 들이려는 파일이 존재하지 않는 경우, 네트워크 연결이 끊어진 경우 등
// 		Throwable // Error 와 Exception 의 최상위 클래스.
//	  |			  |
//  Error	  Exception

// 예외 클래스의 종류
// 모든 예외 클래스의 최상위 클래스는 Exception 이다.
// 다양한 예외 클래스가 제공된다.
// java.lang.Object <- java.lang.Throwable <- java.lang.Exception 순이다.
//	 											Exception
//						|														|
//	    		   입출력 예외 처리 										 실행 오류 예외 처리
// 		   		   (IOException)										(RuntimeException)
//		    |						  |	  		 				 |					   		    |
// FileNotFoundException	    SocketException			ArithmeticException			 IndexOutofBoundsException

// 예외 처리하기
// try - catch 문
/*
 * try {
 *     예외가 발생할 수 있는 코드 부분
 * } catch(처리할 예외 타입 e) {
 *     try 블록 안에서 예외가 발생했을때 예외를 처리하는 부분
 * }
 */

// try - catch - finally 문
// finally 에서 프로그램 리소스를 정리한다.
// try {} 블럭이 실행되면 finally {} 블럭은 항상 실행된다.
// 리소스를 정리하는 코드를 각 블록에서 처리하지 않고, finally 에서 처리한다.
/*
 * try {
 *     예외가 발생할 수 있는 부분
 * } catch(처리할 예외 타입 e) {
 *     예외를 처리하는 부분
 * } finally {
 *     항상 수행되는 부분
 * }
 */

package exception;

public class ArrayExceptionTest {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		try {
			for (int i = 0; i <= 5; i++) {
				System.out.println(arr[i]); // 인덱스의 범위를 벗어난 요소에 접근하였으므로 ArrayIndexOutOfBoundsException 예외 발생.
			}
		} catch(ArrayIndexOutOfBoundsException e) { // try 블록 안에서 예외가 발생했을때 해당 예외가
			// ArrayIndexOutOfBoundsException 이라면, catch 블록 안으로 제어권이 이동된다.
			System.out.println(e); // 이때 e.toString() 이 호출된다. -> exception의 이름과 어디서 예외가 발생했는지를 출력한다.
			// log 를 남길때에는 이 부분에서 log 를 작성하는 함수를 호출한다.
			return;
		} finally { // return 은 finally 블록의 내용이 실행된 다음에 수행된다. 따라서 catch 문에 return이 있을때에는
			// 아래의 end 는 출력되지 않고, finally 블록의 finally 는 출력된다. 왜냐하면 finally 블록은 try 블록이 실행된 경우에는 무조건
			// 실행되기 때문이다.
			System.out.println("finally");
		}
		System.out.println("end"); // try - catch 문을 통해 예외처리를 해주었기 때문에 예외가 발생하여도 시스템이 종료되지 않고
		// catch 블록에서 구현한 내용을 수행한 다음 그 다음 명령을 수행한다.
	}

}
