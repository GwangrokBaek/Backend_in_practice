// 컬렉션 프레임워크
// 프로그램 구현에 필요한 자료구조 (Data Structure) 를 구현해 놓은 라이브러리이다.
// java.util 패키지에 구현되어 있다.
// 개발에 소요되는 시간을 절약하면서 최적화된 알고리즘을 사용할 수 있다.
// 여러 인터페이스와 구현 클래스 사용 방법을 이해해야 한다.

/*
 * 		Collection (단일 객체)	 |	    		   Map (쌍으로된 객체 key - value pair)
 * 	 ^				^		 |		 ^			^		  ^
 * List			   Set		 |	  HashTable  HashMap   TreeMap
 *   ^				^		 |	     ^
 * ArrayList	 HashSet	 |	 Properties
 * Vector		 TreeSet     |
 * LinkedList                |
 * 
 * 위 계층 구조는 특정 클래스를 구현하는데 있어 어떤 것을 구현해야 하는지에 대한 정보를 알려준다. ArrayList 를 구현하기 위해서는 해당 클래스가 List에 포함되고,
 * Collection 범주에 포함되므로 List 인터페이스에서 사용하는 것들을 구현하고, Collection 인터페이스에서 사용되는 메서드들을 구현해야함을 알려준다.
 * 
 * Collection 인터페이스
 * 하나의 객체를 관리하기 위한 메서드가 선언된 인터페이스이다.
 * 하위에 List와 Set 인터페이스가 있다.
 * 여러 클래스들이 Collection 인터페이스를 구현한다.
 * 
 * List 인터페이스
 * List는 선형 자료구조로 데이터들 간의 관계가 1 대 1인 경우이다.
 * 즉 앞의 요소가 하나, 뒤의 요소가 하나로 1 대 1 관계를 가지는 순서를 가지는 순차적인 자료구조이다. (요소가 중복되도 된다.)
 * 이 인터페이스를 구현한 클래스로는 ArrayList, Vector, LinkedList, Stack, Queue 등이 있다.
 * 
 * Set 인터페이스
 * Set은 집합으로서 요소의 중복을 허용하지 않으며 순서가 정해져 있지 않다. 따라서 유일한 데이터를 관리하는데에 사용된다. (ID, 학번 등)
 * 이 인터페이스를 구현한 클래스로는 HashSet, TreeSet 등이 있다.
 * 
 * Vector는 동기화를 지원하며, ArrayList는 동기화를 지원하지 않는다.
 * TreeSet은 보통 정렬에 많이 사용된다.
 * 
 * HashTable은 동기화를 지원하며, HashMap은 동기화를 지원하지 않는다.
 * Properties는 파일을 읽어 Key - Value pair로 데이터를 관리할 수 있다. 즉, I/O와 연관되는 기능을 가진다. (ex, DB는 무엇이고 등등)
 * 
 * 이때 Collection과 Map 모두 Iterator 특징을 가지며, 이를 통해 객체의 모든 요소를 순회할 수 있다.
 * 
 * Collection 인터페이스에 선언된 주요 메서드
 * 메서드						설명
 * boolean add(E e)			Collection에 객체를 추가합니다.
 * void clear()				Collection의 모든 객체를 제거합니다.
 * Iterator<E> iterator		Collection을 순환할 반복자 (Iterator) 를 반환합니다.
 * boolean remove(Object o) Collection에 매개변수에 해당하는 인스턴스가 존재하면 제거합니다.
 * int size()				Collection에 있는 요소의 개수를 반환합니다.
 */

package collection;

import java.util.Comparator;

public class Member implements Comparable<Member>, Comparator<Member> {
	// Tree 구조에서 객체 비교를 위해서는 Comparable 이나 Comparator 인터페이스를 구현해주어야 한다. 보통 둘 중 하나를 사용한다.
	// 만약 Comparable 인터페이스가 이미 구현되어 있는 클래스에서 다른 비교 방법을 사용하고 싶은 경우, Comparator 를 추가로 구현해주면 된다.
	
	private int memberId;
	private String memberName;
	
	public Member() {}
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString() {
		return memberName + " 회원님의 아이디는 " + memberId + "입니다.";
	}

	@Override
	public int hashCode() {
		return memberId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member)obj;
			if (this.memberId == member.memberId) {
				return true;
			}
			else return false;
		}
		return false;
	}
	
	/*
	 * Comparable 인터페이스와 Comparator 인터페이스
	 * 정렬 대상이 되는 클래스가 구현해야 하는 인터페이스이다.
	 * Comparable은 compareTo() 메서드를 구현한다. 이때 매개 변수와 객체 자신 (this) 을 비교한다.
	 * Comparator는 compare() 메서드를 구현한다. 이때 두개의 매개 변수를 비교한다.
	 * 
	 * TreeSet 생성자에 Comparator가 구현된 객체를 매개변수로 전달한다.
	 * TreeSet<Member> treeSet = new TreeSet<Member>(new Member());
	 * 
	 * 일반적으로 Comparable을 더 많이 사용한다.
	 * 이미 Comparable이 구현된 경우에는 Comparator를 이용하여 다른 정렬 방식을 정의할 수 있다.
	 */

	@Override
	public int compareTo(Member member) { // Comparable 인터페이스를 구현할 때 재정의가 필요한 메서드.
		// return (this.memberId - member.memberId) * (-1) // memberId를 비교해서 내림차순으로 정렬.
		return (this.memberId - member.memberId); // 매개변수로 들어온 개체의 memberId와 기존 개체의 memberId를 비교했을 때 양수냐 음수냐에 따라 정렬 수행.
		// 이때 양수를 출력하면 오름차순으로 정렬이 되고, 음수를 출력하면 내림차순으로 정렬된다.
		
		// return (this.memberName.compareTo(member.memberName)) * (-1); String의 경우 이미 compareTo() 메서드가 재정의 되어 있으므로 compareTo 메서드를
		// 호출해주면 정렬할 수 있다. 이때 기본적으로 오름차순으로 정렬을 수행하며, -1을 곱하면 내림차순으로 정렬된다.
	}

	@Override
	public int compare(Member member1, Member member2) { // Comparator 인터페이스를 구현할 때 재정의가 필요한 메서드.
		// 이때 2개의 인자값을 받는데, 앞의 인자는 기존 개체이고 뒤의 인자는 새로 받는 개체이다.
		return (member1.memberId - member2.memberId); // 마찬가지로 음수를 출력하면 내림차순으로 정렬된다.
	}
}
