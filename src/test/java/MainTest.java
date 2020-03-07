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
        LocalDateTime time = LocalDateTime.of(2020, 2, 1, 0, 0);

        List<VideoPlayInfo> infos = new ArrayList<>();

        infos.add(VideoPlayInfo.builder().startTime(time.toInstant(UTC)).endTime(time.plusHours(2).toInstant(UTC)).build());
        infos.add(VideoPlayInfo.builder().startTime(time.toInstant(UTC)).endTime(time.plusHours(3).toInstant(UTC)).build());
        infos.add(VideoPlayInfo.builder().startTime(time.plusHours(2).toInstant(UTC)).endTime(time.plusHours(4).toInstant(UTC)).build());
        infos.add(VideoPlayInfo.builder().startTime(time.plusHours(2).toInstant(UTC)).endTime(time.plusHours(3).toInstant(UTC)).build());
        infos.add(VideoPlayInfo.builder().startTime(time.plusHours(3).toInstant(UTC)).endTime(time.plusHours(5).toInstant(UTC)).build());
        infos.add(VideoPlayInfo.builder().startTime(time.plusHours(4).toInstant(UTC)).endTime(time.plusHours(6).toInstant(UTC)).build());

        return infos;
    }

    @Test
    void successGetMaximumConcurrentPlays() {
        int maximumConcurrentPlays = main.getMaximumConcurrentPlays(videoPlayInfos);

        System.out.println(videoPlayInfos.size());
        System.out.println(maximumConcurrentPlays);

        assertEquals(2, maximumConcurrentPlays, "Method is not working");

    }
}