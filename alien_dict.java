import java.util.*;

class AlienDict {

    static int findCharOrder(String[] dict) {
        List<Character> order = new ArrayList<Character>();
        HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();

        //creating Map
        for(int i=0; i<dict.length-1; i++) {
            int j=0,k=0;
            while(j<dict[i].length() && k<dict[i+1].length()) {
                char first = dict[i].charAt(j);
                char second = dict[i+1].charAt(k);
                HashSet<Character> set_1 = map.get(first);
                HashSet<Character> set_2 = map.get(second);
                if(set_1 == null) {
                    set_1  = new HashSet<Character>();
                    map.put(first, set_1);
                }
                if(set_2 == null) {
                    set_2  = new HashSet<Character>();
                    map.put(second, set_2);
                }
                if(first != second) {
                    set_1.add(second);
                    break;
                }
                j++;
                k++;
            }
            while(j<dict[i].length()) {
                char first = dict[i].charAt(j);
                HashSet<Character> set_1 = map.get(first);
                if(set_1 == null) {
                    set_1  = new HashSet<Character>();
                    map.put(first, set_1);
                }
                j++;
            }
            while(k<dict[i+1].length()) {
                char second = dict[i+1].charAt(k);
                HashSet<Character> set_2 = map.get(second);
                if(set_2 == null) {
                    set_2  = new HashSet<Character>();
                    map.put(second, set_2);
                }
                k++;
            }
        }

        //derefrencing
        for(Map.Entry<Character, HashSet<Character>> entry: map.entrySet()) {
            Map<Character, Boolean> referenced = new HashMap<Character, Boolean>();
            HashSet<Character> set = entry.getValue();
            LinkedList<Character> list = new LinkedList<Character>(set); 
            while(list.size() > 0) {
                Character c = list.poll();
                if(referenced.get(c) != null) {
                    continue;
                }
                HashSet<Character> children = map.get(c);
                if(children != null) {
                    set.addAll(children);
                    list.addAll(children);
                }
                referenced.put(c, true);
            }
        }

        //validating
        for(Map.Entry<Character, HashSet<Character>> entry: map.entrySet()) {
            Character key = entry.getKey();
            System.out.print(key);
            System.out.print(entry.getValue());
            System.out.println("++++++++++++++");
            for(Character c :entry.getValue()) {
                if(c==key) {
                    return -1;
                }
            }
        }

        List<Map.Entry<Character, HashSet<Character>>> list = new ArrayList<Map.Entry<Character, HashSet<Character>>>(map.entrySet());
        Collections.sort(list, ((e1,e2)->((Integer)e2.getValue().size()).compareTo((Integer)(e1.getValue().size()))));

        int total_alphabets = list.size();

        for(int i=0; i<total_alphabets; i++) {
            order.add(list.get(i).getKey());
        }

        System.out.print(order);

        return 1;

    }
    
    public static void main(String[] args) {
        String[] dict = new String[] {"caakuyt", "aaa", "aak", "aab"};
        System.out.println(findCharOrder(dict));
    }
}
