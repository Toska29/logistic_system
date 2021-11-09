package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import africa.semicolon.logisticSystem.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticSystem.services.TrackingService;
import africa.semicolon.logisticSystem.services.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageTrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PatchMapping("/api/trackingInfo")
    public AddTrackingInfoResponse AddTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackingInfo{id}")
    public TrackingInformation getTrackingInfo(@PathVariable("id") Integer trackingId){
        return trackingService.trackPackage(trackingId);
    }
}
