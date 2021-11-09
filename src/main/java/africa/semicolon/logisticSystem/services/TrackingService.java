package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import africa.semicolon.logisticSystem.data.repositories.TrackingInformationRepository;
import africa.semicolon.logisticSystem.data.repositories.TrackingInformationRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddTrackingInfoResponse;

public interface TrackingService {
    AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest);

    TrackingInformation trackPackage(Integer packageId);
}
