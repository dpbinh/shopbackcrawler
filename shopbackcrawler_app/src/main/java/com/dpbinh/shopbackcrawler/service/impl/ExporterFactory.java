package com.dpbinh.shopbackcrawler.service.impl;

import com.dpbinh.shopbackcrawler.service.Exporter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExporterFactory {

    private Map<ExporterType, Exporter> exporterMap = new HashMap<>();

    public ExporterFactory() {
        exporterMap.put(ExporterType.SHOPIFY, new CSVShopifyExporterImpl());
        exporterMap.put(ExporterType.WORDPRESS, new CSVWordpressExporterImpl());
    }

    public Exporter getExporter(ExporterType exporterType) {
        return exporterMap.get(exporterType);
    }
}
