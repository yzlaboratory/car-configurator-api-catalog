package com.yzlaboratory.api_catalog;

import com.yzlaboratory.api_catalog.controller.CatalogController;
import com.yzlaboratory.api_catalog.entity.Catalog;
import com.yzlaboratory.api_catalog.entity.Color;
import com.yzlaboratory.api_catalog.service.DynamoDbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CatalogController.class) // Testet nur diesen Controller
class ApiCatalogTests {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private DynamoDbService dynamoDbService;

	@Test
	void testGetPartsJson_Success() throws Exception {
		// Arrange
		Catalog testCatalog = new Catalog();
		testCatalog.setModelId("Astral X_2025");
		Color testColor = new Color();
		testColor.setId("C-1");
		testColor.setName("Weiss");
		testColor.setHex("#FFFFFF");
		testColor.setPrice(BigDecimal.valueOf(0));
		testCatalog.setColors(List.of(testColor));
		String expectedJson = "{\"modelId\":\"Astral X_2025\",\"colors\":[{\"id\":\"C-1\",\"name\":\"Weiss\",\"price\":0,\"hex\":\"#FFFFFF\"}],\"motorizations\":null,\"rims\":null,\"extras\":null}";

		when(dynamoDbService.getItemsByModel("Astral X_2025")).thenReturn(testCatalog);

		// Act & Assert
		mockMvc.perform(get("/catalog/items?modelId=Astral X_2025"))
				.andExpect(status().isOk()) // Erwarten wir HTTP 200 OK
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)) // Prüfen des Content-Typs
				.andExpect(content().string(expectedJson)); // Prüfen des genauen JSON-Strings
	}

	@Test
	void testGetPartsJson_Empty() throws Exception {
		// Arrange
		String expectedJson = "{\"modelId\":null,\"colors\":null,\"motorizations\":null,\"rims\":null,\"extras\":null}";
		when(dynamoDbService.getItemsByModel("Astral X_2025")).thenReturn(new Catalog());

		// Act & Assert
		mockMvc.perform(get("/catalog/items?modelId=Astral X_2025"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(content().string(expectedJson)); // Erwarten einen leeren JSON-Array-String
	}
}