package com.movienetscape.notificationservice.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionMadeEvent {
    private String accountId;
    private boolean isSubscribed;
}
