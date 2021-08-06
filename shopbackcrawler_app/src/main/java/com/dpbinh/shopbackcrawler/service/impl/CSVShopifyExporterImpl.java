package com.dpbinh.shopbackcrawler.service.impl;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CSVShopifyExporterImpl extends AbstractCSVExporterImpl<ExportTemplate> {

    @Override
    protected String getFileName() {
        Date date = new Date();
        return  "SHOPIFY" + date.getDay() + "_" + date.getMonth() + "_" + date.getYear() + "_" +
                date.getHours() + "_" + date.getMinutes() + ".csv";
    }

    @Override
    protected List<String> getRecords(ExportTemplate exportTemplate) {
        List<String> record = new ArrayList<>();
        record.add(exportTemplate.getHandle());
        record.add(exportTemplate.getTitle());
        record.add(exportTemplate.getBodyHTML());
        record.add("CustomCat");
        record.add(exportTemplate.getType());
        record.add(exportTemplate.getTags());
        record.add(exportTemplate.getPublished());
        record.add(exportTemplate.getOption1Name());
        record.add(exportTemplate.getOption1Value());
        record.add(exportTemplate.getOption2Name());
        record.add(exportTemplate.getOption2Value());
        record.add(exportTemplate.getOption3Name());
        record.add(exportTemplate.getOption3Value());
        record.add(exportTemplate.getVariantSKU());
        record.add(exportTemplate.getVariantGrams());
        record.add(exportTemplate.getVariantInventoryTracker());
        record.add(exportTemplate.getVariantInventoryQty());
        record.add(exportTemplate.getVariantInventoryPolicy());
        record.add(exportTemplate.getVariantFulfillmentService());
        record.add(exportTemplate.getVariantPrice());
        record.add(exportTemplate.getVariantCompareAtPrice());
        record.add(exportTemplate.getVariantRequiresShipping());
        record.add(exportTemplate.getVariantTaxable());
        record.add(exportTemplate.getVariantBarcode());
        record.add(exportTemplate.getImagesrc());
        record.add(exportTemplate.getImageAltText());
        record.add(exportTemplate.getGiftCard());
        record.add(exportTemplate.getGoogleShoppingMPN());
        record.add(exportTemplate.getGoogleShoppingAgeGroup());
        record.add(exportTemplate.getGoogleShoppingGender());
        record.add(exportTemplate.getGoogleShoppingGoogleProductCategory());
        record.add(exportTemplate.getSeoTitle());
        record.add(exportTemplate.getSeoDescription());
        record.add(exportTemplate.getGoogleShoppingAdWordsGrouping());
        record.add(exportTemplate.getGoogleShoppingAdWordsLabels());
        record.add(exportTemplate.getGoogleShoppingCondition());
        record.add(exportTemplate.getGoogleShoppingCustomProduct());
        record.add(exportTemplate.getGoogleShoppingCustomLabel0());
        record.add(exportTemplate.getGoogleShoppingCustomLabel1());
        record.add(exportTemplate.getGoogleShoppingCustomLabel2());
        record.add(exportTemplate.getGoogleShoppingCustomLabel3());
        record.add(exportTemplate.getGoogleShoppingCustomLabel4());
        record.add(exportTemplate.getVariantImage());
        record.add(exportTemplate.getVariantWeightUnit());
        record.add(exportTemplate.getVariantTaxCode());
        return record;
    }

    @Override
    protected List<String> getHeader() {
        return Arrays.asList(new String[] {
                "Handle", "Title", "Body (HTML)", "Vendor", "Type", "Tags",
                "Published", "Option1 Name", "Option1 Value", "Option2 Name",
                "Option2 Value", "Option3 Name",
                "Option3 Value", "Variant SKU", "Variant Grams", "Variant Inventory Tracker",
                "Variant Inventory Qty", "Variant Inventory Policy", "Variant Fulfillment Service", "Variant price",
                "Variant Compare At Price", "Variant Requires Shipping", "Variant Taxable", "Variant Barcode",
                "Image src", "Image Alt Text", "Gift Card", "Google Shopping / MPN", "Google Shopping / Age Group",
                "Google Shopping / Gender",
                "Google Shopping / Google Product Category", "SEO Title",
                "SEO Description", "Google Shopping / AdWords Grouping", "Google Shopping / AdWords Labels",
                "Google Shopping / Condition", "\tGoogle Shopping / Custom Product",
                "Google Shopping / Custom Label 0", "Google Shopping / Custom Label 1",
                "Google Shopping / Custom Label 2",
                "Google Shopping / Custom Label 3",
                "Google Shopping / Custom Label 4", "Variant Image", "Variant Weight Unit", "Variant Tax Code" });
    }
}
