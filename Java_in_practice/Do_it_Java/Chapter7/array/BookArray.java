// 객체 배열이란 참조 자료형을 선언하는 객체 배열을 의미한다. 이때 배열만 생성한 경우, 요소는 null로 초기화 된다.
// 이때 new를 활용해서 각 요소를 생성하여 저장해야 한다.

package array;

public class BookArray {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		
		for(int i = 0; i < library.length; i++) {
			System.out.println(library[i]);
		}
		
		library[0] = new Book("태백산맥1", "조정래"); // new를 통해 인스턴스를 생성함으로써 메모리 주소가 생김.
		library[1] = new Book("태백산맥1", "조정래");
		library[2] = new Book("태백산맥1", "조정래");
		library[3] = new Book("태백산맥1", "조정래");
		library[4] = new Book("태백산맥1", "조정래");
	
	for (int i = 0; i < library.length; i++) {
		System.out.println(library[i]);
	}
	
	for (int i = 0; i < library.length; i++) {
		library[i].showBookInfo();
	}
	}
	
}
