package generics;

public abstract class Material { // 제네릭 클래스의 타입 제한을 위해 상위 클래스를 사용할 경우, abstract를 쓸 필요는 없다. 하지만, 하위 클래스에서 특정 메서드에 대한
	// 구현을 강제하고 싶은 경우, abstract 메서드를 추가하는 방법이 있다. (메서드의 공유.)
	public abstract void doPrinting();
}
