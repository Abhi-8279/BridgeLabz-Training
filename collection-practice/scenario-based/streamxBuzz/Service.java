import java.util.*;

public class Service implements Engagement {

    @Override
    public void registerCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    @Override
    public Map<String, Integer> getTopPostCounts(
            List<CreatorStats> records,
            double likeThreshold) {

        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats creator : records) {
            int count = 0;

            for (double likes : creator.getWeeklyLikes()) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }

            if (count > 0) {
                result.put(creator.getCreatorName(), count);
            }
        }

        return result;
    }

    @Override
    public double calculateAverageLikes() {

        double totalLikes = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.EngagementBoard) {
            for (double likes : creator.getWeeklyLikes()) {
                totalLikes += likes;
                totalWeeks++;
            }
        }

        if (totalWeeks == 0)
            return 0;

        return totalLikes / totalWeeks;
    }
}
