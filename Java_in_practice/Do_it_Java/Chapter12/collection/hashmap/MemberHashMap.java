// Map 인터페이스
// key - value pair 의 객체를 관리하는데 필요한 메서드가 정의된다.
// key는 중복될 수 없다.
// 검색을 위한 자료구조이다.
// key를 이용하여 값을 저장하거나 검색, 삭제할때 사용하면 편리하다.
// 내부적으로 hash 방식으로 구현된다.
// index = hash(key) // index는 저장위치.
// key가 되는 객체는 객체의 유일성의 여부를 알기 위해 equals() 와 hashCode() 메서드를 재정의해야 한다.

// TreeMap 클래스
// key 객체를 정렬하여 key - value 를 pair 로 관리하는 클래스이다.
// key 에 사용되는 클래스에 Comparable, Comparator 인터페이스를 구현해야 한다.
// java에 많은 클래스들은 이미 Comparable 이 구현되어 있다.
// 구현된 클래스를 key 로 사용하는 경우에는 위 인터페이스를 구현할 필요 없다.

// HashMap 클래스
// Map 인터페이스를 구현한 클래스 중 가장 일반적으로 사용하는 클래스이다.
// HashTable 클래스는 자바 2 부터 제공된 클래스로 Vector 처럼 동기화를 제공한다.
// 여러 메서드를 활용하여 pair 자료를 쉽고 빠르게 관리할 수 있다.

package collection.hashmap;

import java.util.HashMap;
import java.util.Iterator;

import collection.Member;

public class MemberHashMap {
	
	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap() {
		hashMap = new HashMap<Integer, Member>();
	}
	
	public void addMember(Member member) {
		hashMap.put(member.getMemberId(), member); // key - value pair를 입력한다.
	}
	
	public boolean removeMember(int memberId) {
		if (hashMap.containsKey(memberId)) { // hashMap 구조에 memberId를 키로 하는 개체가 있는지 체크.
			
			hashMap.remove(memberId);
			return true;
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		Iterator<Integer> ir = hashMap.keySet().iterator(); // 모든 key에 대한 Set을 출력한 다음, 이를 iterator로 변환한다.
		
		while(ir.hasNext()) {
			int key = ir.next();
			
			Member member = hashMap.get(key);
			System.out.println(member);
		}
	}
}
