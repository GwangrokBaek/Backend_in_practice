// 기반 스트림과 보조 스트림
// 기반 스트림 : 대상에 직접 자료를 읽고 쓰는 기능을 수행하는 스트림이다.
// 보조 스트림 : 직접 읽고 쓰는 기능은 없이 추가적인 기능을 더해주는 스트림이다.
// 보조 스트림은 직접 읽고 쓰는 기능은 없으므로 항상 기반 스트림이나 또 다른 보조 스트림을 생성자 매개변수로 포함한다.

// 스트림 종류
// 종류			예시
// 기반 스트림		FileInputStream, FileOutputStream, FileReader, FileWriter 등
// 보조 스트림		InputStreamReader, OutputStreamWriter, BufferedInputStream, BufferedOutputStream 등

// 보조 스트림
// 실제 읽고 쓰는 스트림이 아닌 보조적인 기능을 추가하는 스트림이다.
// 데코레이터 패턴을 사용한다.
// FilterInputStream 과 FilterOutputStream 이 보조 스트림의 상위 클래스이다.
// 생성자의 매개변수로 또 다른 스트림을 가진다.
// 생성자											설명
// protected FilterInputStream(InputStream in)	생성자의 매개변수로 InputStream 을 받는다.
// public FilterOutputStream(OutputStream out)	생성자의 매개변수로 OutputStream 을 받는다.

//  [기반 스트림]		   [보조 스트림]	   [보조 스트림]
// 	 바이트 단위		   + 문자로 변환	   + 버퍼링 기능
// 파일 입력 스트림			 기능 추가 		   추가

// InputStreamReader 와 OutputStreamWriter
// 바이트 단위로 읽거나 쓰는 자료를 문자로 변환해주는 보조 스트림이다.
// (예: FileInputStream (바이트 스트림) 으로 읽은 자료를 문자로 변환.)

package stream.decorator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		// try(FileInputStream fis = new FileInputStream("reader.txt")) {
		// 파일에 한글이 적혀있는 경우, 바이트 단위 입력 스트림은 출력이 깨지므로 문자 단위 스트림을 사용하거나 문자로 변환해주는
		// 보조 스트림을 사용해야 한다.
		
		try(InputStreamReader irs = new InputStreamReader(new FileInputStream("reader.txt"))) {
			// 바이트 단위 입력 스트림의 생성자를 문자로 변환해주는 보조 스트림의 생성자의 매개변수로 대입하여 인스턴스 생성.
			// 이때 보조 스트림의 생성자에는 기반 스트림 뿐만 아니라, 다른 보조 스트림이 대입될 수도 있다.
		
		// try(InputStreamReader irs = new InputStreamReader(System.in))
		// 표준 입력은 바이트 단위 입력 스트림이므로, 이런식으로 표준 입력에도 보조 스트림이 사용될 수 있다.
			
			int i = 0;
			// while((i = fis.read()) != -1) {
			while((i = irs.read()) != -1) {
				System.out.print((char)i);
			}
		} catch(IOException e) {
			System.out.println(e);
		}
		
		Socket socket = new Socket();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			br.readLine(); // BufferedReader 에는 readLine() 메서드가 있는데, 한 줄 단위로 읽을 수가 있어서
			// 편리하게 프로그래밍을 할 수 있다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Socket 통신을 위한 Socket 의 메시지를 읽어오는 getInputStream() 메서드의 경우, inputStream 을 반환하므로
		// 한글 즉, 문자를 읽기 위해서는 보조 스트림을 사용해주면 된다. 이때 추가로 버퍼링 기능을 사용하기 위해 BufferedReader
		// 보조 스트림을 추가로 사용할 수도 있다.
	}

}
