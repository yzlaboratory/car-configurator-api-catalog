package com.yzlaboratory.api_catalog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Arrays;
import java.util.Map;

@Service
public class DynamoDbService {

    private final DynamoDbClient dynamoDbClient;
    private final String tableName;

    // Read the environment variables
    public DynamoDbService(DynamoDbClient dynamoDbClient,
            @Value("${DYNAMODB_TABLE_NAME}") String tableName
    ) {
        this.tableName = tableName;

        this.dynamoDbClient = dynamoDbClient;
    }

    public String getColorsByModel(String modelId) {
        Map<String, AttributeValue> keyToGet = Map.of(
                "model_year", AttributeValue.builder().s(modelId).build()
        );
        GetItemRequest request = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(this.tableName)
                .build();
        System.out.println(this.tableName);
        System.out.println("Get Item Request: " + request);
        // This is where the call to DynamoDB happens
        Map<String, AttributeValue> returnedItem = dynamoDbClient.getItem(request).item();
        System.out.println(returnedItem.size());
        System.out.println(returnedItem.get("colors").s());
        System.out.println(returnedItem.get("colors").ss());
        System.out.println(Arrays.toString(returnedItem.keySet().toArray()));
        System.out.println(Arrays.toString(returnedItem.values().toArray()));
        return returnedItem.get("colors").s();
    }
}