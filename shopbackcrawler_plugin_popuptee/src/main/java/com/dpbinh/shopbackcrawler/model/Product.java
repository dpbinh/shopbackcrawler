package com.dpbinh.shopbackcrawler.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

    @JsonProperty("variants")
    private List<Variant> variants;

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("bodyHtml")
    private String bodyHtml;

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("productType")
    private String productType;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("handle")
    private String handle;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("templateSuffix")
    private String templateSuffix;

    @JsonProperty("publishedScope")
    private String publishedScope;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("options")
    private List options;

    @JsonProperty("images")
    private List<Image> images;

    @JsonProperty("image")
    private Image image;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyHtml() {
        return this.bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getHandle() {
        return this.handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTemplateSuffix() {
        return this.templateSuffix;
    }

    public void setTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
    }

    public String getPublishedScope() {
        return this.publishedScope;
    }

    public void setPublishedScope(String publishedScope) {
        this.publishedScope = publishedScope;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List getOptions() {
        return this.options;
    }

    public void setOptions(List options) {
        this.options = options;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Variant> getVariants() {
        return this.variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}
