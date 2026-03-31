public class FitnessChecker {
    public static void main(String[] args) {
        int pushupsperday[]= {45,23,1,22,0,13,24};

        int totalPushUps = 0;
        int workoutDays = 0;
        for(int pushups :pushupsperday){
            if(pushups==0){
                continue;
            }
            totalPushUps += pushups;
            workoutDays++;
        }
        double average = (double) totalPushUps / workoutDays;

        System.out.println("Total Push-ups in the Week: " + totalPushUps);
        System.out.println("Average Push-ups per Workout Day: " + average);
    }
}
