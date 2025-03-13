package com.movienetscape.notificationservice.service.impl;


import com.movienetscape.notificationservice.model.Notification;
import com.movienetscape.notificationservice.repository.NotificationRepository;
import com.movienetscape.notificationservice.service.contract.NotificationService;
import com.movienetscape.notificationservice.util.NotificationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(String accountId, String message) {
        Notification notification = new Notification();
        notification.setAccountId(accountId);
        notification.setMessage(message);
        notification.setStatus(NotificationStatus.PENDING);
        notification.setCreatedAt(LocalDateTime.now());

        notificationRepository.save(notification);
    }

    public void markAsSent(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setStatus(NotificationStatus.SENT);
        notificationRepository.save(notification);
    }
}
