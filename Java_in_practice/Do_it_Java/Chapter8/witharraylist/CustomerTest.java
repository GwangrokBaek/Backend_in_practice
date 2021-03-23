// 상속은 언제 사용할까?
// IS - A 관계 (is a relationship : inheritance)
// 일반적인 (general) 개념과 구체적인 (specific) 개념과의 관계
// 상위 클래스 : 일반적인 개념 클래스 (예 : 포유류)
// 하위 클래스 : 구체적인 개념 클래스 (예 : 사람, 원숭이, 고래 등)
// 단순히 코드를 재사용하는 목적으로 사용하지 않는다.

// HAS - A 관계 (composition) : 한 클래스가 다른 클래스를 소유한 관계
// 코드 재사용의 한 방법으로 Student가 Subject를 포함한 관계를 예로 들 수 있다.
// class Student {
//     Subject majorSubject;
// }

package witharraylist;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
		
		/*
		 * Customer[] customerList = new Customer[5];
		 * customerList[0] = new GoldCustomer(10012, "홍길동");
		 */
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10011, "신사임당");
		GoldCustomer customerHong = new GoldCustomer(10012, "홍길동");
		GoldCustomer customerYul = new GoldCustomer(10013, "이율곡");
		VIPCustomer customerKim = new VIPCustomer(10014, "김유신", 12345);
		
		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerYul);
		customerList.add(customerKim);
		
		System.out.println("============ 고객정보 출력 =============");
		for (Customer customer : customerList) {
			System.out.println(customer.showCustomerInfo());
		}
		
		System.out.println("============ 할인율과 보너스 포인트 결과 =============");
		int price = 10000;
		for (Customer customer : customerList) {
			int cost = customer.calcPrice(price);
			System.out.println(customer.getCustomerName() + "님이 " + cost + "를 지불하셨습니다.");
			System.out.println(customer.showCustomerInfo());
		}
	}

}
