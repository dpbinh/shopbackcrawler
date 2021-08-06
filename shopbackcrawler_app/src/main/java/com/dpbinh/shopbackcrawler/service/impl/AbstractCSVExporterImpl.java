package com.dpbinh.shopbackcrawler.service.impl;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;
import com.dpbinh.shopbackcrawler.service.Exporter;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class AbstractCSVExporterImpl<T extends ExportTemplate> implements Exporter<T> {

    @Override
    public void export(List<T> exportTemplates) throws IOException {
        String fileName = getFileName();
        List<String> header = getHeader();


        try(CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
             writer.writeNext(header.toArray(new String[header.size()]));
            for (ExportTemplate exportTemplate : exportTemplates) {
                List<String> records = getRecords(exportTemplate);
                writer.writeNext(records.toArray(new String[records.size()]));
            }
        }
    }



    protected abstract String getFileName();

    protected abstract List<String> getRecords(ExportTemplate exportTemplate);

    protected abstract List<String> getHeader();
}
