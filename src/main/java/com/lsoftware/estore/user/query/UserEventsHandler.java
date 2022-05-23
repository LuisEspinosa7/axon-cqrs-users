package com.lsoftware.estore.user.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.lsoftware.estore.shared.core.model.PaymentDetails;
import com.lsoftware.estore.shared.core.model.User;
import com.lsoftware.estore.shared.core.query.FetchUserPaymentDetailsQuery;

 

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
        
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("321Card")
                .cvv("321")
                .name("LUIS ESPINOSA")
                .validUntilMonth(12)
                .validUntilYear(2028)
                .build();

        User user = User.builder()
                .firstName("Luis")
                .lastName("Espinosa")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();

        return user;
    }
    
    
}
