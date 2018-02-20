package com.jetlore.newsformatter.feed.model;

public class Entity implements Comparable<Entity> {

    private Integer start;
    private Integer end;
    private String type;

    public Entity() {}

    public Entity(Integer start, Integer end, String type) {
        this.start = start;
        this.end = end;
        this.type = type;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "start: " + getStart()
                + ", end: " + getEnd()
                + ", type: " + getType();
    }

    @Override
    public int compareTo(Entity o) {
        if (start == o.start)
            return end - o.end;

        return start - o.start;
    }
}
