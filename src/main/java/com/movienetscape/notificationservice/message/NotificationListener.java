package com.movienetscape.notificationservice.message;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movienetscape.notificationservice.message.event.PasswordResetEvent;
import com.movienetscape.notificationservice.message.event.UserRegisteredEvent;
import com.movienetscape.notificationservice.service.contract.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationListener {

    private final EmailService emailService;

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "user-registered-topic", groupId = "notification-service")
    public void handleUserRegisteredEvent(String eventJson) {
        try {
            UserRegisteredEvent event = objectMapper.readValue(eventJson, UserRegisteredEvent.class);
            log.info("Received UserRegisteredEvent for email: {}", event.getEmailAddress());
            emailService.sendVerificationEmail(event.getToken(), event.getEmailAddress());
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize UserRegisteredEvent: {}", eventJson, e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to send mail", e);
        }
    }


    @KafkaListener(topics = "password-reset-topic", groupId = "notification-service")
    public void handleUserPasswordChangeEvent(String eventJson) {
        try {
            PasswordResetEvent event = objectMapper.readValue(eventJson,  PasswordResetEvent.class);
            log.info("Received PasswordResetEvent for email: {}", event.getEmailAddress());
            emailService.sendVerificationEmail(event.getToken(), event.getEmailAddress());
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize PasswordResetEvent: {}", eventJson, e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to send mail", e);
        }
    }




}

