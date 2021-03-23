package hashSetTest;

import java.util.HashSet;
import java.util.Iterator;

import collection.Member;

public class MemberHashSet {
	private HashSet<Member> hashSet;
	
	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}
	
	public void addMember(Member member) {
		hashSet.add(member);
	}
	
	public boolean removeMember(int memberId) {
		
		Iterator<Member> iterator = hashSet.iterator();
		
		while(iterator.hasNext()) {
			Member member = iterator.next();
			
			int tempId = member.getMemberId();
			if (memberId == tempId) {
				hashSet.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAll() {
		
		Iterator<Member> ir = hashSet.iterator();
		while (ir.hasNext()) {
			Member mem = ir.next();
			System.out.println(mem);
		}
		System.out.println();
		
		System.out.println(hashSet);
	}
}