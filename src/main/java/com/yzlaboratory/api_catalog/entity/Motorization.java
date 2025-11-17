package com.yzlaboratory.api_catalog.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;
import java.math.BigInteger;

@DynamoDbBean
public class Motorization {
    private String id;
    private String name;
    private BigInteger ps;
    private BigInteger kw;
    private String transmission;
    private String drive;
    private String fuelType;
    private BigDecimal fuelConsumptionCombined;
    private String fuelConsumptionCombinedUnit;
    private BigInteger co2EmissionsCombined;
    private String co2EmissionsCombinedUnit;
    private String co2Class;
    private BigInteger maxSpeed;
    private String maxSpeedUnit;
    private BigDecimal price;

    public Motorization() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPs() {
        return ps;
    }

    public void setPs(BigInteger ps) {
        this.ps = ps;
    }

    public BigInteger getKw() {
        return kw;
    }

    public void setKw(BigInteger kw) {
        this.kw = kw;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public BigDecimal getFuelConsumptionCombined() {
        return fuelConsumptionCombined;
    }

    public void setFuelConsumptionCombined(BigDecimal fuelConsumptionCombined) {
        this.fuelConsumptionCombined = fuelConsumptionCombined;
    }

    public String getFuelConsumptionCombinedUnit() {
        return fuelConsumptionCombinedUnit;
    }

    public void setFuelConsumptionCombinedUnit(String fuelConsumptionCombinedUnit) {
        this.fuelConsumptionCombinedUnit = fuelConsumptionCombinedUnit;
    }

    public BigInteger getCo2EmissionsCombined() {
        return co2EmissionsCombined;
    }

    public void setCo2EmissionsCombined(BigInteger co2EmissionsCombined) {
        this.co2EmissionsCombined = co2EmissionsCombined;
    }

    public String getCo2EmissionsCombinedUnit() {
        return co2EmissionsCombinedUnit;
    }

    public void setCo2EmissionsCombinedUnit(String co2EmissionsCombinedUnit) {
        this.co2EmissionsCombinedUnit = co2EmissionsCombinedUnit;
    }

    public String getCo2Class() {
        return co2Class;
    }

    public void setCo2Class(String co2Class) {
        this.co2Class = co2Class;
    }

    public BigInteger getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(BigInteger maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getMaxSpeedUnit() {
        return maxSpeedUnit;
    }

    public void setMaxSpeedUnit(String maxSpeedUnit) {
        this.maxSpeedUnit = maxSpeedUnit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
