// 제네릭 (Generic) 프로그래밍
// 변수의 선언이나 메서드의 매개변수를 하나의 참조 자료형이 아닌 여러 자료형으로 변환될 수 있도록 프로그래밍하는 방식이다.
// 실제 사용되는 참조 자료형으로의 변환을 컴파일러가 검증하므로 안정적인 프로그래밍 방식이다.
// 컬렉션 프레임워크에서 많이 사용되고 있다.

// 제네릭 클래스 정의하기
// 여러 참조 자료형으로 대체될 수 있는 부분을 하나의 문자로 표현한다.
// 이 문자를 자료형 매개변수라고 한다.
// 아래 public class ThreeDPrinter<T> 에서 ThreeDPrinter<T> 를 제네릭 클래스라고 하며,
// T는 type의 약자로서 자료형 매개변수이다. T 이외에도 다른 여러 문자를 사용할 수 있다.

// 자료형 매개변수 T
// type의 의미로 T를 많이 사용한다.
// <T> 에서 <>는 다이아몬드 연산자라고 한다.
// static 키워드는 T에 사용할 수 없다. (인스턴스가 생성될때 T가 결정되는데 static은 인스턴스 생성과 상관없이 사용가능하기 때문이다.)
// ArrayList<String> list = new ArrayList<>(); 다이아몬드 연산자 내부에서 자료형은 생략 가능하다.
// 제네릭에서 자료형 추론을 사용할 수 있다. (자바 10부터)
// ArrayList<String> list = new ArrayList<String>(); 를 var list = new ArrayList<String>(); 로 사용가능하다.

package generics;

public class ThreeDPrinter<T extends Material> { // 이때 자료형 매개변수 뒤에 extends를 명시해주면 해당 클래스를 상속받은 클래스들만 자료형으로 사용할 수 있게끔 한다.
	// 즉 매개변수로 받는 자료형의 타입을 제한할 수 있다. 이때 Water 클래스는 Material 클래스를 상속받지 않았으므로 사용이 불가능하다.

	/*
	private Object material; // Object는 모든 클래스의 최상위 클래스이므로 여러 타입을 받아들일 수 있다. (제네릭 프로그래밍 대신 Object를 사용하는 경우)
	
	public Object getMaterial() {
		return material;
	}

	public void setMaterial(Object material) {
		this.material = material;
	}
	*/
	
	private T material; // 자료형 매개변수 T는 Object 타입으로 다 대치가 되며, 실제로 사용할때에 지정한 타입으로 컴파일러가 캐스팅을 수행해준다.

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
		// material. 을 해보면 material에서 볼 수 있는 참조형들은 Object와 관련된 것들 밖에 없다. 하지만 제네릭 클래스가 상속받은 Material을 추상 클래스로 정의하고,
		// 추상 메서드를 추가하면 material의 메서드가 또한 볼 수 있어 추가적인 메서드 사용이 가능하다. (메서드의 공유가 가능.)
	}

	@Override
	public String toString() {
		return material.toString();
	}
	
	public void printing() {
		material.doPrinting(); // 제네릭 클래스가 상속받은 추상 클래스인 Material 클래스의 추상 메서드 사용 가능.
	}
}
