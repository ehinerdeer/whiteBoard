import java.lang.reflect.Array;
import java.util.Arrays;

/** These are questions found on the web to practice
 *  doing white board problems for interviews.
 *  Each function should be commented with time complexity
 *  using Big-O notation. Have Fun! 
 */
/**
 * @author ehinerdeer
 *
 * NOTE: Mostly the extra work in the functions is to have them print out.
 * If returning an array change the function to int[] and return the array instead
 * of making it into a string to print. 
 */
public class whiteBoard {

	public static void main(String[] args) {
		int[] array1 = {4, 12, 6, 8, 20};
		int[] array2 = {4, 8, 20, 12};
		int[] array3 = {3, 6, 10, 11, 21, 3, 4, 2, 15};
		int[] array4 = {3, 6, 10, 11, 21, 3, 4, 2, 15, 4, 11, 10};
		int[] array5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] array6 = {3, 6, 10, 11, 21, 3, 4, 2, 15, 4, 11, 10};
		int[] array7 = {3, 6, 10, 11, 21, 3, 4, 2, 15, 4, 11, 10};
		int[] reverse = reverseArray(array5);
		
		System.out.println("Answer: " + missingNum1(array1, array2));
		System.out.println("Answer: " + missingNumXOR(array1, array2));
		System.out.println("Answer: " + duplicateNum(array3));
		System.out.println("Answer: " + multDupNum(array4));
		System.out.println("Answer: " + maxMinArray(array4));
		
		System.out.print("Array: ");
		for(int i = 0; i < array5.length; i++) {
			System.out.print(array5[i] + " ");
		}
		System.out.println("");
		System.out.print("Reverse: ");
		for(int k = 0; k < reverse.length; k++) {
			System.out.print(reverse[k] + " ");
		}
		System.out.println("");
		System.out.print("Array: ");
		for(int i = 0; i < array6.length; i++) {
			System.out.print(array6[i] + " ");
		}
		int[] removeDups = removeDupsSort(array6);
		System.out.println("");
		System.out.print("Remove Dups: ");
		for(int k = 0; k < removeDups.length; k++) {
			System.out.print(removeDups[k] + " ");
		}
		System.out.println("");
		System.out.print("Array: ");
		for(int i = 0; i < array7.length; i++) {
			System.out.print(array7[i] + " ");
		}
		int[] removeDupsNoSort = removeDupsNoSort(array7);
		System.out.println("");
		System.out.print("Remove Dups: ");
		for(int k = 0; k < removeDupsNoSort.length; k++) {
			System.out.print(removeDupsNoSort[k] + " ");
		}
	}

	/* Question 1 - Write a function to find the missing number 
	 * in 2 arrays with integers between 1-100 without using any
	 * built in comparison functions.
	 * Example: Array1 = {4, 12, 6, 8, 20}
	 * 			Array2 = {4, 8, 20, 12}
	 * Function should return 6 as the missing number */

	// O(N^2)
	public static int missingNum1(int[] array1, int[] array2) {
		int answer = 0, count1 = 0, count2 = 0;
		
		for(int i = 0; i < array1.length; i++)
		{
			count1 += array1[i];
		}
		for(int k = 0; k < array2.length; k++)
		{
			count2 += array2[k];
		}
		answer = Math.abs(count1 - count2);
		
		return answer;
	}
	/* O(N*M) where M is the max number of bits in the numbers
	 * This is faster for the range 1-100 because 100 is only a 7 bit number */
	public static int missingNumXOR(int[] array1, int[] array2) {
		int answer = 0;
		
		for(int i = 0; i < array1.length; i++) {
			answer ^= array1[i];
		}
		for(int i = 0; i < array2.length; i++) {
			answer ^= array2[i];
		}
		
		return answer;
	}
	/* Question 2 - Find a duplicate number in a given array 
	 * Example: Array = {3, 6, 10, 11, 21, 3, 4, 2, 15} 
	 * Your function should return 3 */
	public static int duplicateNum(int[] array1) {
		int answer = 0;
		Arrays.sort(array1);
		
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == array1[i + 1]) {
				answer = array1[i];
				break;
			}
		}
		
		return answer;
	}
	/* Question 2 Bonus - Find multiple duplicates and return them to be printed
	 * NOTE: the values are guaranteed to be 1-100 so anything outside should not
	 * be printed or returned */
	
	// O(N^2) for making the answer and then converting to string
	// Could be O(N) if only returning the answer array
	public static String multDupNum(int[] array1) {
		int[] answer = new int[array1.length];
		Arrays.sort(array1);
		int count = 0;
		for(int i = 1; i < array1.length; i++) {
			if(array1[i] == array1[i - 1]) {
				answer[count] = array1[i];
				count++;
			}
		}
		
		String answer2 = "";
		for(int k = 0; k < answer.length; k++) {
			if(answer[k] != 0) {
				answer2 += answer[k] + " ";
			}
		}
		
		return answer2;
	}
	
	/* Question 3 - Find the largest and smallest number in an unsorted array 
	 * of values 1-100
	 * NOTE: Sorting the array is not allowed */ 
	
	// O(N) for length of array1
	public static String maxMinArray(int[] array1) {
		String answer = "";
		int min = 100;
		int max = 0;
		
		for(int i = 0; i < array1.length; i++) {
			if(min > array1[i]) {
				min = array1[i];
			}
			if(max < array1[i]) {
				max = array1[i];
			}
		}
		
		answer = "Max: " + max + " Min: " + min;
		
		return answer;
	}
	
	/* Question 4 - Reverse an array of integers without using a built in
	 * reverse function from Java library. */
	public static int[] reverseArray(int[] array) {
		int[] answer = new int[array.length];
		
		int end = array.length - 1;
		
		for(int i = 0; i < array.length; i++) {
			answer[end] = array[i];
			end--;
		}
		
		return answer;
	}
	
	/* Question 5 - Remove duplicate items from an array 
	 * NOTE: This version sorts the final answer */
	public static int[] removeDupsSort(int[] array) {
		int source = 1;
		int dest = 0;
		int count = 0;
		Arrays.sort(array);
		 
		for(int i = 0; i < array.length; i++) {
			if(source != array.length ) {
				if(array[dest] == array[source]) {
					count++;
					source++;
					dest++;
					array[dest] = 0;
				} else {
					source++;
					dest++;
				}
			} 
		}
		
		int[] answer = new int[array.length - count];
		dest = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				answer[dest] = array[i];
				dest++;
			}
		}
		
		return answer;
	}
	
	/* Question 5 - removing duplicates without sorting the array 
	 * 
	 * NOTE : NOT FINISHED */
	public static int[] removeDupsNoSort(int[] array) {
		int dest = 0;
		int count = 0;
		
		while(dest < array.length) {
			int source = 1;
			if(source != array.length) {
			for(int i = 0; i < array.length; i++) {
				if(array[dest] == array[i]) {
					array[dest] = 0;
					count++;
				}
				source++;
			}
			dest++;
			}
		}
		
		int[] answer = new int[array.length - count];
		dest = 0;
		for(int k = 0; k < array.length; k++) {
			if(array[k] != 0) {
				answer[dest] = array[k];
				dest++;
			}
		}
		
		return answer;
	}
	
}

	
	


