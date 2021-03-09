// 배열 복사 하기 : 기존 배열과 같은 배열을 만들거나 배열이 꽉 찬 경우 더 큰 배열을 만들고 기존 배열 자료를 복사할 수 있다.
// System.arraycopy(src, srcPos, dest, destPos, length);
// src : 복사할 배열 이름
// srcPos : 복사할 배열의 첫 번째 위치
// dest : 복사해서 붙여 넣을 대상 배열 이름
// destPos : 복사해서 대상 배열에 붙여 넣기를 시작할 첫 번째 위치
// length : src에서 dest로 자료를 복사할 요소 개수

// 얕은 복사 : 배열 요소의 주소만 복사 되므로 배열 요소가 변경되면 복사된 배열의 값도 변경 됨

package array;

public class ObjectCopy {

	public static void main(String[] args) {
		Book[] bookArray1 = new Book[3];
		Book[] bookArray2 = new Book[3];
		
		bookArray1[0] = new Book("태백산맥1", "조정래");
		bookArray1[1] = new Book("태백산맥2", "조정래");
		bookArray1[2] = new Book("태백산맥3", "조정래");

		bookArray2[0] = new Book(); // 깊은 복사를 위해서는 인스턴스를 별도로 생성해주어야 한다.
		bookArray2[1] = new Book();
		bookArray2[2] = new Book();
		
		// System.arraycopy(bookArray1, 0, bookArray2, 0, 3);
		
		// 객체 배열을 복사하면 배열의 값이 복사되는 것이 아니라, 주소가 복사되기 때문에 원본의 값을 수정할 경우,
		// 복사본의 값도 동일하게 수정이 된다.
		// 만약 값을 복사하여 원본을 수정했을 때 복사본은 수정하고 싶지 않다면, 즉 별도로 관리하고 싶다면 깊은 복사를 사용해야 한다.
		// 깊은 복사는 인스턴스를 새로 생성해준 다음에 arraycopy 메서드를 사용하지 않고 값을 넣어줘야 한다.
		
		for (int i = 0; i < bookArray1.length; i++) {
			bookArray2[i].setBookName(bookArray1[i].getBookName());
			bookArray2[i].setAuthor(bookArray1[i].getAuthor());
		} // 깊은 복사를 위해 위에서 인스턴스를 별도로 생성해준 다음 arraycopy가 아닌 get, set 메서드를 통해 값을 복사해준다.
		
		for (int i = 0; i < bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}
		
		bookArray1[0].setBookName("나목");
		bookArray1[0].setAuthor("박완서");
		
		for (int i = 0; i < bookArray1.length; i++) {
			bookArray2[i].showBookInfo();
		}
		
		System.out.println("========================");
		
		for (int i = 0; i < bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}
		
		// 향상된 for 문 (enhanced for loop)
		// 배열 요소의 처음부터 끝까지 모든 요소를 참조할 때 편리하게 사용할 수 있는 반복문.
		// for(변수 : 배열) {
		//     반복 실행문;
		// }
		
		String[] strArr = {"Java", "Android", "C"};
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		for(String s : strArr) { // strArr 배열의 각 요소가 s 변수에 하나씩 대입된다.
			System.out.println(s);
		}
		
		int[] arr = {1, 2, 3, 4, 5};
		
		for (int num : arr) {
			System.out.println(num);
		}
	}

}
