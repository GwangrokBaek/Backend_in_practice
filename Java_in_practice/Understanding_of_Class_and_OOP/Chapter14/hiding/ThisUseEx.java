/*
 * 은닉화
 * 객체의 변수를 public 으로 설정하면, 외부에서 마음대로 해당 변수를 사용할 수 있다.
 * - 의도하지 않은 범위의 값을 넣을 수 있다.
 * - 원하지 않는 데이터 타입을 강제적으로 형변환하여 넣을 수도 있다.
 * 
 * 하지만 은닉화를 수행하면, 변수를 향한 직접적인 접근을 막으며, getter 및 setter 를 통해 변수에 접근하고 그 과정에서 조건 검사를
 * 수행할 수 있다.
 */

package hiding;

class SimpleBox {
	private int num;
	
	SimpleBox(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

public class ThisUseEx {

	public static void main(String[] args) {
		SimpleBox box = new SimpleBox(5);
		box.setNum(10);
		System.out.println(box.getNum());
	}
}
