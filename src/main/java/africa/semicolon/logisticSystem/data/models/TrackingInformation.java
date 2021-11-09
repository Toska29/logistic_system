package africa.semicolon.logisticSystem.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TrackingInformation {
    private Integer packageId;
    private List<TrackingData> trackingData = new ArrayList<>();
}
