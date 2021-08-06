package com.dpbinh.shopbackcrawler.controller;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;
import com.dpbinh.shopbackcrawler.service.*;
import com.dpbinh.shopbackcrawler.service.impl.ExporterFactory;
import com.dpbinh.shopbackcrawler.service.impl.ExporterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerControllerImpl implements CrawlerController {
    @Value("${app.com.dpbinh.shopbackcrawler.plugin.directory}")
    private String pluginDirectoryPath;

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private PluginManagement pluginManagement;

    @Autowired
    private ExporterFactory exporterFactory;

    @Override
    public void crawl(String url, String pluginType, List<String> exportTypes) throws Exception {
        pluginManagement.load(pluginDirectoryPath);
        List<ExportTemplate> exportTemplates = crawlerService.crawl(url, pluginType);

        for(String exportType : exportTypes) {
            ExporterType exporterType = ExporterType.fromShortcut(exportType);

            if(exporterType == null) {
                System.out.println("Empty export type");
            }
            Exporter exporter = exporterFactory.getExporter(exporterType);
            exporter.export(exportTemplates);
        }
    }
}
