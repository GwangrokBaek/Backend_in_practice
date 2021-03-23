package abstractex;

public class ComputerTest {

	public static void main(String[] args) {
		// Computer c1 = new Computer(); Computer는 추상 클래스인데 추상 클래스는 인스턴스화하지 못하므로 new 사용 불가능.
		// 왜냐하면, 추상 클래스의 인스턴스 생성이 가능한 경우, c1.display() 가 동작되어야 하는데 Computer 클래스의 display 메서드는
		// 선언만 하였고, 구현되지 않았기 때문에 불가능하기 때문이다.
		
		Computer c2 = new DeskTop(); // 따라서 업캐스팅을 통해 하위 클래스의 인스턴스를 상위 클래스 타입에 할당해준다.
		// Computer c3 = new NoteBook();
		Computer c4 = new MyNoteBook();
		NoteBook c5 = new MyNoteBook();
		
		// 추상 메서드는 프레임워크에서 틀을 제공하고 수정 (작성) 되어야 할 부분을 나타내주는데에 많이 이용되곤 한다.
		// 예를 들어, 안드로이드에서 리스트 뷰를 생성하여 무언가를 보여주고 싶을때 어댑터 클래스를 상속받는데, 이때 많은 추상 메서드를 직접 구현해주어야 한다.
		// 따라서 상위 클래스에서는 어떻게 보여줄 것이다만 정의되어 있으며, 하위 클래스에서는 구체적으로 무엇을 보여줄 것인가를 구현해주는 것이다.
		
		// 또는 특정 클래스를 상속용으로만 사용하고 싶을때 이용하기도 한다. (new를 통해 직접 인스턴스를 만드는 것이 불가능하므로)
	}

}
