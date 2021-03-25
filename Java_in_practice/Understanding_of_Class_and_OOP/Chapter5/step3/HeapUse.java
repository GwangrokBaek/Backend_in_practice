package step3;

class Book {
	String title;
}

public class HeapUse {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.title = "자바 클래스 기초";
		
		Book book2 = book1; // 얕은 복사 (동일한 객체를 참조한다.)
		
		System.out.println("book1.title : " + book1.title);
		System.out.println("book2.title : " + book2.title);
		System.out.println("-------------------------------");
		
		book1.title = "자바 디자인 패턴";
		
		System.out.println("book1.title : " + book1.title);
		System.out.println("book2.title : " + book2.title);
	}
}