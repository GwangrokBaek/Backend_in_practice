package interfaceex;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customer = new Customer();
		
		Buy buyer = customer; // customer가 두 인터페이스를 상속받았지만, 어떤 인터페이스에 바인딩하느냐에 따라
		// 그 접근 범위를 제한할 수 있다.
		buyer.buy();
		
		Sell seller = customer;
		seller.sell();
		
		customer.order();
		buyer.order(); // 자바에서는 가상 메서드 개념을 사용하기 때문에 buyer의 order 메서드가 아닌, 오버라이드가 된
		// customer의 order 메서드를 호출하게 된다. 왜냐하면 인스턴스 생성은 Customer 생성자에 의해 생성이 되었고,
		// 이를 단순히 Buy 타입 및 Sell 타입에 할당해준 것 뿐이라서 인스턴스는 Customer 타입이기 때문에 Customer 클래스의
		// order 메서드가 호출된다.
		seller.order();
	}
}
