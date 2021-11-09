package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exceptions.DuplicateUserException;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderServiceImplTest {

    SenderService senderService;
    @BeforeEach
    void setUp() {
        senderService = new SenderServiceImpl();
    }
    @AfterEach
    void tearDown(){
        senderService.deleteAllSenders();
    }

    @Test
    void registerSender() {
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Jerry");
        registerSenderRequest.setSenderEmail("jerry@gmail.com");
        registerSenderRequest.setPhoneNumber("0901234567");
        RegisterSenderResponse response = senderService.registerSender(registerSenderRequest);

        assertEquals(response.getSenderEmail(), registerSenderRequest.getSenderEmail());
        assertEquals(1, senderService.getSenders().size());
    }

    public RegisterSenderResponse registerSenderTestHelper(){
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Jerry");
        registerSenderRequest.setSenderEmail("jerry@gmail.com");
        registerSenderRequest.setPhoneNumber("0901234567");
        RegisterSenderResponse response = senderService.registerSender(registerSenderRequest);
        return  response;
    }
    @Test
    void duplicateEmail_throwsException(){
        registerSenderTestHelper();
        assertThrows(DuplicateUserException.class, () -> registerSenderTestHelper());
    }

    @Test
    void nonExistingSenderEmail_throwsException(){
        registerSenderTestHelper();
        assertThrows(UserDoesNotExistException.class, () -> senderService.findSenderByEmail("toska@gmail.com"));
    }
}