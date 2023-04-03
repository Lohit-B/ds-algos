import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

class MaximumMeetings {
    private static class MeetingSlot {
        public Integer start, end;
        public MeetingSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static int findMaximumMeetingsPossible(int[] start, int[] end) {
        int answer = 0;
        int len = start.length;
        ArrayList<MeetingSlot> meetings = new ArrayList<MeetingSlot>();
        for(int i=0; i<len; i++) {
            meetings.add(new MeetingSlot(start[i], end[i]));
        }

        Collections.sort(meetings, new Comparator<MeetingSlot>(){
            public int compare(MeetingSlot m1, MeetingSlot m2) {
                return m1.end.compareTo(m2.end);
            }
        });

        int current_end = -1;
        for(MeetingSlot meeting: meetings) {
            if(meeting.start >= current_end) {
                answer+=1;
                current_end = meeting.end;
            } 
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] start = new int[]{75250,50074,43659,8931,11273,27545,50879,77924};
        int[] end =   new int[]{112960,114515,81825,93424,54316,35533,73383,160252};
        System.out.println(findMaximumMeetingsPossible(start, end));
    }
}
