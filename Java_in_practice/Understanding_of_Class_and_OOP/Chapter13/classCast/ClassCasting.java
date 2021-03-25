/*
 * 다형성을 이용한 클래스간의 형변환
 * 업캐스팅 : 서브 클래스의 오브젝트는 슈퍼 클래스의 오브젝트에 대입할 수 있다.
 * Super a = new Sub();
 * 
 * 다운캐스팅 : 서브 클래스로 생성되었던 오브젝트를 슈퍼 클래스의 오브젝트에 대입한 경우, 이를 다시 서브 클래스로 형변환할 수 있다.
 * Sub b = (Sub)a;
 * 
 * 이때 스택 영역에는 Super 타입의 참조 변수인 a 와 Sub 타입의 참조 변수인 b 가 위치하고, 힙 영역에는 Sub 클래스의 생성자를 통해
 * 생성한 인스턴스인 Sub 객체가 위치하게 되는데 다운 캐스팅을 해줄 경우, 참조 변수만 바뀌며 원래 생성된 객체는 그대로이다.
 */

package classCast;

class PBoard {}
class CBoard extends PBoard {}

public class ClassCasting {
	public static void main(String[] args) {
		PBoard sbd1 = new CBoard();
		CBoard sbd2 = (CBoard)sbd1; // 하위 클래스의 생성자로 만든 인스턴스를 상위 클래스 타입 변수에 할당하고 (업캐스팅) 이를 다시
		// 하위 클래스 타입 변수에 형변환을 사용하여 할당하는 것은 (다운캐스팅) 가능하다.
		
		System.out.println("-----------------");
		
		PBoard ebd1 = new PBoard();
		CBoard ebd2 = (CBoard)ebd1; // 인스턴스를 생성할때 하위 클래스의 생성자가 아닌 상위 클래스의 생성자를 통해 동일한 타입에
		// 인스턴스를 할당한 다음, 이를 하위 클래스 타입 변수에 형변환을 사용하여 할당하는 것은 다운캐스팅이 아니다. 또한 이는 불가능한 동작이므로
		// 런타임시에 오류가 발생한다. (컴파일 타임에는 문법적 구조는 맞기때문에 오류 발생 X)
	}
}
