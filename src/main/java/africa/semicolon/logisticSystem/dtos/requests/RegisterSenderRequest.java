package africa.semicolon.logisticSystem.dtos.requests;

import lombok.Data;

@Data
public class RegisterSenderRequest {
    private String senderName;
    private String phoneNumber;
    private String senderEmail;
}
