package africa.semicolon.logisticSystem.utils;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import lombok.Data;

@Data
public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setSenderPhone(addPackageRequest.getSenderPhone());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setReceiverName(addPackageRequest.getReceiverName());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage){
        AddPackageResponse response = new AddPackageResponse();
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setPackageName(savedPackage.getName());
        response.setTrackingNumber(savedPackage.getId());
        return response;
    }
}
