package com.dpbinh.shopbackcrawler.service.impl;

import java.util.HashMap;
import java.util.Map;

public enum ExporterType {
    SHOPIFY("S"),
    WORDPRESS("W");

    private static Map<String, ExporterType> shortcutMap = new HashMap<>();
    static {
        for(ExporterType exporterType : ExporterType.values()) {
            shortcutMap.put(exporterType.shortcut, exporterType);
        }
    }

    private String shortcut;

    ExporterType(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public static ExporterType fromShortcut(String shortcut){
        return shortcutMap.get(shortcut);
    }
}
