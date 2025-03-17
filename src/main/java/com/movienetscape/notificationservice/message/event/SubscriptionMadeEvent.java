package com.movienetscape.notificationservice.message.event;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionMadeEvent {
    private String accountId;
    private boolean isSubscribed;
    private LocalDate subscriptionStartDate;
    private LocalDate subscriptionEndDate;
}
