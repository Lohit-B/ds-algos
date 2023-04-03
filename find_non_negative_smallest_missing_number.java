import java.lang.StringBuilder;

class SmallestMissingNumber {
    static int findSmallestNumber(int[] arr) {
        int answer = -1;
        int len = arr.length;
        StringBuilder bitmask = new StringBuilder();
        for(int i=0; i<=len; i++){
            bitmask.append('0');
        }
        for(int i=0; i<len; i++) {
            int num = arr[i];
            if(num < 0 ){
                continue;
            }
            if(num < len) {
                bitmask.setCharAt(num, '1');
            }
        }
        for(int i=0; i<=len; i++){
            Character bit = bitmask.charAt(i);
            if(bit != '1') {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,-10,2,3,4,5,7};
        System.out.println(findSmallestNumber(arr));
    }
}
