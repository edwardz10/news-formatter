package com.jetlore.newsformatter.type.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "type")
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="pattern")
    private String pattern;

    public Type() {}

    public Type(String name, String pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "name: " + getName()
               + ", pattern: " + getPattern();
    }

}


