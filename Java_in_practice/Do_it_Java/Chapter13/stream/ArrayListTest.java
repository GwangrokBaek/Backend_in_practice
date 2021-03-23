package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>(); // List 인터페이스는 ArrayList 클래스의 상위 개념이므로 List 타입에 할당 가능.
		sList.add("Tomas");
		sList.add("James");
		sList.add("Edward");
		
		Stream<String> stream = sList.stream(); // 위에서 sList의 타입인 List가 String 제네릭 타입이므로 sList의 stream() 메서드를
		// Stream 타입의 변수에 할당하기 위해서는 Stream 의 제네릭 타입을 String으로 명시해주어야 한다.
		stream.forEach(s->System.out.println(s)); // 요소를 하나씩 돌기 위해 forEach() 메서드 사용. 아래 enhanced for 문과
		// 동일한 기능을 수행한다. 이때 스트림 버퍼를 모두 돌았으므로 스트림이 소모된다. 다시 사용하기 위해서는 재생성을 해야한다.
		
		/* 
		for(String s : sList) {
			System.out.println(s);
		}
		*/
		
		sList.stream().sorted().forEach(s->System.out.println(s)); // 스트림을 오름차순으로 정렬하여 forEach() 메서드를 통해
		// 하나씩 출력된다. 이때 sorted() 까지는 중간 연산자이며, forEach() 가 최종 연산자이다.
	}
}
