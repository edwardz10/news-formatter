package com.jetlore.newsformatter.feed.controller;

import com.jetlore.newsformatter.feed.model.Feed;
import com.jetlore.newsformatter.feed.service.FeedService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class FeedController {

    private static Log LOG = LogFactory.getLog(FeedController.class);

    @Autowired
    private FeedService feedService;

    @ApiOperation(value = "Process feed", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/api/feeds", method = POST)
    public ResponseEntity<String> processFeed(@RequestBody Feed feed) {
        LOG.info("Request to process a feed: " + feed);
        return new ResponseEntity<>(feedService.processFeed(feed), OK);
    }

}
