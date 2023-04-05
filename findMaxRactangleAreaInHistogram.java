import java.lang.Math;
class FindMaxAreaRectangleHistogram {

    static int findMaxAreaRecantangle(int[] heights) {
        int max_area = 0;
        int len = heights.length;
        int min_height = 0;
        for(int i=0; i<len; i++) {
            min_height = heights[i];
            for(int j=i; j<len; j++) {
                min_height = Math.min(min_height, heights[j]); 
                max_area = Math.max(max_area, (j-i+1)*min_height);
            }
        }

        return max_area;
    }
    
    public static void main(String[] args) {
        int[] heights = new int[] {6,2,5,4,5,1,6};
        System.out.println(findMaxAreaRecantangle(heights));
    }
}
