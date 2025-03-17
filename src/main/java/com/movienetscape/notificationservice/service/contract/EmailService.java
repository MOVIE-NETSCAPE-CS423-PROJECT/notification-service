package com.movienetscape.notificationservice.service.contract;


public interface EmailService {

    void sendVerificationEmail(String url, String toEmailAddress);
}
