// Buffered 스트림
// 내부적으로 8192 (약 8K) 바이트 배열을 가지고 읽거나 쓰기 기능을 제공하여 속도가 빨라진다.
// 스트림 클래스				설명
// BufferedInputStream		바이트 단위로 읽는 스트림에 버퍼링 기능을 제공한다.
// BufferedOutputStream		바이트 단위로 출력하는 스트림에 버퍼링 기능을 제공한다.
// BufferedReader			문자 단위로 읽는 스트림에 버퍼링 기능을 제공한다.
// BufferedWriter			문자 단위로 출력하는 스트림에 버퍼링 기능을 제공한다.

// 일반 바이트 단위 입출력 스트림은 1 바이트 단위로 읽고 쓰지만 Buffered 스트림의 경우, 8K 를 동시에 읽고 쓰므로 훨씬 빠르게
// 동작하게 된다.

package stream.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		
		long milliseconds = 0;
		int len = 0;
		
		try (FileInputStream fis = new FileInputStream("a.exe");
			FileOutputStream fos = new FileOutputStream("b.exe");
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			// Java 설치 파일의 이름을 a.exe 로 변경하고, 이를 b.exe 라는 이름의 파일로 복사하는 코드인데 약 303초가
			// 소요될 정도로 오래 걸린다. 따라서 버퍼링을 이용해 이를 보완한다.
			
			milliseconds = System.currentTimeMillis();
			int i;
				// while((i = fis.read()) != -1) {
				while((i = bis.read()) != -1) { // 버퍼링 사용시 약 1.4초가 소요된다.
					// fos.write(i);
					bos.write(i);
					len++;
			}
			milliseconds = System.currentTimeMillis() - milliseconds;
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println(len);
		System.out.println(milliseconds);
	}

}
