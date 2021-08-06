package com.dpbinh.shopbackcrawler.model;

import java.io.Serializable;

public class ExportTemplate implements Serializable {

    private String handle;
    private String title;
    private String bodyHTML;
    private String vendor = "";
    private String type = "Apparel";
    private String tags;
    private String published = "TRUE";
    private String option1Name = "Size";
    private String option1Value;
    private String option2Name = "Color";
    private String option2Value;
    private String option3Name = "Pattern";
    private String option3Value;
    private String variantSKU;
    private String variantGrams = "0";
    private String variantInventoryTracker;
    private String variantInventoryQty = "1";
    private String variantInventoryPolicy = "deny";
    private String variantFulfillmentService = "manual";
    private String variantPrice;
    private String variantCompareAtPrice;
    private String variantRequiresShipping = "TRUE";

    private String variantTaxable = "TRUE";

    private String variantBarcode;

    private String imagesrc;

    private String imageAltText;

    private String giftCard = "FALSE";

    private String googleShoppingMPN;

    private String googleShoppingAgeGroup = "Adult";

    private String googleShoppingGender = "Unisex";

    private String googleShoppingGoogleProductCategory = "Apparel & Accessories > Clothing > Shirts & Tops";

    private String seoTitle;

    private String seoDescription;

    private String googleShoppingAdWordsGrouping = "T-Shirt";

    private String googleShoppingAdWordsLabels = "T-Shirt";

    private String googleShoppingCondition = "New";

    private String googleShoppingCustomProduct = "TRUE";

    private String googleShoppingCustomLabel0;

    private String googleShoppingCustomLabel1;

    private String googleShoppingCustomLabel2;

    private String googleShoppingCustomLabel3;

    private String googleShoppingCustomLabel4;

    private String variantImage;

    private String variantWeightUnit = "lb";

    private String variantTaxCode;

    private String groupId;

    public String getHandle() {
        return this.handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyHTML() {
        return this.bodyHTML;
    }

    public void setBodyHTML(String bodyHTML) {
        this.bodyHTML = bodyHTML;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPublished() {
        return this.published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getOption1Name() {
        return this.option1Name;
    }

    public void setOption1Name(String option1Name) {
        this.option1Name = option1Name;
    }

    public String getOption1Value() {
        return this.option1Value;
    }

    public void setOption1Value(String option1Value) {
        this.option1Value = option1Value;
    }

    public String getOption2Name() {
        return this.option2Name;
    }

    public void setOption2Name(String option2Name) {
        this.option2Name = option2Name;
    }

    public String getOption2Value() {
        return this.option2Value;
    }

    public void setOption2Value(String option2Value) {
        this.option2Value = option2Value;
    }

    public String getOption3Name() {
        return this.option3Name;
    }

    public void setOption3Name(String option3Name) {
        this.option3Name = option3Name;
    }

    public String getOption3Value() {
        return this.option3Value;
    }

    public void setOption3Value(String option3Value) {
        this.option3Value = option3Value;
    }

    public String getVariantSKU() {
        return this.variantSKU;
    }

    public void setVariantSKU(String variantSKU) {
        this.variantSKU = variantSKU;
    }

    public String getVariantGrams() {
        return this.variantGrams;
    }

    public void setVariantGrams(String variantGrams) {
        this.variantGrams = variantGrams;
    }

    public String getVariantInventoryTracker() {
        return this.variantInventoryTracker;
    }

    public void setVariantInventoryTracker(String variantInventoryTracker) {
        this.variantInventoryTracker = variantInventoryTracker;
    }

    public String getVariantInventoryQty() {
        return this.variantInventoryQty;
    }

    public void setVariantInventoryQty(String variantInventoryQty) {
        this.variantInventoryQty = variantInventoryQty;
    }

    public String getVariantInventoryPolicy() {
        return this.variantInventoryPolicy;
    }

    public void setVariantInventoryPolicy(String variantInventoryPolicy) {
        this.variantInventoryPolicy = variantInventoryPolicy;
    }

    public String getVariantFulfillmentService() {
        return this.variantFulfillmentService;
    }

    public void setVariantFulfillmentService(String variantFulfillmentService) {
        this.variantFulfillmentService = variantFulfillmentService;
    }

    public String getVariantPrice() {
        return this.variantPrice;
    }

    public void setVariantPrice(String variantPrice) {
        this.variantPrice = variantPrice;
    }

    public String getVariantCompareAtPrice() {
        return this.variantCompareAtPrice;
    }

    public void setVariantCompareAtPrice(String variantCompareAtPrice) {
        this.variantCompareAtPrice = variantCompareAtPrice;
    }

    public String getVariantRequiresShipping() {
        return this.variantRequiresShipping;
    }

    public void setVariantRequiresShipping(String variantRequiresShipping) {
        this.variantRequiresShipping = variantRequiresShipping;
    }

    public String getVariantTaxable() {
        return this.variantTaxable;
    }

    public void setVariantTaxable(String variantTaxable) {
        this.variantTaxable = variantTaxable;
    }

    public String getVariantBarcode() {
        return this.variantBarcode;
    }

    public void setVariantBarcode(String variantBarcode) {
        this.variantBarcode = variantBarcode;
    }

    public String getImagesrc() {
        return this.imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public String getImageAltText() {
        return this.imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }

    public String getGiftCard() {
        return this.giftCard;
    }

    public void setGiftCard(String giftCard) {
        this.giftCard = giftCard;
    }

    public String getGoogleShoppingMPN() {
        return this.googleShoppingMPN;
    }

    public void setGoogleShoppingMPN(String googleShoppingMPN) {
        this.googleShoppingMPN = googleShoppingMPN;
    }

    public String getGoogleShoppingAgeGroup() {
        return this.googleShoppingAgeGroup;
    }

    public void setGoogleShoppingAgeGroup(String googleShoppingAgeGroup) {
        this.googleShoppingAgeGroup = googleShoppingAgeGroup;
    }

    public String getGoogleShoppingGender() {
        return this.googleShoppingGender;
    }

    public void setGoogleShoppingGender(String googleShoppingGender) {
        this.googleShoppingGender = googleShoppingGender;
    }

    public String getGoogleShoppingGoogleProductCategory() {
        return this.googleShoppingGoogleProductCategory;
    }

    public void setGoogleShoppingGoogleProductCategory(String googleShoppingGoogleProductCategory) {
        this.googleShoppingGoogleProductCategory = googleShoppingGoogleProductCategory;
    }

    public String getSeoTitle() {
        return this.seoTitle;
    }

    public void setSeoTitle(String sEOTitle) {
        this.seoTitle = sEOTitle;
    }

    public String getSeoDescription() {
        return this.seoDescription;
    }

    public void setSeoDescription(String sEODescription) {
        this.seoDescription = sEODescription;
    }

    public String getGoogleShoppingAdWordsGrouping() {
        return this.googleShoppingAdWordsGrouping;
    }

    public void setGoogleShoppingAdWordsGrouping(String googleShoppingAdWordsGrouping) {
        this.googleShoppingAdWordsGrouping = googleShoppingAdWordsGrouping;
    }

    public String getGoogleShoppingAdWordsLabels() {
        return this.googleShoppingAdWordsLabels;
    }

    public void setGoogleShoppingAdWordsLabels(String googleShoppingAdWordsLabels) {
        this.googleShoppingAdWordsLabels = googleShoppingAdWordsLabels;
    }

    public String getGoogleShoppingCondition() {
        return this.googleShoppingCondition;
    }

    public void setGoogleShoppingCondition(String googleShoppingCondition) {
        this.googleShoppingCondition = googleShoppingCondition;
    }

    public String getGoogleShoppingCustomProduct() {
        return this.googleShoppingCustomProduct;
    }

    public void setGoogleShoppingCustomProduct(String googleShoppingCustomProduct) {
        this.googleShoppingCustomProduct = googleShoppingCustomProduct;
    }

    public String getGoogleShoppingCustomLabel0() {
        return this.googleShoppingCustomLabel0;
    }

    public void setGoogleShoppingCustomLabel0(String googleShoppingCustomLabel0) {
        this.googleShoppingCustomLabel0 = googleShoppingCustomLabel0;
    }

    public String getGoogleShoppingCustomLabel1() {
        return this.googleShoppingCustomLabel1;
    }

    public void setGoogleShoppingCustomLabel1(String googleShoppingCustomLabel1) {
        this.googleShoppingCustomLabel1 = googleShoppingCustomLabel1;
    }

    public String getGoogleShoppingCustomLabel2() {
        return this.googleShoppingCustomLabel2;
    }

    public void setGoogleShoppingCustomLabel2(String googleShoppingCustomLabel2) {
        this.googleShoppingCustomLabel2 = googleShoppingCustomLabel2;
    }

    public String getGoogleShoppingCustomLabel3() {
        return this.googleShoppingCustomLabel3;
    }

    public void setGoogleShoppingCustomLabel3(String googleShoppingCustomLabel3) {
        this.googleShoppingCustomLabel3 = googleShoppingCustomLabel3;
    }

    public String getGoogleShoppingCustomLabel4() {
        return this.googleShoppingCustomLabel4;
    }

    public void setGoogleShoppingCustomLabel4(String googleShoppingCustomLabel4) {
        this.googleShoppingCustomLabel4 = googleShoppingCustomLabel4;
    }

    public String getVariantImage() {
        return this.variantImage;
    }

    public void setVariantImage(String variantImage) {
        this.variantImage = variantImage;
    }

    public String getVariantWeightUnit() {
        return this.variantWeightUnit;
    }

    public void setVariantWeightUnit(String variantWeightUnit) {
        this.variantWeightUnit = variantWeightUnit;
    }

    public String getVariantTaxCode() {
        return this.variantTaxCode;
    }

    public void setVariantTaxCode(String variantTaxCode) {
        this.variantTaxCode = variantTaxCode;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}