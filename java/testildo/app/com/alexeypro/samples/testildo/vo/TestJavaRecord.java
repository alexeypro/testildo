package com.alexeypro.samples.testildo.vo;

public class TestJavaRecord {
    private String id;
    private String body;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TestJavaRecord [id=" + id + ", body=" + body + ", title="
                + title + "]";
    }

}
