package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;

import java.util.List;

public interface SenderService {
    RegisterSenderResponse registerSender(RegisterSenderRequest resgisterSenderRequest);

    List<Sender> getSenders();

    void deleteAllSenders();

    Sender findSenderByEmail(String email);
}
