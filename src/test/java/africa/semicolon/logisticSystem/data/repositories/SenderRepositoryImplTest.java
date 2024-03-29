package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Sender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderRepositoryImplTest {
    SenderRepository senderRepository;

    @BeforeEach
    void setUp() {
        senderRepository = new SenderRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@gmail.com");
        sender.setPhoneNumber("08144410100");

        Sender savedSender = senderRepository.save(sender);
        assertEquals(sender, savedSender);
        assertEquals(1, senderRepository.findAll().size());
    }

    public Sender savedSender(){
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("jerry@gmail.com");
        sender.setPhoneNumber("08144410100");

        return  senderRepository.save(sender);
    }

    @Test
    void findSenderByEmail() {
        Sender savedSender = savedSender();
        assertEquals(savedSender, senderRepository.findSenderByEmail(savedSender.getEmailAddress()).get());
    }

    @Test
    void delete() {
        Sender savedSender = savedSender();
        senderRepository.delete(savedSender.getEmailAddress());
        assertEquals(0, senderRepository.findAll().size());
    }

    @Test
    void testDelete() {
        Sender savedSender = savedSender();
        senderRepository.delete(savedSender);
        assertEquals(0, senderRepository.findAll().size());
    }
}