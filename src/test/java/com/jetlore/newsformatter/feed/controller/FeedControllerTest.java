package com.jetlore.newsformatter.feed.controller;

import com.jetlore.newsformatter.NewsFormatterApplication;
import com.jetlore.newsformatter.feed.model.Entity;
import com.jetlore.newsformatter.feed.model.Feed;
import com.jetlore.newsformatter.type.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewsFormatterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeedControllerTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void processFeedTest() {
        List<Entity> entityList = new LinkedList<>();
        entityList.add(new Entity(14, 22, "entity"));
        entityList.add(new Entity(0, 5, "entity"));
        entityList.add(new Entity(37, 54, "link"));
        entityList.add(new Entity(56, 67, "twitter"));
        String post = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";

        Feed feed = new Feed(post, entityList);
        String expectedProcessedFeed = "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @<a href=\"http://twitter.com/elversatile\">elversatile</a>";

        ResponseEntity<String> response = restTemplate.postForEntity(createURLWithPort("/api/feeds"), feed, String.class);

        assertEquals(expectedProcessedFeed, response.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
