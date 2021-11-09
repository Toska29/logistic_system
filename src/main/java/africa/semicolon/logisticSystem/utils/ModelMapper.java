package africa.semicolon.logisticSystem.utils;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import lombok.Data;

@Data
public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
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

    public static Sender map(RegisterSenderRequest registerSenderRequest){
        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());
        return  sender;
    }

    public static RegisterSenderResponse map(Sender savedSender){
        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(savedSender.getEmailAddress());
        return response;
    }
}
