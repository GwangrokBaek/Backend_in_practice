// ArrayList 와 Vector
// 객체 배열을 구현한 클래스이다.
// Vector 는 자바 2 부터 제공된 클래스이다.
// 멀티 쓰레드 상태에서 리소스에 대한 동기화가 필요한 경우 Vector를 사용한다. (Vector 클래스의 메서드들을 보면 메서드 이름 앞에 synchronized 키워드가 오는데 이 키워드가 붙을 시,
// 메서드를 사용할 때 lock을 걸어서 동시에 하나의 자원에 접근하는 Critical Section 문제를 예방한다. 하지만 단일 쓰레드에서도 동기화를 수행하므로 오버헤드 발생 가능.)
// 일반적으로 ArrayList를 더 많이 사용한다.

// ArrayList에 동기화 기능이 추가되어야 하는 경우
// Collections.synchronizedList(new ArrayList<String>()); 로 사용 가능하다.
// 동기화 (synchronization) : 두 개의 쓰레드가 동시에 하나의 리소스에 접근할때 순서를 맞추어서 데이터에 오류가 발생하지 않도록 한다.

package collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

import collection.Member; // MemberArrayList 클래스는 collection.arraylist 아래에 있고, Member 클래스는 collection 아래에 있기 때문에 Member 클래스를
// 사용하기 위해서는 해당 클래스를 import 해주어야 한다.

public class MemberArrayList {
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		arrayList.add(member);
	}
	
	public boolean removeMember(int memberId) {
		
		/*
		for (int i = 0; i < arrayList.size(); i++) {
			Member member = arrayList.get(i); // List 인터페이스는 순서를 가지기 때문에 요소로 멤버 순회가 가능하다. 하지만 Set 인터페이스의 경우에는 불가능.
			int tempId = member.getMemberId();
			if (memberId == tempId) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
		*/

		/*
		 * Iterator 사용하여 순회하기
		 * Collection의 객체를 순회하는 인터페이스
		 * iterator() 메서드 호출
		 * Iterator ir = memberArrayList.iterator();
		 * 
		 * 선언된 메서드
		 * 메서드					설명
		 * boolean hasNext()	이후에 요소가 더 있는지를 체크하는 메서드이며, 요소가 있다면 true를 반환한다.
		 * E next()				다음에 있는 요소를 반환한다.
		 */
		
		Iterator<Member> iterator = arrayList.iterator(); // arrayList 또한 Collection 인터페이스 하위에 있으므로 iterator를 사용할 수 있다.
		// 보통 요소에 순차적으로 접근하지 못하는 경우 (set 등) 에 iterator를 통해 요소들을 뽑아낸다.
		// 이때 Iterator 또한 제네릭 프로그래밍이 가능한데, 만약 자료형을 명시해주지 않으면 next() 메서드에서 Object타입을 반환한다.
		
		while(iterator.hasNext()) { // 다음 차례에 데이터가 있는지를 확인
			Member member = iterator.next(); // 위에서 Member 타입으로 자료형을 명시해주었으므로 Membe 타입으로 요소를 반환한다.
			
			int tempId = member.getMemberId();
			if (memberId == tempId) {
				arrayList.remove(member); // remove() 메서드는 인덱스를 통해 요소를 지우는 것과, 객체 자체를 지우는 방법이 있다. 여기서는 객체 자체를 지우는 방법을
				// 사용하기 위해 member를 인자로 대입.
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAll() {
		/*
		for (Member member : arrayList) {
			System.out.println(member);
		}
		System.out.println();
		
		System.out.println(arrayList); // ArrayList 클래스에 toString() 메서드가 재정의되어 있는데, 이는 ArrayList에 존재하는 모든 멤버의 toString()을
		// 호출해서 이들을 쉼표와 함께 출력하는 것이다.
		*/
		
		Iterator<Member> ir = arrayList.iterator();
		while (ir.hasNext()) {
			Member mem = ir.next();
			System.out.println(mem);
		}
		System.out.println();
		
		System.out.println(arrayList);
	}
}
