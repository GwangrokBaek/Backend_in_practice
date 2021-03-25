/*
 * 생성자 : 오브젝트 생성과 함께 자동적으로 호출되는 특수한 메서드이다.
 * 따라서 개발자가 생성자를 정의하지 않는 경우, 인수가 없는 디폴트 생성자가 자동으로 만들어진다.
 * 
 * 생성자의 특징 :
 * 1. 메서드와 같은 모양이지만 반환형이 없다.
 * 2. 클래스의 이름과 동일한 이름을 가진다.
 * 3. 상속이 불가능하다.
 * 
 * 생성자는 가장 흔한 오버로딩의 대상이다.
 */

package step1;

class Book {
	String title; // 책 제목
	int price; // 책 가격
	int num; // 주문 수량
	
	Book() {
		title = "자바 클래스 기초";
		price = 10000;
	}
	
	Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	void print() {
		System.out.println("제   목 : " + title);
		System.out.println("가   격 : " + price);
		System.out.println("주문수량 : " + num);
		System.out.println("합계금액 : " + price * num);
	}
}

public class MyBook {

	public static void main(String[] args) {
		// Book book = new Book();
		Book book = new Book("자바 디자인 패턴", 20000);
		book.num = 5;
		book.print();
	}

}
