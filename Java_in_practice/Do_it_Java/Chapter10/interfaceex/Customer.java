package interfaceex;

public class Customer implements Buy, Sell{ // Buy와 Sell interface 모두 order라는 이름으로 동일한 default 메서드를
	// 가지기에 오류가 발생. 따라서 이를 해결해주기 위해 default 메서드를 오버라이드 해주어야 한다.

	@Override
	public void sell() {
		System.out.println("판매하기");
	}

	@Override
	public void buy() {
		System.out.println("구매하기");
	}
	
	@Override
	public void order() {
		System.out.println("고객 판매 주문");
	}
}
