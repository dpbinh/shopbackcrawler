package com.dpbinh.shopbackcrawler.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Image implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("position")
    private String position;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("src")
    private String src;

    @JsonProperty("variant_ids")
    private List variantIds;

    @JsonProperty("alt")
    private String alt;

    @JsonProperty("width")
    private Integer width;

    @JsonProperty("height")
    private Integer height;

    public String getId() {
        return this.id;
    }

    public List getVariantIds() {
        return this.variantIds;
    }

    public void setVariantIds(List variantIds) {
        this.variantIds = variantIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}