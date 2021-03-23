package generics;

import java.util.ArrayList;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		
		/*
		ThreeDPrinter printer = new ThreeDPrinter();
		
		printer.setMaterial(new Powder());
		
		Powder powder = (Powder)printer.getMaterial(); // Object 타입으로 메서드 작성시, 모든 타입을 받을 수 있지만 이를 사용할때에는 하위 클래스로
		// 다운캐스팅을 해주어야 한다. 이 대신에 제네릭 프로그래밍을 사용할 수 있다.
		*/
		
		ThreeDPrinter<Powder> printer = new ThreeDPrinter<Powder>();
		printer.setMaterial(new Powder());
		Powder powder = printer.getMaterial(); // 제네릭 프로그래밍을 사용할 시, 모든 타입을 받을 수 있으며 컴파일러가 자동으로 다운캐스팅을 해주므로 직접 해줄 필요가 없다.
		System.out.println(printer);
		
		ThreeDPrinter<Plastic> printerPlastic = new ThreeDPrinter<Plastic>();
		printerPlastic.setMaterial(new Plastic());
		Plastic plastic = printerPlastic.getMaterial();
		System.out.println(printerPlastic);
		
		/*
		ThreeDPrinter<Water> printerWater = new ThreeDPrinter<Water>(); // Water 클래스는 Material 클래스를 상속받지 못하였으므로 제네릭 클래스에서 사용 불가능.
		printerWater.setMaterial(new Water());
		System.out.println(printerWater);
		*/
		
		printerPlastic.printing();
		
		// 제네릭에서 대입된 자료형을 명시하지 않는 경우
		// 본래 ThreeDPrinter<Powder> 와 같이 사용할 자료형 (Powder) 을 명시해준다.
		// 자료형을 명시하지 않고도 사용할 수 있는데, 이러한 경우 자료형을 명시하라는 경고 표시가 나타난다.
		// 이런 경우에는 반환형에 따라 강제로 형변환을 해줘야 한다.
		
		ThreeDPrinter printerPowder = new ThreeDPrinter(); // 자료형 명시 X
		printerPowder.setMaterial(new Powder());
		Powder powder2 = (Powder)printerPowder.getMaterial(); // 자료형을 명시하지 않았으므로 강제로 형변환을 해줘야한다.
		System.out.println(printerPowder);
		
		// ArrayList에서도 마찬가지로 자료형을 명시하지 않고 사용할 수 있으며, 대신 사용할때에는 강제로 형변환을 해주어야 한다. 그렇지 않으면 Object 타입으로 사용하게 된다.
		
		ArrayList list = new ArrayList();
	}

}
