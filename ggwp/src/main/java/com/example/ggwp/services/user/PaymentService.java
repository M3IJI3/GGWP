package com.example.ggwp.services.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService implements PaymentServiceInterface {

    @Value("${openAPIHubApiKey}") // Add the API key as a property in your application.properties or application.yml file
    private String apiKey;

    public Boolean validateCreditCard(String cardNumber) {
        String url = "https://trial-api-credit-card-validator-4sfb.gw.openapihub.com/credit-card/number-check";

        // Create the request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("number", cardNumber);
        requestBody.put("luhnValidateUnionPay", true);
        requestBody.put("maxLength", 16);

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-OpenAPIHub-Key", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Create the RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Make the POST API call and get the response
        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        // Get the response body
        Map<String, Object> responseBody = responseEntity.getBody();

        // Handle the API response
        if (responseBody != null) {
            Boolean isValid = (Boolean) responseBody.get("isValid");
            if (isValid != null && isValid) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}