package com.movienetscape.notificationservice.service.contract;



public interface NotificationService {


    public void sendNotification(String accountId, String message);

    void markAsSent(Long notificationId) ;

    void deleteNotification(Long notificationId);


}
