package com.yzlaboratory.api_catalog.service;

import com.yzlaboratory.api_catalog.entity.Catalog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Service
public class DynamoDbService {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private final String tableName;

    // Read the environment variables
    public DynamoDbService(DynamoDbEnhancedClient dynamoDbEnhancedClient,
            @Value("${DYNAMODB_TABLE_NAME}") String tableName
    ) {
        this.tableName = tableName;
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    public Catalog getColorsByModel(String modelId) {
        DynamoDbTable<Catalog> mainTable = dynamoDbEnhancedClient.table(
                this.tableName,
                TableSchema.fromBean(Catalog.class)
        );
        return mainTable.getItem(r -> r.key(k -> k.partitionValue(modelId)));
    }
}