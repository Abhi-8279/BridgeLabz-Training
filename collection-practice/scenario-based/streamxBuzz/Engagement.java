import java.util.*;

public interface Engagement {

    void registerCreator(CreatorStats record);

    Map<String, Integer> getTopPostCounts(
            List<CreatorStats> records,
            double likeThreshold
    );

    double calculateAverageLikes();
}
