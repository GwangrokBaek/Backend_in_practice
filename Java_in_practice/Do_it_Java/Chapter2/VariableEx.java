// java에서는 char가 2 Bytes
// 자바에서는 UTF-16 인코딩을 사용하기 때문에 2 Bytes.
// 나머지는 C와 동일.

package binary;

public class VariableEx {

	public static void main(String[] args) {
		int num;
		num = 10;
		byte bData = -128;
		long lData = 12345678900L;
		// 정수 리터럴은 int형이기 때문에 long 변수에다 4바이트 이상의 리터럴값을 넣기 위해서는 리터럴 뒤에 L을 붙여줘야 한다.
		
		System.out.println(num);
		System.out.println(bData);
		System.out.println(lData);
		
		char cData = 'A';
		System.out.println(cData);
		System.out.println((int)cData);
		
		cData = 66;
		System.out.println(cData);
		
		int cData2 = 67; // 문자는 정수형으로 메모리에 저장된다.
		System.out.println((char)cData2); // 따라서 int 변수에 저장하더라도 타입 캐스팅을 통해 문자로 출력 가능.
		
		double dNum = 3.14;
		float fNum = 3.14F; // 실수 리터럴은 double 형이기 때문에 float 변수에 실수 리터럴을 넣기 위해서는
		// 뒤에 F를 붙여줘야 한다.
		
		System.out.println(dNum);
		System.out.println(fNum);
		
		boolean isMarried = true;
		System.out.println(isMarried);
		
		// 자바 10 부터는 지역 변수 자료형 추론(local variable type inference)을 지원하여
		// 따로 자료형을 명시하지 않더라도 원하는 값을 저장할 수 있다.
		// 이때 변수에 대입되는 값을 보고 컴파일러가 추론한다.
		// !주의점!
		// 1. 자료형 추론은 지역변수에만 사용가능하다!
		// 2. 자료형 추론을 통해 선언한 변수는 뒤에서 다른 자료형으로 바꾸지 못한다.
		
		var num2 = 10;
		var dNum2 = 10.0;
		var str = "Hello";
		
		System.out.println(num2);
		System.out.println(dNum2);
		System.out.println(str);
	}
}
