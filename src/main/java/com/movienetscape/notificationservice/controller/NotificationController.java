package com.movienetscape.notificationservice.controller;


import com.movienetscape.notificationservice.service.contract.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/{accountId}")
    public void sendNotification(@PathVariable String accountId, @RequestBody String message) {
        notificationService.sendNotification(accountId, message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok("Notification deleted");
    }










}

