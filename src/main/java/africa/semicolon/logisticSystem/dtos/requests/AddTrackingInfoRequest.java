package africa.semicolon.logisticSystem.dtos.requests;

import lombok.Data;

@Data
public class AddTrackingInfoRequest {
    private Integer packageId;
    private String event;
}
