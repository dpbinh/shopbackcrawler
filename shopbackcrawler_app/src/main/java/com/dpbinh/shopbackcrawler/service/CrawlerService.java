package com.dpbinh.shopbackcrawler.service;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;

import java.util.List;

public interface CrawlerService {
    List<ExportTemplate> crawl(String url, String pluginType);
}
