package com.jetlore.newsformatter.type.service;

import com.google.common.collect.Lists;
import com.jetlore.newsformatter.type.model.Type;
import com.jetlore.newsformatter.type.repository.TypeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TypeService {

    private static Log LOG = LogFactory.getLog(TypeService.class);

    @Autowired
    private TypeRepository typeRepository;

    @PostConstruct
    public void init() {
        typeRepository.save(new Type("entity", "<strong>*</strong>"));
        typeRepository.save(new Type("twitter", "<a href=\"http://twitter.com/*\">*</a>"));
        typeRepository.save(new Type("link", "<a href=\"*\">*</a>"));
    }

    public void create(List<Type> types) {
        for (Type t : types) {
            typeRepository.save(t);
        }
    }

    public List<Type> getTypes() {
        return Lists.newArrayList(typeRepository.findAll());
    }

    public void deleteTypes() {
        typeRepository.deleteAll();
    }

    public Type getTypeByName(final String name) {
        return typeRepository.findByName(name);
    }

}
