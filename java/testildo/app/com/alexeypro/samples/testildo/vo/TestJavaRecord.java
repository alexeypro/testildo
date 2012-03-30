package com.alexeypro.samples.testildo.vo;

import com.alexeypro.samples.testildo.vo.mongo.TestJavaRecordModel;

import java.util.ArrayList;
import java.util.List;

public class TestJavaRecord {
    private String id;
    private String body;
    private String title;

    public TestJavaRecord(TestJavaRecordModel rec) {
        if (rec != null) {
            this.id = (rec.getId() == null ? null : rec.getId().toString());
            this.body = rec.getBody();
            this.title = rec.getTitle();
        }
    }

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

    /**
     * Helper method to do the conversion
     *
     * @param src
     * @return
     */
    public final static List<TestJavaRecord> fromList(List<TestJavaRecordModel> src) {
        List<TestJavaRecord> result = new ArrayList<TestJavaRecord>(1);
        if (src == null || src.isEmpty()) {
            return result;
        }
        for (TestJavaRecordModel m : src) {
            result.add(new TestJavaRecord(m));
        }
        return result;
    }

    @Override
    public String toString() {
        return "TestJavaRecordModel [id=" + id + ", body=" + body + ", title="
                + title + "]";
    }

}
