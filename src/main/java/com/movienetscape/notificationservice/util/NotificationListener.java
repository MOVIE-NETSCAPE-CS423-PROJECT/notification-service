package com.movienetscape.notificationservice.util;


import com.movienetscape.notificationservice.event.PaymentProcessedEvent;
import com.movienetscape.notificationservice.event.SubscriptionMadeEvent;
import com.movienetscape.notificationservice.service.contract.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "payment-processed", groupId = "notification-service")
    public void handlePaymentProcessed(PaymentProcessedEvent event) {
        String message = "Payment of $" + event.getAmount() + " was " + event.getStatus();
        notificationService.sendNotification(event.getAccountId(), message);
    }

    @KafkaListener(topics = "subscription-upgraded", groupId = "notification-service")
    public void handleSubscriptionUpgraded(SubscriptionMadeEvent event) {
        String message = "Your subscription has been successfully activated to ";
        notificationService.sendNotification(event.getAccountId(), message);
    }
}

