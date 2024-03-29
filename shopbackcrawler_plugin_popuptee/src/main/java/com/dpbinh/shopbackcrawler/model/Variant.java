package com.dpbinh.shopbackcrawler.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Variant implements Serializable {
    @JsonProperty("id")
    public String id;

    @JsonProperty("product_id")
    public String product_id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("price")
    public String price;

    @JsonProperty("sku")
    public String sku;

    @JsonProperty("position")
    public String position;

    @JsonProperty("grams")
    public String grams;

    @JsonProperty("inventory_policy")
    public String inventory_policy;

    @JsonProperty("compare_at_price")
    public String compare_at_price;

    @JsonProperty("fulfillment_service")
    public String fulfillment_service;

    @JsonProperty("inventory_management")
    public String inventory_management;

    @JsonProperty("option1")
    public String option1;

    @JsonProperty("option2")
    public String option2;

    @JsonProperty("option3")
    public String option3;

    @JsonProperty("created_at")
    public String created_at;

    @JsonProperty("updated_at")
    public String updated_at;

    @JsonProperty("taxable")
    public String taxable;

    @JsonProperty("barcode")
    public String barcode;

    @JsonProperty("image_id")
    public String image_id;

    @JsonProperty("inventory_quantity")
    public String inventory_quantity;

    @JsonProperty("weight")
    public String weight;

    @JsonProperty("weight_unit")
    public String weight_unit;

    @JsonProperty("old_inventory_quantity")
    public String old_inventory_quantity;

    @JsonProperty("requires_shipping")
    public String requires_shipping;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGrams() {
        return this.grams;
    }

    public void setGrams(String grams) {
        this.grams = grams;
    }

    public String getInventory_policy() {
        return this.inventory_policy;
    }

    public void setInventory_policy(String inventory_policy) {
        this.inventory_policy = inventory_policy;
    }

    public String getCompare_at_price() {
        return this.compare_at_price;
    }

    public void setCompare_at_price(String compare_at_price) {
        this.compare_at_price = compare_at_price;
    }

    public String getFulfillment_service() {
        return this.fulfillment_service;
    }

    public void setFulfillment_service(String fulfillment_service) {
        this.fulfillment_service = fulfillment_service;
    }

    public String getInventory_management() {
        return this.inventory_management;
    }

    public void setInventory_management(String inventory_management) {
        this.inventory_management = inventory_management;
    }

    public String getOption1() {
        return this.option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return this.option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return this.option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getTaxable() {
        return this.taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage_id() {
        return this.image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getInventory_quantity() {
        return this.inventory_quantity;
    }

    public void setInventory_quantity(String inventory_quantity) {
        this.inventory_quantity = inventory_quantity;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight_unit() {
        return this.weight_unit;
    }

    public void setWeight_unit(String weight_unit) {
        this.weight_unit = weight_unit;
    }

    public String getOld_inventory_quantity() {
        return this.old_inventory_quantity;
    }

    public void setOld_inventory_quantity(String old_inventory_quantity) {
        this.old_inventory_quantity = old_inventory_quantity;
    }

    public String getRequires_shipping() {
        return this.requires_shipping;
    }

    public void setRequires_shipping(String requires_shipping) {
        this.requires_shipping = requires_shipping;
    }
}