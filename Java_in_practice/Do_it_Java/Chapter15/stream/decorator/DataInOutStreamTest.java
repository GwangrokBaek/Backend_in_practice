// DataInputStream 과 DataOutputStream
// 자료가 메모리에 저장된 0, 1 상태 그대로 읽거나 쓰는 스트림이다.

// 읽는 메서드
// 메서드							설명
// byte readByte()				1 바이트를 읽어 반환한다.
// boolean readBoolean()		읽은 자료가 0 이 아니면 true 를, 0 이면 false 를 반환한다.
// char readChar()				한 문자를 읽어 반환한다.
// short readShort()			2 바이트를 읽어 정수 값을 반환한다.
// int readInt()				4 바이트를 읽어 정수 값을 반환한다.
// long readLong()				8 바이트를 읽어 정수 값을 반환한다.
// float readFloat()			4 바이트를 읽어 실수 값을 반환한다.
// double readDouble()			8 바이트를 읽어 실수 값을 반환한다.
// String readUTF()				수정된 UTF-8 인코딩 기반으로 문자열을 읽어 반환한다.

// 쓰는 메서드
// 메서드							설명
// void writeByte(int v)		1 바이트의 자료를 출력한다.
// void writeBoolean(boolean v)	1 바이트 값을 출력한다.
// void writeChar(int v)		2 바이트를 출력한다.
// void writeShortint v()		2 바이트를 출력한다.
// void writeInt(int v)			4 바이트를 출력한다.
// void writeLong(long v)		8 바이트를 출력한다.
// void writeFloat(float v)		4 바이트를 출력한다.
// void writeDouble(double v)	8 바이트를 출력한다.
// void writeUTF(String str)	수정된 UTF-8 인코딩 기반으로 문자열을 출력한다.

package stream.decorator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOutStreamTest {

	public static void main(String[] args) {
		// FileInputStream 및 FileOutputStream 의 경우, 문자가 정수로 변환되거나 정수가 문자로 변환되는 등
		// 실제 데이터의 타입과 입력 및 출력되는 데이터의 타입이 서로 다르다. 이때 DataOutputStream 및 DataInputStream 을
		// 사용해서 데이터 타입을 동일하게 사용할 수 있다.
		
		try(FileOutputStream fos = new FileOutputStream("data.txt");
			DataOutputStream dos = new DataOutputStream(fos)) {
			
			// DataOutputStream 의 write() 메서드는 다양한 매개변수를 입력 받을 수 있다.
			dos.write(100); // 정수 1 바이트를 쓴다.
			dos.writeInt(10); // 정수 4 바이트를 쓴다.
			dos.writeChar('A'); // 문자 하나를 쓴다.
			dos.writeUTF("hello"); // 문자열을 쓴다.
			// 이때 실제 파일을 열어보면 이상하게 데이터가 저장되어 있지만, 이를 DataInputStream 으로 읽을때에는
			// 정확히 데이터를 읽어온다.
			
		} catch(IOException e) {
			System.out.println(e);
		}
		
		try(FileInputStream fis = new FileInputStream("data.txt");
				DataInputStream dis = new DataInputStream(fis)) {
			
			System.out.println(dis.read()); // 사용한 출력 메서드와 대응되는 입력 메서드를 사용해야 한다.
			// 위에서 1 바이트만큼 저장하는 write() 메서드를 사용했는데 4 바이트만큼 읽는 readInt() 메서드를 사용할 경우,
			// 출력 데이터가 깨진다.
			System.out.println(dis.readInt());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
			
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}
