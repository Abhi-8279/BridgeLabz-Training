public class ShortestToLongest {

    static int[] findMinMax(String[][] table) {
        int min = Integer.parseInt(table[0][1]);
        int max = min;
        int minIdx = 0, maxIdx = 0;

        for (int i = 1; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);
            if (len < min) {
                min = len;
                minIdx = i;
            }
            if (len > max) {
                max = len;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }
}
