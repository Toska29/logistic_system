package africa.semicolon.logisticSystem.data.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class TrackingData {
    private final LocalDateTime dateTimeOfEvent = LocalDateTime.now();
    @NonNull
    private String event;
}
