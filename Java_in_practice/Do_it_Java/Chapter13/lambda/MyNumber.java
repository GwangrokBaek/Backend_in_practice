// 함수형 인터페이스
// 람다식을 선언하기 위한 인터페이스이다.
// 익명 함수와 매개 변수만으로 구현되므로 단 하나의 메서드만을 가져야한다. (두 개 이상의 메서드인 경우에는 어떤 메서드의 호출인지 모호해진다.)

// @FunctionalInterface 애노테이션
// 함수형 인터페이스라는 의미를 나타내며, 여러 개의 메서드를 선언하면 에러가 발생한다.

// 익명 객체를 생성하는 람다식
// 자바는 객체 지향 언어로서 객체를 생성해야 메서드가 호출된다.
// 람다식으로 메서드를 구현하고 호출하면 내부에서 익명 클래스가 생성된다.
/*
 * StringConcat concat3 = new StringConcat() {
 *     @Override
 *     public void makeString(String s1, String s2) {
 *         System.out.println(s1 + "," + s2);
 *     }
 * };
 */
// 람다식에서 외부 메서드의 지역변수는 상수로 처리된다. (지역 내부 클래스와 동일한 원리.)

package lambda;

@FunctionalInterface
public interface MyNumber { // 람다식을 위한 함수형 인터페이스
	// 함수형 인터페이스에서는 메서드를 하나만 선언할 수 있다. 2개 이상인 경우, 사용하는 쪽에서 람다식을 구현 했을때 어떤 메서드와 대응이 되는지 모호해지기 때문이다.
	// @FunctionalInterface annotation을 작성해줄시 2개 이상의 메서드를 선언하는 경우, 인터페이스 쪽에서 오류를 발생시켜준다.
	
	int getMaxNumber(int num1, int num2);
	// void add();
}
