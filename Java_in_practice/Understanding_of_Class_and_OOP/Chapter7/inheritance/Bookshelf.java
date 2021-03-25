/*
 * 상속 : 상속은 기능이 확장되는 것으로, 상위클래스의 모든 것이 하위클래스에게 전달되는 것을 뜻한다.
 * 하지만 상위클래스의 멤버 변수와 멤버 함수 중, private 으로 접근 제한이 된 경우에는 하위클래스로 전달이 되지 않는다.
 * 
 * 상속의 장점 :
 * 1. 클래스 간의 체계화된 전체 계층 구조를 파악하기 쉽다.
 * 2. 재사용성 증대 : 기존 클래스에 있는 것을 재사용할 수 있다.
 * 3. 확장 용이 : 새로운 클래스, 데이터, 메서드를 추가하기가 쉽다.
 * 4. 유지보수 용이 : 데이터와 메서드를 변경할때 상위에 있는 것만 수정하여 전체적으로 일관성을 유지할 수 있다.
 * 
 * 상속에서 대응되는 용어 :
 * 슈퍼 클래스 <-> 서브 클래스
 * 부모 클래스 <-> 자식 클래스
 * 기반 클래스 <-> 파생 클래스
 * 조상 클래스 <-> 자손 클래스
 * 상위 클래스 <-> 하위 클래스
 * 
 * 상속의 구현 : 서브 클래스를 만들기 위해서는 extends 를 사용한다. 자바에서는 여러 개의 클래스를 동시에 상속하는
 * 다중 상속을 허용하지 않는다.
 */

package inheritance;

class Book {
	String title;
	
	void printBook() {
		System.out.println("제   목 : " + title);
	}
}

class Novel extends Book {
	String writer;
	
	void printNov() {
		printBook();
		System.out.println("저   자 : " + writer);
	}
}

class Magazine extends Book {
	int day;
	
	void printMag() {
		printBook();
		System.out.println("발매일 : " + day + "일");
	}
}

public class Bookshelf {

	public static void main(String[] args) {
		Novel nov = new Novel();
		nov.title = "홍길동전";
		nov.writer = "허균";
		
		Magazine mag = new Magazine();
		mag.title = "월간 자바";
		mag.day = 20;
		
		nov.printNov();
		System.out.println();
		mag.printMag();
	}
}
