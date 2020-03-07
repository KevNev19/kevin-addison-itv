import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
public class VideoPlayInfo {

    @Getter
    @Setter
    private Instant startTime;
    @Getter
    @Setter
    private Instant endTime;
}
