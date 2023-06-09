
class LongestPrefixSuffix {
    static int findLongestSufixPrefix(String input_string) {
        int string_len = input_string.length();
        if(string_len <= 1) {
            return 0;
        }
        char last_char = input_string.charAt(string_len-1);
        int start_suffix = 0;
        for(int i=string_len-2; i>=0; i--) {
            char current_char = input_string.charAt(i);
            if(last_char == current_char) {
                start_suffix = string_len-i-1;
                break;
            }
        }
        int start_prefix = 0;
        while (start_suffix < string_len) {
            char char_suffix = input_string.charAt(start_suffix);
            char char_prefix = input_string.charAt(start_prefix);
            if(char_suffix != char_prefix) {
                start_prefix = 0;
                start_suffix += 1;
            } else {
                start_suffix += 1;
                start_prefix += 1;
            }
        }
        return start_prefix;
    }
    public static void main(String[] args) {
        String input = "abcdbab";
        System.out.println(findLongestSufixPrefix(input));
    }

}
