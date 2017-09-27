package com.unionOfMiners.android.union.KZTRates;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by HP on 27.07.2017.
 */
@Root(name = "item", strict = false)
public class Items {

    @Element(name = "title")
    private String title;


    @Element(name = "description")
    protected String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDescription() {
        return Double.parseDouble(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
