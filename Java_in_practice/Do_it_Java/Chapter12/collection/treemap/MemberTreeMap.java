// TreeMap 클래스
// key 객체를 정렬하여 key - value 를 pair 로 관리하는 클래스이다.
// key 에 사용되는 클래스에 Comparable, Comparator 인터페이스를 구현해야 한다.
// java에 많은 클래스들은 이미 Comparable 이 구현되어 있다.
// 구현된 클래스를 key 로 사용하는 경우에는 위 인터페이스를 구현할 필요 없다.

package collection.treemap;

import java.util.TreeMap;
import java.util.Iterator;

import collection.Member;

public class MemberTreeMap {
	
	private TreeMap<Integer, Member> treeMap;
	
	public MemberTreeMap() {
		treeMap = new TreeMap<Integer, Member>();
	}
	
	public void addMember(Member member) {
		treeMap.put(member.getMemberId(), member); // key - value pair를 입력한다.
	}
	
	public boolean removeMember(int memberId) {
		if (treeMap.containsKey(memberId)) { // treeMap 구조에 memberId를 키로 하는 개체가 있는지 체크.
			
			treeMap.remove(memberId);
			return true;
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		Iterator<Integer> ir = treeMap.keySet().iterator(); // 모든 key에 대한 Set을 출력한 다음, 이를 iterator로 변환한다.
		
		while(ir.hasNext()) {
			int key = ir.next();
			
			Member member = treeMap.get(key);
			System.out.println(member);
		}
	}
}
