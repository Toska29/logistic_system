package africa.semicolon.logisticSystem.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AddTrackingInfoResponse {
    private Integer packageId;
    private LocalDateTime dateTime;
    private String event;
}
