import java.lang.Math;
import java.util.Arrays;

class MaximumSubarrayMultiple {
	static long calculateMaxMultiplication(int[] array) {
		long max_multiple_overall = 1;
		long multiple_before_first_negative = 1;
		long multiple_after_first_negative = 1;
		long first_negative = 1;
		long second_negative = 1;
		long multiple_after_second_negative = 1;
		int total_negatives = 0;
		
		for(int num: array) {
			if (num < 0) {
				total_negatives += 1;
				if(second_negative < 0 ){
					multiple_after_first_negative *= second_negative*multiple_after_second_negative;
					second_negative = num;
					multiple_after_second_negative = 1;
				} else if (first_negative < 0) {
					second_negative = num;
				} else {
					first_negative = num;
				}
			} else if (num > 0) {
				if(second_negative < 0 ){
					multiple_after_second_negative *= num;
				} else if (first_negative < 0) {
					multiple_after_first_negative *= num;
				} else {
					multiple_before_first_negative *= num;
				}
			} else {
				if(total_negatives % 2 == 0 ){
					max_multiple_overall = Math.max(max_multiple_overall, multiple_before_first_negative*first_negative*multiple_after_first_negative*second_negative*multiple_after_second_negative);
				} else {
					max_multiple_overall = Math.max(max_multiple_overall, Math.max(multiple_before_first_negative*first_negative*multiple_after_first_negative, multiple_after_first_negative*second_negative*multiple_after_second_negative));
				}
				multiple_before_first_negative = 1;
				multiple_after_first_negative = 1;
				first_negative = 1;
				second_negative = 1;
				multiple_after_second_negative = 1;
				total_negatives = 0;
			}
		}
		if(total_negatives % 2 == 0 ){
			max_multiple_overall = Math.max(max_multiple_overall, multiple_before_first_negative*first_negative*first_negative*multiple_after_first_negative*second_negative*multiple_after_second_negative);
			
		} else {
			max_multiple_overall = Math.max(max_multiple_overall, Math.max(multiple_before_first_negative*first_negative*multiple_after_first_negative, multiple_after_first_negative*second_negative*multiple_after_second_negative));
		}
		return max_multiple_overall;
	}

	public static void main(String[] args) {
		int[] array = new int[]{-1,2,3,-2,-6,-8,0,1};
		System.out.println(calculateMaxMultiplication(array));
	}
}
