package com.jetlore.newsformatter.type.controller;

import com.jetlore.newsformatter.NewsFormatterApplication;
import com.jetlore.newsformatter.type.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewsFormatterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TypeControllerTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getTypesTest() {
        ResponseEntity<Type[]> response = restTemplate.getForEntity(createURLWithPort("/api/types"), Type[].class);
        Type[] types = response.getBody();

        assert(types.length > 0);
        assertEquals(types[2].getName(), "link");
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
