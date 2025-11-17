package com.yzlaboratory.api_catalog.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@DynamoDbBean
public class Catalog {

    private String model_year;
    private List<Color> colors;
    private List<Motorization> motorizations;
    private List<Rim> rims;
    private List<Extra> extras;

    public Catalog() {}

    @DynamoDbPartitionKey
    public String getModel_year() {
        return model_year;
    }

    public void setModel_year(String model_year) {
        this.model_year = model_year;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Motorization> getMotorizations() {
        return motorizations;
    }

    public void setMotorizations(List<Motorization> motorizations) {
        this.motorizations = motorizations;
    }

    public List<Rim> getRims() {
        return rims;
    }

    public void setRims(List<Rim> rims) {
        this.rims = rims;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }
}
