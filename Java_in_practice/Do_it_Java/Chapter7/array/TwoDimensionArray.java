package array;

public class TwoDimensionArray {

	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}};
		
		System.out.println(arr.length); // 배열의 이름인 arr은 행을 가리킨다.
		System.out.println(arr[0].length); // arr[0] 은 첫 번째 행의 요소를 가리킨다.
		// 즉 이차원 배열은 일차원 배열 여러개로 구성된 것.
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}

	}

}
