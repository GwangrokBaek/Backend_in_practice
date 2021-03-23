// 다형성 (polymorphism)
// 하나의 코드가 여러가지 자료형으로 구현되어 실행되는 것.
// 정보은닉, 상속과 더불어 객체지향 프로그래밍의 가장 큰 특징 중 하나이다.
// 객체지향 프로그래밍의 유연성, 재활용성, 유지보수성에 있어 기본이 되는 특징이다.

package inheritance;

public class OverridingTest {
	public static void main(String[] args) {
		/*
		Customer customerLee = new Customer(100010, "LEE");
		int price = customerLee.calcPrice(10000);
		System.out.println("지불 금액은 " + price + "이고, " + customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer(100010, "Kim", 100);
		price = customerKim.calcPrice(10000);
		System.out.println("지불 금액은 " + price + "이고, " + customerKim.showCustomerInfo());
		*/
		
		Customer customerWho = new VIPCustomer(100010, "Who", 100);
		// 하위 클래스의 생성자를 통해 상위 클래스 타입에 인스턴스를 할당한 경우, 하위 클래스에서 오버라이딩된 메서드를 호출할 때
		// 자바에서는 상위 클래스의 메서드가 아닌 하위 클래스에서 오버라이딩된 메서드를 호출한다.
		// 이는 가상 메서드 개념으로서 자바에서 모든 메서드는 가상 메서드로서 동작한다.
		// 가상 메서드 : 프로그램에서 어떤 객체의 변수나 메서드의 참조는 그 타입에 따라 이루어진다. (따라서 하위 클래스 생성자를 통해
		// 상위 클래스 타입에 할당된 인스턴스는 상위 클래스의 변수와 메서드를 참조할 수 있다.) 하지만 가상 메서드의 경우는 타입과 상관없이
		// !!실제 생성된 인스턴스의 메서드가 호출 되는 원리를 가진다.!! 따라서 customerWho의 타입이 실제로는 상위 클래스인 Customer 이지만,
		// calcPrice 메서드는 실제 생성된 인스턴스인 VIPCustomer 클래스에서 재정의된 calcPrice() 메서드가 호출된다.
		
		// Customer 클래스의 가상 메서드 테이블
		// 메서드									메서드 주소		메서드 영역
		// calcPrice (재정의됨)					0xFF00FFAA		Customer 클래스 - calcPrice()
		// showCustomerInfo (재정의되지 않음)		0x112233AA		Customer 클래스 - showCustomerInfo()
		//
		// VIPCustomer 클래스의 가상 메서드 테이블
		// 메서드									메서드 주소		메서드 영역
		// calcPrice (재정의됨)					0x00335577		VIPCustomer 클래스 - 재정의된 calcPrice()
		// showCustomerInfo (재정의되지 않음)		0x112233AA		Customer 클래스 - showCustomerInfo()
		// getAgentID (하위 클래스에서 추가된 메서드)	0x8899BB33		VIPCustomer 클래스 - getAgentID()
		int price = customerWho.calcPrice(10000);
		System.out.println("지불 금액은 " + price + "이고, " + customerWho.showCustomerInfo());
		
		Customer customerGold = new GoldCustomer(100010, "Some");
	}
}
