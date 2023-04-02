import java.util.HashMap;

class MinLengthStringContainingAllChar {
    static String findMinLengthString(String big, String small) {
        HashMap<Character, Integer> small_string_chars = new HashMap<Character, Integer>();
        for(int i=0; i<small.length(); i++) {
            Character c = small.charAt(i);
            Integer count = small_string_chars.get(c);
            if (count == null) {
                count = 0;
            }
            small_string_chars.put(c, count-1);
        }
        int matches_required = -1*small.length();
        int big_size = big.length();
        int start = 0;
        int end = 0;
        String solution = "-1";
        int solution_length = big_size;
        while(end < big_size) {
            Character c = big.charAt(end);
            Integer count = small_string_chars.get(c);
            if (count != null) {
                if(count < 0) {
                    matches_required += 1;
                }
                small_string_chars.put(c, count+1);
            }
            if(matches_required == 0) {
                while(start < end) {
                    Character start_char = big.charAt(start);
                    count = small_string_chars.get(start_char);
                    if(count==null){
                        start+=1;
                        continue;
                    }
                    if(count==0) {
                        break;
                    }
                    if(count>0) {
                        small_string_chars.put(start_char, count-1);
                        start += 1;
                        continue;
                    }
                    start += 1;
                }
                System.out.println(big.substring(start, end+1));
                if(solution_length > end-start){
                    solution = big.substring(start, end+1);
                    solution_length = end-start;
                }
                Character start_char = big.charAt(start);
                small_string_chars.put(start_char, -1);
                start += 1;
                matches_required = -1;
            }
            end += 1;
        }
        return solution;
    }

    public static void main(String[] args) {
        String big = "zoomlazapzo";
        String small = "oza";
        System.out.println(findMinLengthString(big, small));
    }

}
