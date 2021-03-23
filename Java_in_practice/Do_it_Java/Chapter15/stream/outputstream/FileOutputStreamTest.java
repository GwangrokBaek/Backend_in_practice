// 바이트 단위 스트림 - OutputStream
// 바이트 단위 출력용 최상위 스트림이다.
// 추상 메서드를 포함한 추상 클래스로 하위 클래스가 구현하여 사용한다.

// 주요 하위 클래스
// 스트림 클래스					설명
// FileOutputStream				바이트 단위로 파일에 자료를 쓴다.
// ByteArrayOutputStream		Byte 배열에 바이트 단위로 자료를 쓴다.
// FilterOutputStream			기반 스트림에서 자료를 쓸때 추가 기능을 제공하는 보조 스트림의 상위 클래스이다.

// 메서드										설명
// void write(int b)						한 바이트를 출력한다.
// void write(byte[] b)						b[] 배열에 있는 자료를 출력한다.
// void write(byte b[], int off, int len)	b[] 배열에 있는 자료의 off 위치부터 len 개수만큼 자료를 출력한다.
// void flush()								출력을 위해 잠시 자료가 머무르는 출력 버퍼를 강제로 비워 자료를 출력한다.
// void close()								출력 스트림과 연결된 대상 리소스를 닫는다. 출력 버퍼가 비워진다.
//											(예: FileOutputStream인 경우 파일을 닫는다.)

// 입력과 출력의 경우, buffer가 다 차야지 입력이 되고, 출력이 되는데 이때 flush() 메서드를 사용하면 버퍼가 다 차지 않더라도
// 이를 입력하거나 출력해준다. 주로 채팅 프로그램에서 메시지를 입력하고 전송할때 사용되곤 한다.
// close() 메서드의 경우, flush() 메서드를 호출한다.

// FileOutputStream 클래스
// 파일에 자료를 출력하는 스트림이다.
// 출력하려는 파일이 경로에 없는 경우에는 생성한다.

package stream.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		// FileOutputStream fos = new FileOutputStream("output.txt");
		// 자바 9 부터는 try - with - resources 문에서 변수만을 대입해서 사용할 수 있다.
		
		// try(fos) {
		try(FileOutputStream fos = new FileOutputStream("output.txt", true)) { // 이때 두 번째 매개변수로
			// true 를 대입해주면 파일 끝에 출력문을 append 하고, default 값인 false 는 overwrite 를 수행한다.
			
			fos.write(65); // FileOutputStream 클래스의 write() 메서드는 int 를 매개변수로 받는다.
			fos.write(66); // 이때 정수에 대응되는 아스키 코드를 출력해준다.
			fos.write(67);
		} catch(IOException e) {
			System.out.println(e);
		}
		
		byte[] bs = new byte[26];
		byte data = 65;
		for (int i = 0; i < bs.length; i++) {
			bs[i] = data++;
		}
		
		try(FileOutputStream fos = new FileOutputStream("output.txt")) {
			fos.write(bs); // 버퍼에 들어있는 데이터를 모두 출력한다.
			fos.write(bs, 2, 10); // C 부터 10개만 출력한다.
		} catch(IOException e) {
			System.out.println(e);
		}
		
		System.out.println("end");
	}

}
