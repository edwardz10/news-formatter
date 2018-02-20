package com.jetlore.newsformatter.feed.model;

public class TransformedEntity extends Entity {

    private String value;
    private String tranformedValue;

    public String getTranformedValue() {
        return tranformedValue;
    }

    public TransformedEntity(Integer start, Integer end, String type, String value, String tranformedValue) {
        super(start, end, type);
        this.value = value;
        this.tranformedValue = tranformedValue;

    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString() + ", value=" + getValue() + ", transformedValue=" + getTranformedValue();
    }
}
