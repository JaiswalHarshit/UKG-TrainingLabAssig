package assg1;


class Copy{
		
	public static int[] copyOf(int[] arr) {
		int[] copyArr = new int[10];
		for(int i=0;i<10;i++)
			copyArr[i]=arr[i];
			
		return copyArr; 
		
		
	}
}


public class ArrayCopy {

	public static void main(String[] args) {
		int[] arr= {0,1,2,3,4,5,6,7,8,9};
		int[] copyArr = new int[10];
		
		copyArr = Copy.copyOf(arr);
		
		System.out.println("Copy of array is:");
		for(int i=0;i<10;i++)
			System.out.print(copyArr[i]+" ");
	}

}
