import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Given information about streaming video plays, the times when they started and finished, find the maximum number that were playing concurrently.
 * <p>
 * Write a Java method that accepts an unordered array of play records and returns the maximum concurrency.
 * You can assume that all end times are after their corresponding start time, that each play lasts at most a few hours, and that all of the plays happen during one calendar month.
 */
public class Main {

    public int getMaximumConcurrentPlays(List<VideoPlayInfo> plays) {
        int concurrent = 0;
        for (int i = 0; i < plays.size(); i++) {
            for (int j = 1; j < plays.size(); j++) {
                if (i == j) break;
                if (checkDateOverlap(getLocalDateTime(plays.get(i).getStartTime()),
                        getLocalDateTime(plays.get(j).getStartTime()),
                        getLocalDateTime(plays.get(i).getEndTime()),
                        getLocalDateTime(plays.get(j).getEndTime()))) {
                    concurrent++;
                }
            }
        }
        return concurrent;
    }

    private LocalDateTime getLocalDateTime(Instant startTime) {
        return LocalDateTime.ofInstant(startTime, ZonedDateTime.now().getZone());
    }

    private boolean checkDateOverlap(LocalDateTime start1, LocalDateTime start2, LocalDateTime end1, LocalDateTime end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

}
