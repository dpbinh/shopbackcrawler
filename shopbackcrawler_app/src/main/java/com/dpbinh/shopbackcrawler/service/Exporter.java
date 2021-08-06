package com.dpbinh.shopbackcrawler.service;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;

import java.io.IOException;
import java.util.List;

public interface Exporter<T extends ExportTemplate> {
    void export(List<T> product) throws IOException;
}
