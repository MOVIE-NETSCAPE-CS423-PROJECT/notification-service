package com.movienetscape.notificationservice.repository;




import com.movienetscape.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByAccountId(String accountId);
}
