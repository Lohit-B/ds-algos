import java.util.ArrayDeque;
import java.util.ArrayList;
//For a given array and an integer K, find the max number in each contiguous subarray of length K
class MaxOfSubArray {
	static ArrayList<Integer> findMaxOfSubArray(int[] arr, int k) {
		int n = arr.length;
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		if(arr.length == 0) {
			return answer;
		}
		deque.addLast(0);
		for(int i=1; i<k; i++) {
			Integer peek_last = deque.peekLast();
			while(peek_last != null && arr[peek_last] < arr[i]) {
				deque.pollLast();
				peek_last = deque.peekLast();
			}
			deque.addLast(i);
		}
		int end = k-1;
		while(end<n) {
			Integer peek_first = deque.peekFirst(); 
			while(peek_first != null && peek_first+k <= end) {
				deque.pollFirst();
				peek_first = deque.peekFirst();
			}
			Integer peek_last = deque.peekLast();
			while(peek_last != null && arr[deque.peekLast()] < arr[end]) {
				deque.pollLast();
				peek_last = deque.peekLast();
			}
			deque.addLast(end);
			answer.add(arr[deque.getFirst()]);
			end+=1;
		}
		return answer;
	}
	public static void main (String[] args) {
		int[] array = new int[] {1,2,3,2,1,1,4,5,2,1,3,6};
		int k = 3;
		ArrayList<Integer> answer = findMaxOfSubArray(array, k);
		for(int i:answer) {
			System.out.println(i);
		}
	}
} 
