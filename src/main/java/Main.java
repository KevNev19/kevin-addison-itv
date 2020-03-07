import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Given information about streaming video plays, the times when they started and finished, find the maximum number that were playing concurrently.
 * <p>
 * Write a Java method that accepts an unordered array of play records and returns the maximum concurrency.
 * You can assume that all end times are after their corresponding start time, that each play lasts at most a few hours, and that all of the plays happen during one calendar month.
 */
public class Main {

    public int getMaximumConcurrentPlays(List<VideoPlayInfo> plays) {
        int counter = 0;
        for (int i = 0; i < plays.size(); i++) {
            for (int j = 1; j < plays.size(); j++) {
                if (checkDateRangeOverlaps(plays.get(i).getStartTime(), plays.get(j).getEndTime())) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean checkDateRangeOverlaps(Instant start, Instant end) {
        long numOfHoursBetween = ChronoUnit.HOURS.between(start, end);
        return numOfHoursBetween < 0;
    }

}
