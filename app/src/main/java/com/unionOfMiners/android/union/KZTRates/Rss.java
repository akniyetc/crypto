package com.unionOfMiners.android.union.KZTRates;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by HP on 28.07.2017.
 */
@Root(name = "rss", strict = false)
public class Rss {
    @Path("channel")
    @Element(name = "generator")
    private String generator;
//
//    @Element(name = "title")
//    private String title;
//
//    @Element(name = "link")
//    private String link;
//
//    @Element(name = "description")
//    private String description;
//
//    @Element(name = "language")
//    private String language;
//
//    @Element(name = "copyright")
//    private String copyright;
    @Path("channel")
    @ElementList(inline = true, required = false)
    public static List<Items> items;

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public String getCopyright() {
//        return copyright;
//    }
//
//    public void setCopyright(String copyright) {
//        this.copyright = copyright;
//    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
