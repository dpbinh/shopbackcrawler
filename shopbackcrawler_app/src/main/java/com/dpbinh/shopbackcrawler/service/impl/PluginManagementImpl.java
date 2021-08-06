package com.dpbinh.shopbackcrawler.service.impl;

import com.dpbinh.shopbackcrawler.plugin.ItemCrawler;
import com.dpbinh.shopbackcrawler.service.PluginManagement;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

@Service
public class PluginManagementImpl implements PluginManagement {

    private List<ItemCrawler> itemCrawlers;

    public PluginManagementImpl() throws Exception {
    }

    @Override
    public void load(String path) throws Exception {
        List<ItemCrawler> itemCrawlers = new LinkedList<>();
        File pluginsDir = new File(path);

        for (File jar : pluginsDir.listFiles()) {

            ClassLoader loader = URLClassLoader.newInstance(new URL[] {jar.toURI().toURL()},
                    getClass().getClassLoader() );
            JarFile jarFile = new JarFile(jar);
            Enumeration<JarEntry> es = jarFile.entries();

            while (es.hasMoreElements()) {
                JarEntry jarEntry =  es.nextElement();
                String name = jarEntry.getName();

                if (name != null && name.endsWith(".class")) {
                    String className = name.replace("/", ".").substring(0, name.length() - 6);
                    Class<?> clazz = loader.loadClass(className); // Handling the .class suffix name

                    if(Arrays.asList(clazz.getInterfaces()).contains(ItemCrawler.class)) {
                        Class<? extends ItemCrawler> newClass = clazz.asSubclass(ItemCrawler.class);
                        Constructor<? extends ItemCrawler> constructor = newClass.getConstructor();
                        ItemCrawler itemCrawler = constructor.newInstance();
                        itemCrawlers.add(itemCrawler);
                    }
                }
            }
        }

        this.itemCrawlers = itemCrawlers;
    }

    @Override
    public List<ItemCrawler> getItemCrawlers() {
        return itemCrawlers;
    }

    @Override
    public List<ItemCrawler> getItemCrawlers(String pluginType) {
        return itemCrawlers.stream().filter(p -> p.getSupportTypes().contains(pluginType)).collect(Collectors.toList());
    }
}
