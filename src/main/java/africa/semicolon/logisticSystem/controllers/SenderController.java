package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.services.SenderService;
import africa.semicolon.logisticSystem.services.SenderServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class SenderController {
    private SenderService senderService = new SenderServiceImpl();

    @PostMapping("/api/sender")
    public RegisterSenderResponse registerSender(@RequestBody RegisterSenderRequest registerSenderRequest){
        return senderService.registerSender(registerSenderRequest);
    }

    @GetMapping("/api/v1/sender/{email}")
    public Sender getSenderById(@PathVariable String email){
        return senderService.findSenderByEmail(email);
    }
}
