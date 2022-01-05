package com.benlu.demo.model;

public class FileInfo {
    private String name;
    private String url;

    public FileInfo(String name, String url) {
        System.out.println("File info");
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}