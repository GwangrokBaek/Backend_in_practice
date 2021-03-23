package interfaceex;

public interface MyInterface extends X, Y { // 인터페이스 상속
	// 인터페이스 간에도 상속이 가능하다.
	// 이때 구현코드의 상속이 아니므로 타입 상속(type inheritance) 라고 한다.
	void myMethod();
}
