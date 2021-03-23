// 그 외 입출력 클래스
// File 클래스
// 파일 개념을 추상화한 클래스이다.
// 입출력 기능은 없고 파일의 속성, 경로, 이름 등을 알 수 있다.

// RandomAccessFile 클래스
// 입출력 클래스 중 유일하게 파일 입출력을 동시에 할 수 있는 클래스이다.
// C 처럼 파일 포인터가 있어서 읽고 쓰는 위치의 이동이 가능하다.
// 다양한 자료형에 대한 메서드가 제공된다.
// 보통 In, OutStream 을 사용해서 파일 입출력을 제어하는 것이 정석이지만, 간단한 경우에는 RandomAccessFile 을 사용할 수도 있다.

package stream.others;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");
		rf.writeInt(100); // 4 바이트만큼 작성.
		System.out.println(rf.getFilePointer()); // getFilePointer() 메서드는 파일 포인터의 위치를 가져오는데, 앞서 4 바이트만큼
		// 작성하였으므로 현재 파일 포인터의 위치는 4 이다.
		rf.writeDouble(3.14); // 8 바이트만큼 작성.
		System.out.println(rf.getFilePointer()); // 앞서 4 의 위치에 파일 포인터가 있었으므로 8 바이트만큼 더 작성하면
		// 현재 파일 포인터의 위치는 12 가 된다.
		rf.writeUTF("안녕하세요"); // UTF 에서는 한글 하나당 3 바이트를 쓰니 3 * 5 에 String 이므로 마지막에 널문자가 들어가는데,
		// 널문자는 2 바이트이기 때문에 총 17 바이트가 된다.
		System.out.println(rf.getFilePointer()); // 현재 파일 포인터의 위치는 4 + 8 + 17 = 29 가 된다.
		
		rf.seek(0); // 현재 파일 포인터의 위치가 29 이므로 이를 다시 맨 처음 자리로 옮겨줘야 한다. 이때 파일 포인터를 seek() 메서드를 통해
		// 옮길 수 있으며 0 은 파일의 처음을 의미한다.
		
		int i = rf.readInt();
		double d = rf.readDouble();
		String str = rf.readUTF();
		
		System.out.println(i);
		System.out.println(d);
		System.out.println(str);
	}
}
