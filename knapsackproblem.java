import java.lang.*;
class KnapSackSolver {

    static int findMaxWeight(int[] weight, int[] value, int k) {
        int maxWeight = 0;
        int[][] map = new int[weight.length+1][k+1];
        for(int i=1; i<=weight.length; i++) {
            for(int j=1; j<=k; j++) {
                if(j==0 || i==0) {
                    map[i][j] = 0;
                    continue;
                }
                if(weight[i-1] <= j) {
                    map[i][j] = Math.max(map[i-1][j], value[i-1]+map[i-1][j-weight[i-1]]);
                } else {
                    map[i][j] = map[i-1][j];
                }
            }
        }

        return map[weight.length][k];
    }
    
    public static void main(String[] args) {
        int[] weight = new int[]{6,1,2,3,4,5};
        int[] value = new int[]{6,1,3,3,4,5};
        int weightLimit = 8;
        int maxWeight = findMaxWeight(weight, value, weightLimit);
        System.out.println(maxWeight);
    }
}
