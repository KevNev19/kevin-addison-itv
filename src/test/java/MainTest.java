import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    public static final ZoneOffset UTC = ZoneOffset.UTC;
    private VideoPlayInfo videoPlayInfo;
    private Main main;
    private List<VideoPlayInfo> videoPlayInfos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        main = new Main();
        videoPlayInfos = setupArrayForTest();
    }

    private List<VideoPlayInfo> setupArrayForTest() {
        LocalDateTime feb0120 = LocalDateTime.of(2020, 2, 1, 0, 0, 0);
        LocalDateTime feb0220 = LocalDateTime.of(2020, 2, 2, 0, 0, 0);
        List<VideoPlayInfo> infos = new ArrayList<>();

        //Start time = 1 Feb 2020 T 00:00:00 & End Time 1 Feb 2020 02:00:00
        infos.add(VideoPlayInfo.builder().startTime(feb0120.toInstant(UTC)).endTime(feb0120.plusHours(2).toInstant(UTC)).build());
        //Start time = 1 Feb 2020 T 00:30:00 & End Time 1 Feb 2020 02:30:00
        infos.add(VideoPlayInfo.builder().startTime(feb0120.plusMinutes(30).toInstant(UTC)).endTime(feb0120.plusHours(2).plusMinutes(30).toInstant(UTC)).build());
        //Start time = 1 Feb 2020 T 23:59:59 & End Time 2 Feb 2020 02:00:00
        infos.add(VideoPlayInfo.builder().startTime(feb0120.plusHours(23).plusMinutes(59).plusSeconds(59).toInstant(UTC)).endTime(feb0220.plusHours(2).toInstant(UTC)).build());
        //Start time = 1 Feb 2020 T 22:59:59 & End Time 2 Feb 2020 01:00:00
        infos.add(VideoPlayInfo.builder().startTime(feb0120.plusHours(22).plusMinutes(59).plusSeconds(59).toInstant(UTC)).endTime(feb0220.plusHours(1).toInstant(UTC)).build());
        //Start time = 2 Feb 2020 T 03:00:00 & End Time 2 Feb 2020 05:00:00
        infos.add(VideoPlayInfo.builder().startTime(feb0220.plusHours(3).toInstant(UTC)).endTime(feb0220.plusHours(5).toInstant(UTC)).build());
        //Start time = 2 Feb 2020 T 04:00:00 & End Time 2 Feb 2020 06:00:00
        infos.add(VideoPlayInfo.builder().startTime(feb0220.plusHours(4).toInstant(UTC)).endTime(feb0220.plusHours(6).toInstant(UTC)).build());

        return infos;
    }

    @Test
    void successGetMaximumConcurrentPlays() {
        int maximumConcurrentPlays = main.getMaximumConcurrentPlays(videoPlayInfos);
        assertEquals(3, maximumConcurrentPlays, "Method is not working");
    }
}