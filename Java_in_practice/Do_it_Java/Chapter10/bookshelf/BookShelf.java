// 인터페이스 구현과 클래스 상속 함께 사용하기
// 실제 프레임워크 (스프링, 안드로이드 등) 를 사용하면 클래스를 상속 받고
// 여러 인터페이스를 구현하는 경우가 종종 있다.

package bookshelf;

public class BookShelf extends Shelf implements Queue {

	@Override
	public void enQueue(String title) {
		shelf.add(title);
	}

	@Override
	public String deQueue() {
		return shelf.remove(0);
	}

	@Override
	public int getSize() {
		return getCount();
	}

}
