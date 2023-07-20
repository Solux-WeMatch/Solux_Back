package WeMatch.wematch.domain.group.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamEventsResponseDto {
    private String eventStartAt;
    private String eventEndAt;
    private long eventId;
    private long memberId;
}
