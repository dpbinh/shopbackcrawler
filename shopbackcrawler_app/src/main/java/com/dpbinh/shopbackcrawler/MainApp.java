package com.dpbinh.shopbackcrawler;

import com.dpbinh.shopbackcrawler.controller.CrawlerController;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    @Autowired
    private CrawlerController crawlerController;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, String> params = new HashMap<>();

        for(String arg : args) {
            String[] pair = arg.split("=");
            if(pair.length > 1) {
                params.put(pair[0], pair[1]);
            }
        }

        String url = params.get("url");
        String type = params.get("type");
        String exportType = params.get("exportType");

        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(type), "type is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(exportType), "exportType is empty");

        String[] exportTypes = exportType.split(",");
        crawlerController.crawl(url, type, Arrays.asList(exportTypes));
    }
}
