// 바이트 단위 스트림과 문자 단위 스트림
// 바이트 단위 스트림 : 동영상, 음악 파일 등을 읽고 쓸때 사용한다.
// 문자 단위 스트림 : 바이트 단위로 자료를 처리하면 문자는 깨진다. 따라서 2 바이트 단위 즉 문자 단위로 처리하도록 구현된 스트림이다.
// 스트림의 종류
// 종류			예시
// 바이트 스트림	FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream 등
// 문자 스트림		FileReader, FileWriter, BufferedReader, BufferedWriter 등

// 바이트 단위 스트림 - InputStream
// 바이트 단위 입력용 최상위 스트림
// 추상 메서드를 포함한 추상 클래스로 하위 클래스가 구현하여 사용한다.
// 주요 하위 클래스
// 스트림 클래스					설명
// FileInputStream				파일에서 바이트 단위로 자료를 읽는다.
// ByteArrayInputStream			Byte 배열 메모리에서 바이트 단위로 자료를 읽는다.
// FilterInputStream			기반 스트림에서 자료를 읽을때 추가 기능을 제공하는 보조 스트림의 상위 클래스이다.
//								(보조 스트림은 '15-5 보조 스트림'에서 자세히 설명한다.)

// 메서드									설명
// int read()							입력 스트림으로부터 한 바이트의 자료를 읽는다. 읽은 바이트를 정수로 반환한다.
// int read(byte b[])					입력 스트림으로부터 b[] 크기의 자료를 b[]에 읽는다. 읽은 자료의 바이트 수를 반환한다.
// int read(byte b[], int off, int len)	입력 스트림으로부터 b[] 크기의 자료를 b[]의 off 변수 위치부터 저장하며 len 만큼
//										읽는다. 읽은 자료의 바이트 수를 반환한다.
// void close()							입력 스트림과 연결된 대상 리소스를 닫는다.
//										(예: FileInputStream인 경우 파일을 닫는다.)

// 문자 단위 스트림 - Reader
// 문자 단위로 읽는 최상위 스트림이다.
// 하위 클래스에서 상속 받아 구현한다.
// 주요 하위 클래스
// 스트림 클래스								설명
// FileReader								파일에서 문자 단위로 읽는 스트림 클래스이다.
// InputStreamReader						바이트 단위로 읽은 자료를 문자로 변환해주는 보조 스트림 클래스이다.
// BufferedReader							문자로 읽을때 배열을 제공하여 한꺼번에 읽을 수 있는 기능을
//											제공해주는 보조 스트림이다.

// 메서드										설명
// int read()								파일로부터 한 문자를 읽는다. 읽은 값을 반환한다.
// int read(char[] buf)						파일로부터 buf 배열에 문자를 읽는다.
// int read(char[] buf, int off, int len)	파일로부터 buf 배열의 off 위치에서부터 len 개수만큼 문자를 읽는다.
// void close()								스트림과 연결된 파일 리소스를 닫는다.

package stream.inputstream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		// FileInputStream fis = null;
		FileReader fis = null; // FileInputStream 은 바이트 단위로 읽기때문에 영문자는
		// 제대로 읽지만, 한글의 경우 출력이 깨진다. 따라서 이러한 경우에는 FileReader 를 사용해줘야 하는데,
		// FileReader 는 문자 인코딩대로 읽는다. 이때 원하는 charset 을 정해줄 수 있는데, 정하지 않는 경우에는
		// UTF 를 default 로 사용한다.
		// 아래 finally 블록의 try 블록에서 입력 스트림을 close() 해주기 위해서는 fis 변수에 접근할 수 있어야 하는데,
		// try 블록 안에 선언 되는 경우 접근이 불가능하다. 따라서 이를 밖에서 선언해주되 null 을 대입해준다.
		
		int i = 0;
		
		try {
			// fis = new FileInputStream("input.txt");
			fis = new FileReader("input.txt");
			
			while ((i = fis.read()) != - 1) { // read() 메서드의 경우 파일의 끝에 도달하였을 때 -1 을 반환한다.
				System.out.print((char)i);
			}
			/*
			System.out.print((char)fis.read());
			System.out.print((char)fis.read());
			System.out.println((char)fis.read());
			*/
				
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				fis.close();
			} catch (IOException e) { // input.txt 파일이 없으므로 위에서 FileNotFoundException 이 catch가
				// 되고, fis 는 계속 null 이 할당되어 있는 상태인데 이때 IOException 에 NullPointerException 은
				// 포함되지 않으므로 시스템이 비정상적으로 종료가 되고, 아래에 end 는 출력되지 않는다. 따라서 아래에서
				// NullPointerException 에 대한 예외 처리를 해주어야 한다.
				
				System.out.println(e);
			} catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		System.out.println("end");
	}
}
