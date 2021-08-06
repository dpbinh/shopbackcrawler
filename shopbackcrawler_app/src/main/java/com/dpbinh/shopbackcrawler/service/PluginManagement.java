package com.dpbinh.shopbackcrawler.service;

import com.dpbinh.shopbackcrawler.plugin.ItemCrawler;

import java.util.List;

public interface PluginManagement {

    void load(String path) throws Exception;

    List<ItemCrawler> getItemCrawlers();

    List<ItemCrawler> getItemCrawlers(String pluginType);
}
