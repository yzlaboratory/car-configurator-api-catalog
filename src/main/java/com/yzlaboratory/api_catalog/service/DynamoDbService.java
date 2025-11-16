package com.yzlaboratory.api_catalog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;

@Service
public class DynamoDbService {

    private final DynamoDbClient dynamoDbClient;
    private final String tableName;

    // Read the environment variables
    public DynamoDbService(
            @Value("${AWS_REGION}") String region,
            @Value("${DYNAMODB_TABLE_NAME}") String tableName
    ) {
        this.tableName = tableName;

        // The client is created and automatically
        // uses the credentials from the ECS Task Role
        this.dynamoDbClient = DynamoDbClient.builder()
                .region(Region.of(region))
                .build();
    }

    // Example method to get an item
    public String getItems() {
        Map<String, AttributeValue> keyToGet = Map.of(
                "id", AttributeValue.builder().s("parts").build()
        );
        GetItemRequest request = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(this.tableName)
                .build();

        // This is where the call to DynamoDB happens
        Map<String, AttributeValue> returnedItem = dynamoDbClient.getItem(request).item();

        if (returnedItem != null) {
            return returnedItem.get("someAttribute").s();
        }
        return null;
    }
}