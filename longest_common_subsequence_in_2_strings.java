import java.lang.Math;

class LongestCommonSubSequence{
    static int findLongestCommonSubsequence(String s1, String s2) {
        int max_length = 0;
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1]; 

        for(int i=1; i<=s1.length();i++) {
            for(int j=1; j<=s2.length(); j++) {
                char s1_char = s1.charAt(i-1);
                char s2_char = s2.charAt(j-1);
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]); 
                if(s1_char == s2_char) {
                    matrix[i][j] = Math.max(matrix[i][j], matrix[i-1][j-1]+1);
                    if(max_length < matrix[i][j]) {
                        max_length = matrix[i][j];
                    }
                }
            }
        }
        
        return max_length;
    }

    public static void main(String[] args) {
        String s1=  "ABCDGH";
        String s2= "AEDFHR";
        System.out.println(findLongestCommonSubsequence(s1, s2));
    }

}
