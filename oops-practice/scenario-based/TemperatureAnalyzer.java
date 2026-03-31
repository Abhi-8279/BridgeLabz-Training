public class TemperatureAnalyzer {

    public static void analyzeTemperatures(float[][] temp){
        float maxAvg = Float.MIN_VALUE;
        float minAvg = Float.MAX_VALUE;
        int hottestDay = 0, coldestDay = 0;

        System.out.println("Average temperature per day:");

        for(int i=0;i<temp.length;i++){
            float sum=0;

            for(int j=0;j<temp[i].length;j++){
                sum += temp[i][j];
            }

            float avg= sum/temp[i].length;
             System.out.println("Day " + (i + 1) + ": " + avg);

             if (avg > maxAvg) {
                maxAvg = avg;
                hottestDay = i + 1;
            }

            if (avg < minAvg) {
                minAvg = avg;
                coldestDay = i + 1;
            }
        }

         System.out.println("\nHottest Day: Day " + hottestDay);
        System.out.println("Coldest Day: Day " + coldestDay);

    }

   public static void main(String[] args) {
       float[][] temperatures = new float[7][24];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temperatures[i][j] = 20 + i + (j * 0.1f);
            }
        }

        analyzeTemperatures(temperatures);
   } 
}
