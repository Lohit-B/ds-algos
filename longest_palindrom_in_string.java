//Find longest palindrom substring
class LongestPalindrom {
    static int findLongestPalindrom(String input) {
        int answer = 1;
        int len = input.length();
        int[][] matrix = new int[len+1][len+1];
            
        for(int i=1; i<=len;i++) {
            for(int j=1; j<=len; j++) {
                if(input.charAt(len-i) == input.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    answer = Math.max(answer, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(findLongestPalindrom(input));
    }
}
