package com.yzlaboratory.api_catalog;

import com.yzlaboratory.api_catalog.service.DynamoDbService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ApiCatalogTests {

	@MockitoBean
	private DynamoDbService dynamoDbService;


	@Test
	void contextLoads() {
	}

}
