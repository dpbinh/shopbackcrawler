package com.dpbinh.shopbackcrawler.controller;

import java.util.List;

public interface CrawlerController {
    void crawl(String path, String pluginType, List<String> exportTypes) throws Exception;
}
