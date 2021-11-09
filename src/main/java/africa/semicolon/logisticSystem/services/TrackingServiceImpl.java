package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.TrackingData;
import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import africa.semicolon.logisticSystem.data.repositories.TrackingInformationRepository;
import africa.semicolon.logisticSystem.data.repositories.TrackingInformationRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticSystem.exceptions.InvalidPackageIdException;
import africa.semicolon.logisticSystem.utils.ModelMapper;

import java.util.Optional;

public class TrackingServiceImpl implements TrackingService{
    private PackageService packageService = new PackageServiceImpl();
    private static final TrackingInformationRepository trackingRepo = new TrackingInformationRepositoryImpl();

    @Override
    public AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest) {
        //verify package id is correct
        var aPackage = packageService.findMyPackageWithMy(addTrackingInfoRequest.getPackageId());
        if (aPackage == null) throw  new InvalidPackageIdException("Package Id Is Invalid");

        TrackingData trackingData = new TrackingData(addTrackingInfoRequest.getEvent());
        //find previous tracking info;
        Optional<TrackingInformation> optionalInfo = trackingRepo.findByPackageId(addTrackingInfoRequest.getPackageId());

        if(optionalInfo.isPresent()){
            optionalInfo.get().getTrackingData().add(trackingData);
           trackingRepo.save(optionalInfo.get());
        }
        else {
            TrackingInformation trackingInformation = new TrackingInformation();
            trackingInformation.setPackageId(addTrackingInfoRequest.getPackageId());
            trackingInformation.getTrackingData().add(trackingData);
            trackingRepo.save(trackingInformation);
        }
        //if exist add new event and save;
        //else create new tracking info, add new event and save
        //convert saved tracking info to response dto
        //return response dto

        return ModelMapper.map(trackingData, addTrackingInfoRequest);
    }

    @Override
    public TrackingInformation trackPackage(Integer packageId) {
        return trackingRepo.findByPackageId(packageId).get();
    }
}
