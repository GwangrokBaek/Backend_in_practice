// ArrayList 클래스
// 기존 배열은 길이를 정하여 선언하므로 사용 중 부족한 경우 다른 배열로 복사하는 코드를 직접 구현해야 한다.
// 또한, 중간의 요소가 삭제되거나 삽입되는 경우도 나머지 요소에 대해 이를 조정하는 코드를 구현해야 한다.

// ArrayList 클래스는 자바에서 제공되는 객체 배열이 구현된 클래스이다.
// 이는 여러 메서드와 속성 등을 사용하여 객체 배열을 편리하게 관리할 수 있다.
// 자바 프로그램에서 가장 많이 사용되는 객체 배열 클래스이다.

// ArrayList 클래스 주요 메서드
// boolean add(E e) : 요소 하나를 배열에 추가한다. E는 요소의 자료형을 의미한다.
// int size() : 배열에 추가된 요소 전체 개수를 반환한다.
// E get(int index) : 배열의 index 위치에 있는 요소 값을 반환한다.
// E remove(int index) : 배열의 index 위치에 있는 요소 값을 제거하고 그 값을 반환한다.
// boolean isEmpty() : 배열이 비어 있는지 확인한다.

// 이렇게 많은 메서드를 제공함으로써 요소를 추가하거나 제거할 때 각 내부에서 코드가 모두 구현되어 있으므로 배열을 직접 선언하여
// 사용하는 것보다 편리하다.

package array;

import java.util.ArrayList; // 사용자 자료형 위에 마우스 포인트를 올리고 Ctrl + Shift + O 를 누르면
// 사용하고자 하는 클래스에서 필요로 하는 패키지를 자동으로 import 해준다.

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		// ArrayList list = new ArrayList(); // 타입을 명시해주지 않는 경우, get 메서드를 통해서 데이터를 가져오는 경우에는
		// 최상위 클래스인 object 타입으로 데이터를 가져오므로 데이터를 가져올 때 타입 캐스팅을 해주어야 한다.
		
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for (String s : list) {
			System.out.println(s);
		}
		
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list[i]) // ArrayList 클래스에서는 일반 배열과는 달리 인덱스 연산자를 통한 접근 기능을
			// 제공하지 않는다. 따라서 get 메서드 등을 사용해서 값을 출력해야 한다.
			
			// String s = (String)list.get(i); // 위에서 타입을 명시해주지 않은 경우, object 타입으로 데이터를 가져오므로
			// 타입 캐스팅을 해주어야 한다.
			
			System.out.println(list.get(i));
		}
	}

}
