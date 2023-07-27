package com.ascension.pages;

public class PageElements {
    private String id;
    private String cssSelector;

    private String option;

    // Constructors, getters, and setters

    public PageElements() {
    }

    public PageElements(String id, String cssSelector) {
        this.id = id;
        this.cssSelector = cssSelector;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCssSelector() {
        return cssSelector;
    }

    public String getOption() {
        return option;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }
}
