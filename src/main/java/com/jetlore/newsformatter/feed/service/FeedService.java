package com.jetlore.newsformatter.feed.service;

import com.jetlore.newsformatter.feed.model.Entity;
import com.jetlore.newsformatter.feed.model.TransformedEntity;
import com.jetlore.newsformatter.feed.model.Feed;
import com.jetlore.newsformatter.type.model.Type;
import com.jetlore.newsformatter.type.service.TypeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class FeedService {

    private static Log LOG = LogFactory.getLog(FeedService.class);

    @Autowired
    private TypeService typeService;

    public String processFeed(Feed feed) {
        List<TransformedEntity> transformedEntities = new LinkedList<>();
        Type type;

        for (Entity e : feed.getEntityList()) {
            type = typeService.getTypeByName(e.getType());
            transformedEntities.add(
                    new TransformedEntity(e.getStart(),
                            e.getEnd(),
                            e.getType(),
                            feed.getPost().substring(e.getStart(), e.getEnd()),
                            getReplacedString(feed.getPost(), e.getStart(), e.getEnd(), type.getPattern())));
        }

        Collections.sort(transformedEntities);
        LOG.info("Transformed entities: " + transformedEntities);

        StringBuilder sb = new StringBuilder(feed.getPost());

        int offset = 0, start = 0, end = 0;
        for (TransformedEntity te : transformedEntities) {
            start = te.getStart() + offset;
            end = te.getEnd() + offset;
            sb = sb.replace(start, end, te.getTranformedValue());
            offset += te.getTranformedValue().length() - te.getValue().length();
        }

        return sb.toString();
    }

    protected String getReplacedString(String post, int start, int end, String pattern) {
        return pattern.replaceAll("\\*", post.substring(start, end));
    }
}
