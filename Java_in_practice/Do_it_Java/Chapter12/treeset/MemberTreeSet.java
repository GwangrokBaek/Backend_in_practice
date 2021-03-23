// TreeSet 클래스
// 객체의 정렬에 사용되는 클래스이다.
// 중복을 허용하지 않으면서 오름차순이나 내림차순으로 객체를 정렬한다.
// 내부적으로 이진 검색 트리 (binary search tree) 로 구현되어 있다.
// 이진 검색 트리에 자료가 저장될 때 이를 비교하여 저장될 위치를 정한다.
// 객체 비교를 위해 Comparable 이나 Comparator 인터페이스를 구현해야 한다.

package treeset;

import java.util.Iterator;
import java.util.TreeSet;

import collection.Member;

public class MemberTreeSet {
	private TreeSet<Member> treeSet;
	
	public MemberTreeSet() {
		treeSet = new TreeSet<Member>(new Member()); // Comparator 인터페이스의 compare() 메서드를 사용하기 위해서는 TreeSet 생성자의 인자에다
		// Member 클래스의 디폴트 생성자를 넣어줘야 한다. 만약 Comparable과 Comparator 인터페이스 모두가 구현되어 있을 때 이렇게 디폴트 생성자를 넣어주면,
		// Comparator 인터페이스의 compare() 메서드를 사용한다.
		// 따라서 보통 기존에 이미 compare 관련 메서드가 정의되어 있는 경우, 다른 비교 방법을 사용하고 싶을때 Comparator 인터페이스를 구현한 다음, compare() 메서드를
		// 재정의 함으로써 새로운 비교 방법을 사용하곤 한다.
		// 기본적으로는 Comparable 인터페이스를 많이 사용한다.
	}
	
	public void addMember(Member member) {
		treeSet.add(member);
	}
	
	public boolean removeMember(int memberId) {
		
		Iterator<Member> iterator = treeSet.iterator();
		
		while(iterator.hasNext()) {
			Member member = iterator.next();
			
			int tempId = member.getMemberId();
			if (memberId == tempId) {
				treeSet.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAll() {
		
		Iterator<Member> ir = treeSet.iterator();
		while (ir.hasNext()) {
			Member mem = ir.next();
			System.out.println(mem);
		}
		System.out.println();
		
		System.out.println(treeSet);
	}
}