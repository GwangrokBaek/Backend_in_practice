// 문자 단위 스트림 - Writer
// 문자 단위로 쓰는 최상위 스트림이다.
// 하위 클래스에서 상속 받아 구현한다.
// 주요 하위 클래스
// 스트림 클래스								설명
// FileWriter								파일에 문자 단위로 출력하는 스트림 클래스이다.
// OutputStreamWriter						파일에 바이트 단위로 출력한 자료를 문자로 변환해주는 보조 스트림이다.
// BufferedWriter							문자로 쓸때 배열을 제공하여 한꺼번에 쓸 수 있는 기능을 제공해주는 보조 스트림이다.

// 메서드										설명
// void write(int c)						한 문자를 파일에 출력한다.
// void write(char[] buf)					문자 배열 buf 의 내용을 파일에 출력한다.
// void write(char[] buf, int off, int len)	문자 배열 buf 의 off 위치에서부터 len 개수의 문자를 파일에 출력한다.
// void write(String str)					문자열 str을 파일에 출력한다.
// void write(String str, int off int len)	문자열 str의 off 번째 문자부터 len 개수만큼 파일에 출력한다.
// void flush()								파일에 출력하기 전에 자료가 있는 공간 (출력 버퍼) 을 비워 출력한다.
// void close()								파일과 연결된 스트림을 닫는다. 출력 버퍼도 비워진다.

package stream.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("writer.txt")) { // true 로 명시해주면 append 가 된다.
			fw.write("A"); // 문자 1개 출력
			char[] cbuf = {'B', 'C', 'D'};
			fw.write(cbuf); // 문자 배열 출력
			fw.write("안녕하세요"); // 문자열 출력
			fw.write(cbuf, 1, 2); // 문자 배열에서 C, D 출력
			fw.write("123"); // 숫자를 문자열 형태로 출력
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
