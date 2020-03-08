import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VideoPlayInfoTest {

    private VideoPlayInfo video;

    @Test
    void setStartTime() {
        video = VideoPlayInfo.builder().build();
        video.setStartTime(Instant.now());
        assertEquals(Instant.now(), video.getStartTime());
    }

    @Test
    void setEndTime() {
        video = VideoPlayInfo.builder().build();
        video.setEndTime(Instant.now());
        assertEquals(Instant.now(), video.getEndTime());
    }

    @Test
    void builder() {
        assertNotNull(VideoPlayInfo.builder());
    }

    @Test
    void getStartTime() {
        video = VideoPlayInfo.builder().startTime(Instant.now()).build();
        assertNotNull(video.getStartTime());
    }

    @Test
    void getEndTime() {
        video = VideoPlayInfo.builder().endTime(Instant.now()).build();
        assertNotNull(video.getEndTime());
    }
}