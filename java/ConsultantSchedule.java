public class ConsultantSchedule {
    public static class Schedule {
        String schedule;
        int value;
        
        public Schedule(String schedule, int value) {
            this.schedule = schedule;
            this.value = value;
        }
    }
    
    public static String consultantSchedule(int[] ny, int[] bos) {
        Schedule newYork = consultantScheduleNewYork(ny, bos, 0);
        Schedule boston = consultantScheduleBoston(ny, bos, 0);
        
        if (newYork.value > boston.value) return newYork.schedule;
        return boston.schedule;
    }
    
    private static Schedule consultantScheduleBoston(int[] ny, int[] bos, int i) {
        if (i >= ny.length) return new Schedule("", 0);
        Schedule stay = consultantScheduleBoston(ny, bos, i+1);
        Schedule move = consultantScheduleNewYork(ny, bos, i+1);
        
        if (stay.value + bos[i] > move.value) 
            return new Schedule("B" + stay.schedule, stay.value + bos[i]);
        return new Schedule("T" + move.schedule, move.value);
    }
    
    private static Schedule consultantScheduleNewYork(int[] ny, int[] bos, int i) {
        if (i >= ny.length) return new Schedule("", 0);
        Schedule stay = consultantScheduleNewYork(ny, bos, i+1);
        Schedule move = consultantScheduleBoston(ny, bos, i+1);
        
        if (stay.value + ny[i] > move.value) 
            return new Schedule("N" + stay.schedule, stay.value + ny[i]);
        return new Schedule("T" + move.schedule, move.value);
    }
    
    public static void main(String[] args) {
        System.out.println(consultantSchedule(new int[]{1,2,3,4,4,3,2,1}, new int[]{4,3,2,1,1,2,3,4}));
    }
}