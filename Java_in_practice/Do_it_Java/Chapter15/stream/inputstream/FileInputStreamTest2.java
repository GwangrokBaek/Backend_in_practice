// FileInputStream 클래스
// 파일로부터 자료를 읽어들이는 스트림이다.
// 읽어들일 파일이 경로에 없는 경우에는 예외가 발생한다.

package stream.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("input2.txt")) { // input2.txt 파일 입력 스트림을 생성한다.
			byte[] bs = new byte[10];
			int i;
			while((i = fis.read(bs)) != -1) { // 배열의 크기만큼 읽고 저장하여 출력.
				/*
				for (byte b : bs) { // 배열 전체를 출력하므로 알파벳의 경우 마지막 4 바이트가 남는데,
					// 이때 쓰레기 값 (이전에 받았던 값인 QRST) 이 출력된다.
					
					System.out.print((char)b);
				}
				*/
				
				for (int j = 0; j < i; j++) { // 위에서 배열을 인자로 받은 read() 메서드는 읽은 바이트 수를 반환하여
					// i 에 저장하므로 고정된 배열 크기만큼 출력하지 않고, 입력된 바이트 수만큼만 출력하므로 쓰레기 값을
					// 출력하지 않는다.
					System.out.print((char)bs[j]);
				}
				
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
