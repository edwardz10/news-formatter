package com.jetlore.newsformatter.feed.model;

import java.util.List;

public class Feed {

    private String post;
    private List<Entity> entityList;

    public Feed() {}

    public Feed(String post, List<Entity> entityList) {
        this.post = post;
        this.entityList = entityList;
    }

    public String getPost() {
        return post;
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    @Override
    public String toString() {
        return "post: " + getPost()
                + ", entityList: " + getEntityList();
    }

}
