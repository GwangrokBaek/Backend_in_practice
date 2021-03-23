package abstractex;

public abstract class NoteBook extends Computer {

	@Override
	public void display() { // 추상 클래스를 상속받은 하위 클래스의 경우, 추상 클래스의 추상 메서드를 오버라이드를 통해 구현해주어야 한다.
		// 하지만, 구현하지 않을 경우 (또는 일부분의 추상 메서드만 구현해줄 경우) 하위 클래스에도 abstract를 붙여 추상 클래스로 만들어줘야 한다.
		System.out.println("NoteBook display()");
		
	}
}
