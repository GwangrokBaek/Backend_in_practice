package chapter4;

public class Star {
	public static void main(String[] args) {
		int h = 5;
		for (int i = 0; i < h; i++) {
			for (int j = h-1; j > 0; j--) {
				if (j > i) System.out.print(' ');
				else System.out.print('*');
			}
			for (int j = 0; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}

/*

    *
   ***
  *****
 *******
*********

*/