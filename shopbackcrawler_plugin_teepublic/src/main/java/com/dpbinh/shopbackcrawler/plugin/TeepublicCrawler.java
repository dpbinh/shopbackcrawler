package com.dpbinh.shopbackcrawler.plugin;

import com.dpbinh.shopbackcrawler.model.ExportTemplate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeepublicCrawler implements ItemCrawler {
    @Override
    public List<String> getSupportTypes() {
        return Arrays.asList("teepublic");
    }

    @Override
    public List<ExportTemplate> execute(String url) throws IOException {

        File input = new File(url);
        Document doc = Jsoup.parse(input, "UTF-8", "https://www.teepublic.com/");
        Element content = doc.select(".main-wrapper #content").first();

        List<String> imageSrcs = new ArrayList<>();
        String title = "";
        List<String> colors = new ArrayList<>();
        List<String> genders = new ArrayList<>();
        List<String> sizes = new ArrayList<>();
        String price = "";
        List<String> styles = new ArrayList<>();

        if(content != null) {
            Element titleEl = content.select(".m-design__title .h__h1--sm").first();
            if(titleEl != null) {
                title = titleEl.text();
            }

            Element productEl = content.select(".glide__slides").first();
            if(productEl != null) {
                Elements imageEl = productEl.select(".glide__slide .jsProductMainImage");
                if(imageEl != null) {
                    for(Element element : imageEl) {
                        imageSrcs.add(element.attr("src"));
                    }
                }
            }

            Element options = content.select(".m-design__options").first();
            if(options != null) {
                Elements colorEls = options.select(".m-cart-config__colors2 .m-cart-config__color-wrap2");

                for(Element element : colorEls) {
                    Element colorLb = Optional.ofNullable(element.getElementsByTag("label").first()).orElse(new Element("Custom"));
                    String color = colorLb.attr("alt");
                    if(color != null && !color.isEmpty()) {
                        colors.add(color);
                    }

                }

                genders = options.select(".radio-selector .gender .radio-selector__select")
                        .stream().map(p -> p.text()).collect(Collectors.toList());

                sizes = options.select(".radio-selector .size .radio-selector__select")
                        .stream().map(p -> p.text()).collect(Collectors.toList());

                price = Optional.ofNullable(options.select(".m-design__prices .m-design__price--regular").first())
                        .orElse(new Element("Custom")).text();

                styles = options.select(".style select option").stream().map(p -> p.text()).collect(Collectors.toList());
            }

        }

        List<ExportTemplate> exportTemplates = new ArrayList<>();

        String style = styles.size() > 0 ? styles.get(0) : "";
        for (String color : colors) {
            for (String size : sizes) {
                ExportTemplate exportTemplate = new ExportTemplate();
                exportTemplate.setTitle(title);
                exportTemplate.setImagesrc(imageSrcs.size() > 0 ? imageSrcs.get(0) : "");
                exportTemplate.setOption1Name("Size");
                exportTemplate.setOption1Value(size);
                exportTemplate.setOption2Name("Color");
                exportTemplate.setOption2Value(color);
                exportTemplate.setOption3Name("Pattern");
                exportTemplate.setOption3Value(style);
                exportTemplate.setVariantPrice(price);
                exportTemplates.add(exportTemplate);
            }
        }

        return exportTemplates;
    }

    @Override
    public List<String> extractUrls(String pageUrl) throws Exception {
        List<String> urls = new ArrayList<>();

        File dir = new File(pageUrl);
        if(dir.exists()) {
            for(File file : dir.listFiles()) {
                if(file.isFile() && file.getName().contains(".html")) {
                    urls.add(file.getAbsolutePath());
                }
            }
        }
        return urls;
    }

    @Override
    public List<String> extractPageUrls(String pageUrl) throws Exception {
        return Arrays.asList("libs/teepublic/");
    }

    public static void main(String[] args) throws Exception {
         TeepublicCrawler crawler = new TeepublicCrawler();
         crawler.execute("E:\\Works\\codes\\shopbackcrawler\\libs\\teepublic\\FAB 5 - Fab 5 - T-Shirt _ TeePublic.html");
    }
}


