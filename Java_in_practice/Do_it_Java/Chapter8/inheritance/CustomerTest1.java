// 상속에서 클래스 생성 과정
// 하위 클래스가 생성될 때 상위 클래스가 먼저 생성된다.
// 상위 클래스의 생성자가 호출되고, 하위 클래스의 생성자가 호출된다.
// 하위 클래스의 생성자에서는 무조건 상위 클래스의 생성자가 호출되어야 한다.
// 아무것도 없는 경우, 컴파일러는 상위 클래스 기본 생성자를 호출하기 위한 super()를 코드에 넣어 준다.
// super()가 호출되는 생성자는 상위 클래스의 기본 생성자이다.
// 만약 상위 클래스의 기본 생성자가 없는 경우 (매개변수가 있는 생성자만 존재하는 경우) 하위 클래스는 명시적으로 상위 클래스를 호출해야 한다.

// 상속에서의 메모리 상태
// 상위 클래스의 인스턴스가 먼저 생성이 되고, 하위 클래스의 인스턴스가 생성된다.
// 이때 상위 클래스에 private 멤버 변수가 있는 경우, 해당 변수는 힙 메모리에 생성되지 않는 것이 아니라, 생성은 되지만 접근만 불가능하다.
// 따라서 하위 클래스에서 get, set 메서드를 통해 접근이 가능하다.

// 상위 클래스로의 묵시적 형 변환 (업캐스팅)
// 상위 클래스 형으로 변수를 선언하고 하위 클래스 인스턴스를 생성할 수 있다.
// 하위 클래스는 상위 클래스의 타입을 내포하고 있으므로 상위 클래스로 묵시적 형변환이 가능하다.

package inheritance;

public class CustomerTest1 {

	public static void main(String[] args) {
		/*
		Customer customerLee = new Customer();
		customerLee.setCustomerID(10100);
		customerLee.setCustomerName("Lee");
		*/
		
		VIPCustomer customerKim = new VIPCustomer(10101, "Kim");
		// 하위 클래스가 생성될 때에는 항상 상위 클래스가 먼저 생성된다.
 		// customerKim.setCustomerID(10101);
		// customerKim.setCustomerName("Kim");
		
		// Customer vc = new VIPCustomer(10101, "Kim"); 업캐스팅이 적용된 클래스
		// 이때 vc는 하위 클래스인 VIPCustomer() 생성자의 호출로 상위 및 하위 클래스의 모든 인스턴스가 생성 되었지만,
		// 타입이 상위 클래스인 Customer() 이므로 접근할 수 있는 변수나 메서드는 Customer의 변수와 메서드 뿐이다.
		
		customerKim.bonusPoint = 1000;
		
		// System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerKim.showCustomerInfo());
	}

}
