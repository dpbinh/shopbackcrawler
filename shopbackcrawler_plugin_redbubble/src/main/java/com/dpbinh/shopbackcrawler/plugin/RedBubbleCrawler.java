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

public class RedBubbleCrawler implements ItemCrawler {
    @Override
    public List<String> getSupportTypes() {
        return Arrays.asList("redbubble");
    }

    @Override
    public List<ExportTemplate> execute(String url) throws IOException {

        File input = new File(url);
        Document doc = Jsoup.parse(input, "UTF-8", "https://www.redbubble.com/");
        Element content = doc.select(".Routing__main--RW6rn .DesktopProductPage__primaryContent--2GiWp").first();

        List<String> imageSrcs = new ArrayList<>();
        String title = "";
        List<String> colors = Arrays.asList("Black", "White", "Heather Gray", "Denim Heather", "Navy", "Blue", "Light Blue", "Creme",
                "Red", "Dark Grey", "Green", "Army", "Dark Red", "Gold", "Purple", "Brown", "Orange");
        List<String> genders = new ArrayList<>();
        List<String> sizes = Arrays.asList("X", "M", "L", "XL", "2XL", "3XL");
        String price = "";
        List<String> styles = new ArrayList<>();

        if(content != null) {
            Element titleEl = content.select(".DesktopProductPage__config--3xaTv .styles__box--2Ufmy h1").first();
            if(titleEl != null) {
                title = titleEl.text();
            }

            Element productEl = content.select(".PreviewGallery__preview--bWOCE").first();
            if(productEl != null) {
                Element imageEl = productEl.select(".GalleryImage__img--12Vov").first();
                if(imageEl != null) {
                    imageSrcs.add(imageEl.attr("src"));
                }
            }

            Element options = content.select(".DesktopProductPage__config--3xaTv").first();
            if(options != null) {
//                Elements colorEls = options.select(".m-cart-config__colors2 .m-cart-config__color-wrap2");
//
//                for(Element element : colorEls) {
//                    Element colorLb = Optional.ofNullable(element.getElementsByTag("label").first()).orElse(new Element("Custom"));
//                    String color = colorLb.attr("alt");
//                    if(color != null && !color.isEmpty()) {
//                        colors.add(color);
//                    }
//
//                }

//                Element sizeEl = options.select("#downshift-529292-menu").first();
//                if(sizeEl == null) {
//                    sizeEl = options.select("#DesktopApparelConfigurator_SizeSelector").first();
//                    if(sizeEl != null) {
//                        sizes = sizeEl.select(".styles__group--gY36K .styles__labelText--pDaaA").stream().map(p -> p.text()).collect(Collectors.toList());
//                    }
//                } else {
//                    sizes = sizeEl.getElementsByTag("li")
//                            .stream().map(p -> p.text()).collect(Collectors.toList());
//                }

                price = Optional.ofNullable(options.select(".DesktopProductPage__config--3xaTv").first())
                        .orElse(new Element("Custom")).text();

             }

        }

        List<ExportTemplate> exportTemplates = new ArrayList<>();
        for(String color : colors) {
            for (String size : sizes) {
                ExportTemplate exportTemplate = new ExportTemplate();
                exportTemplate.setTitle(title);
                exportTemplate.setImagesrc(imageSrcs.size() > 0 ? imageSrcs.get(0) : "");
                exportTemplate.setOption1Name("Size");
                exportTemplate.setOption1Value(size);
                exportTemplate.setOption2Name("Color");
                exportTemplate.setOption2Value(color);
                exportTemplate.setOption3Name("Pattern");
                exportTemplate.setOption3Value("");
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
        return Arrays.asList("libs/redbubble/");
    }

    public static void main(String[] args) throws Exception {
         RedBubbleCrawler crawler = new RedBubbleCrawler();
        crawler.execute("E:\\Works\\codes\\shopbackcrawler\\libs\\redbubble\\_Rock Vinyl Collage _ T-shirt by Hunter54nz _ Redbubble.html");


//         crawler.execute("E:\\Works\\codes\\shopbackcrawler\\libs\\redbubble\\_Hoptopus - The Beer Drinking Octopus_ T-shirt by HabbyArt _ Redbubble.html");
    }
}


