import java.util.HashMap;

public class LongestConsecutiveSequenece {

    public static int longestConsecutive(int[] nums) {
        return consecutive(nums);
    }

    public static int consecutive(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - 1)) {
                map.put(arr[i], false);
            } else {
                map.put(arr[i], true);
            }

            if (map.containsKey(arr[i] + 1)) {
                map.put(arr[i] + 1, false);
            }
        }

        int ans = 0;

        for (int key : map.keySet()) {
            if (map.get(key)) {
                int count = 0;
                int curr = key;

                while (map.containsKey(curr)) {
                    count++;
                    curr++;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
