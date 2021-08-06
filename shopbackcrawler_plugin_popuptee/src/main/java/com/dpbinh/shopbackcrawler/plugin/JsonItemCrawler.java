package com.dpbinh.shopbackcrawler.plugin;

import com.dpbinh.shopbackcrawler.model.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.*;

public class JsonItemCrawler implements ItemCrawler {

    public JsonItemCrawler(){
    }

    @Override
    public List<String> getSupportTypes() {
        return Arrays.asList("poputees");
    }

    @Override
    public List<ExportTemplate> execute(String url) {
        if(url == null && url.trim().length() == 0) {
            return null;
        }

        String formattedUrl = url;
        while(formattedUrl.charAt(formattedUrl.length() -1 ) == '/') {
            formattedUrl = url.substring(0, formattedUrl.length() - 1);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Product product = null;
        try {
            ItemResponse itemResponse = objectMapper.readValue(new URL(formattedUrl), ItemResponse.class);
            product = itemResponse.getProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product == null ? Collections.EMPTY_LIST : convert(product);
    }

    @Override
    public List<String> extractUrls(String pageUrl) throws Exception {
        Document doc = Jsoup.connect(pageUrl).get();
        Elements pageItems = doc.select(".collection .card .product-list .product-item");

        List<String> urls = new LinkedList<>();
        for(Element element : pageItems) {
            Element hrefTag = element.getElementsByTag("a").first();
            if(hrefTag != null) {
                String url = hrefTag.attr("href");
                urls.add("https://www.poputees.com" + url + ".json");
            }
        }

        return urls;
    }

    @Override
    public List<String> extractPageUrls(String pageUrl) throws Exception {
        Document doc = Jsoup.connect(pageUrl).get();
        Elements pageItems = doc.select(".collection .card .pagination__nav a");

        Integer max = 0;

        for(Element element : pageItems) {
            String pageIdStr = element.attr("data-page");
            Integer pageId = Integer.parseInt(pageIdStr);
            if(pageId >= max) {
                max = pageId;
            }
        }

        List<String> pageUrls = new ArrayList<>(max);
        for(int i = 1; i <= max; i++) {
            pageUrls.add(pageUrl + "?page=" + i);
        }

        return pageUrls;
    }

    private List<ExportTemplate> convert(Product product) {

        List<ExportTemplate> exportTemplates = new ArrayList<>();

        Date date = new Date();
        String groupID = String.valueOf(String.valueOf(date.getDay())) + String.valueOf(date.getMonth()) + String.valueOf(date.getYear()) + "_" + String.valueOf(date.getHours()) + date.getMinutes() +
                String.valueOf(date.getSeconds()) + String.valueOf(System.currentTimeMillis());
        for (Variant variant : product.getVariants()) {
            ExportTemplate exportTemplate = new ExportTemplate();
            exportTemplate.setTitle(product.getTitle());
            exportTemplate.setGroupId(groupID);
            exportTemplate.setHandle(product.getTitle());
            exportTemplate.setVendor("");
            String body = "";
            exportTemplate.setOption1Value(variant.getOption3());
            if (variant.getOption2() != null && variant.getOption2() != "") {
                exportTemplate.setOption2Value(variant.getOption2());
            } else {
                exportTemplate.setOption2Value("-");
            }
            exportTemplate.setOption3Value(variant.getOption1());
            if ("Custom Ultra Cotton T-Shirt".equals(variant.getOption1())) {
                body = "<ul><li>6.1-ounce, 100% cotton</li><li>Double-needle neck, sleeves and hem; Roomy Unisex Fit</li><li>Ash is 99% cotton, 1% poly; Sport Grey is 90% cotton, 10% poly; Dark Heather is 50% cotton, 50% polyester</li><li>Decoration type: Digital Print</li><li>Made by Gildan</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/G200.png' style='width:100%'>";
            } else if ("Bella+Canvas Flowy Racerback Tank".equals(variant.getOption1())) {
                body = "<ul><li>3.7 oz., 65% polyester, 35% viscose; 30 singles</li><li>Racerback with sheering at seam; sideseamed merrowed bottom hem</li><li>Easy, drapey fit; Runs small, order one size up for a fuller fit</li><li>Decoration type: Digital Print</li><li>Made by Bella + Canvas</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/8800.png' style='width:100%'></p>";
            } else if ("Pullover Hoodie 8 oz".equals(variant.getOption1())) {
                body = "<ul><li>8 oz 50/50 cotton/poly</li><li>Air jet yarn creates a smooth, low-pill surface</li><li>Double needle stitching; Pouch pocket; Unisex sizing</li><li>Decoration type: Digital Print or Screen Print  (based on design &amp; quantity)</li><li>Made by Gildan</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/G185.png' style='width:100%'></p>";
            } else if ("Printed Crewneck Pullover Sweatshirt  8 oz".equals(variant.getOption1())) {
                body = "<ul><li>8 oz; 50% cotton/50% polyester</li><li>Air jet yarn for a softer feel and no pilling</li><li>1x1 athletic rib cuffs and waistband with spandex;  Double-needle stitching</li><li>Decoration type: Digital Print or Screen Print  (based on design &amp; quantity)</li><li>Made by Gildan</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/G180.png' style='width:100%'></p>";
            } else if ("Next Level Ladies' Boyfriend Tee".equals(variant.getOption1())) {
                body = "<ul><li>4.3 oz, 100% combed ring-spun cotton jersey; Fabric laundered</li><li>Heather Gray 90% cotton/10% polyester; 32 singles for extreme softness</li><li>Slim Fit, please refer to size chart for actual garment measurements</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Next Level</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/NL3900.png' style='width:100%'></p>";
            } else if ("LS Ultra Cotton Tshirt".equals(variant.getOption1())) {
                body = "<ul><li>6.1-ounce, 100% cotton</li><li>Ash is 99% cotton, 1% poly; Sport Grey is 90% cotton, 10% poly; Dark Heather is 50% cotton, 50% polyester</li><li>Double-needle neck, sleeves and hem; Unisex sizing; consult size chart for details</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Gildansrc='https://images.mylocker.net/size_charts/trimmed/G240.png' style='width: 100%;'></p>";
            } else if ("LS Ultra Cotton Tshirt".equals(variant.getOption1())) {
                body = "<ul><li>6.1-ounce, 100% cotton</li><li>Ash is 99% cotton, 1% poly; Sport Grey is 90% cotton, 10% poly; Dark Heather is 50% cotton, 50% polyester</li><li>Double-needle neck, sleeves and hem; Unisex sizing; consult size chart for details</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Gildansrc='https://images.mylocker.net/size_charts/trimmed/G240.png' style='width: 100%;'></p>";
            } else if ("Heavyweight Pullover Fleece Sweatshirt".equals(variant.getOption1())) {
                body = "<ul><li>9 oz, 75% cotton, 25% polyester; Premium Ringspun Cotton</li><li>2 inch rolled forward shoulder</li><li>Contrast dark grey twill neck tape and drawstrings</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Gildan</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/G925.png' style='width: 100%;''></p>";
            } else if ("Heavyweight Crewneck Sweatshirt 9 oz".equals(variant.getOption1())) {
                body = "<ul><li>9 oz, 75% cotton, 25% polyester; Premium ringspun cotton</li><li>Contrast dark grey twill neck tape</li><li>Double-needle cuffs; 1x1 rib with spandex</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Gildan</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/G920.png' style='width: 100%;'></p>";
            } else if ("Youth Crewneck Sweatshirt".equals(variant.getOption1())) {
                body = "<ul><li>9-ounce, 50% cotton, 50% polyester fleece</li><li>Cover seamed crewneck, arm seams and waistband</li><li>We suggest ordering one or two sizes up for a fuller fit; Please refer to size chart for actual garment measurements</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Port &amp; Cosrc='https://images.mylocker.net/size_charts/trimmed/O.jpg'style='width: 100%;'></p>";
            } else if ("Ladies Custom 100% Cotton T-Shirt".equals(variant.getOption1())) {
                body = "<ul><li>6.0 oz.; 100% preshrunk cotton; Sport Grey is 90/10 Dark Heather is 50/50</li><li>Narrow 5/8 inch seamless collar</li><li>Ladies' fit with shorter body length and tapered sleeves</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Gildan</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/G200L.png' style='width: 100%;'></p>";
            } else if ("Next Level Premium Short Sleeve Tee".equals(variant.getOption1())) {
                body = "<ul><li>4.3 oz, 100% combed cotton jersey</li><li>Heather Gray 90% cotton/10% polyester; Fabric laundered</li><li>32 singles for extreme softness; 1x1 baby rib-knit set-in collar</li><li>Decoration type: Digital Print or Screen Print (based on design &amp; quantity)</li><li>Made by Next Level</li></ul><p><img src='https://images.mylocker.net/size_charts/trimmed/NL3600.png' style='width: 100%;'></p>";
            } else {
                body = String.valueOf(variant.getTitle()) + " - " + variant.getOption1();
            }
            exportTemplate.setImageAltText(product.getTitle());
            exportTemplate.setSeoDescription(product.getTitle());
            exportTemplate.setSeoTitle(product.getTitle());
            exportTemplate.setBodyHTML(body);
            exportTemplate.setSeoDescription(body);
            exportTemplate.setVariantPrice(String.valueOf(variant.getPrice()));
            exportTemplate.setVariantWeightUnit(variant.getWeight_unit());
            exportTemplate.setVariantSKU(variant.getSku());

            for (Image image : product.getImages()) {
                if (image != null && image.getId().equals(variant.getImage_id())) {
                    exportTemplate.setImagesrc(image.getSrc().replace("\\", ""));
                    exportTemplate.setVariantImage(image.getSrc().replace("\\", ""));
                }
            }


            exportTemplates.add(exportTemplate);
        }

        return exportTemplates;
    }
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.poputees.com/collections/hoodies").get();
        Elements pageItems = doc.select(".collection .card .product-list .product-item");

        for(Element element : pageItems) {
            Element hrefTag = element.getElementsByTag("a").first();
            if(hrefTag != null) {
                String url = hrefTag.attr("href");
                System.out.println("https://www.poputees.com" + url);
            }
        }

    }
}
