package com.dpbinh.shopbackcrawler.plugin;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;

import java.io.IOException;
import java.util.List;

public interface ItemCrawler {
    List<String> getSupportTypes();

    List<ExportTemplate> execute(String url) throws IOException;

    List<String> extractUrls(String pageUrl) throws Exception;

    List<String> extractPageUrls(String pageUrl) throws Exception;
}
