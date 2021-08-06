package com.dpbinh.shopbackcrawler.service.impl;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;
import com.dpbinh.shopbackcrawler.plugin.ItemCrawler;
import com.dpbinh.shopbackcrawler.service.CrawlerService;
import com.dpbinh.shopbackcrawler.service.PluginManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService {



    @Autowired
    private PluginManagement pluginManagement;

    @Override
    public List<ExportTemplate> crawl(String url, String pluginType) {
        List<ExportTemplate> exportTemplates = new LinkedList<>();

        try {
            List<ItemCrawler> itemCrawlers = pluginManagement.getItemCrawlers(pluginType);

            for(ItemCrawler itemCrawler : itemCrawlers) {
                exportTemplates.addAll(crawlFromOneCrawler(itemCrawler, url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exportTemplates;
    }

    private List<ExportTemplate> crawlFromOneCrawler(ItemCrawler itemCrawler, String baseUrl) {
        List<ExportTemplate> result = new LinkedList<>();

        try {
            List<String> urls = new LinkedList<>();
            List<String> pageUrls = itemCrawler.extractPageUrls(baseUrl);
            for(String pageUrl : pageUrls) {
                urls.addAll(itemCrawler.extractUrls(pageUrl));
            }

            int i = 0;
            for(String url : urls) {
                List<ExportTemplate> exportTemplates = itemCrawler.execute(url);
                result.addAll(exportTemplates);
                System.out.println("Success item " + (i+= exportTemplates.size()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
