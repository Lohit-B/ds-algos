import java.lang.Math;
import java.lang.Integer;
class MinimizeDiff {

    static Integer[][] store;

    static void fillHash(int current_sum, int index, int[] arr, int[] hash) {
        if(index >= arr.length) {
            return;
        }
        if(store[current_sum][index] != null) {
            //return;
        }
        System.out.println("here");
        int new_sum = current_sum+arr[index];
        hash[new_sum] = 1;
        fillHash(current_sum, index+1, arr, hash);
        store[current_sum][index+1] = 1;
        fillHash(new_sum, index+1, arr, hash);
        store[new_sum][index+1] = 1;
    }
    static int findMinDiffBetween2Grps(int[] arr) {
        int max_sum = 0;
        for(int i:arr) {
            if(i<0) {
                continue;
            }
            max_sum += i;
        }
        int[] hash = new int[max_sum+1];
        store = new Integer[max_sum+1][arr.length+1];

        // find sum with and without the element recursively
        // update sum to hash array
        // find diff between 2 consecutive hashed elements
        fillHash(0,0,arr, hash);
        int min_diff = max_sum;
        for(int i=0; i<hash.length; i++) {
            if(hash[i] == 0) {
                continue;
            }
            min_diff = Math.min(min_diff, Math.abs(max_sum-2*i));
        }
        return min_diff;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,5,6};
        int diff = findMinDiffBetween2Grps(arr);
        System.out.println(diff);
    }

}
