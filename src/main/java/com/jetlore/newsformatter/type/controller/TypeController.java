package com.jetlore.newsformatter.type.controller;

import com.jetlore.newsformatter.type.model.Type;
import com.jetlore.newsformatter.type.service.TypeService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TypeController {

    private static Log LOG = LogFactory.getLog(TypeController.class);

    @Autowired
    private TypeService typeService;

    @ApiOperation(value = "Create model types")
    @RequestMapping(value = "/api/types", method = POST)
    public ResponseEntity<? extends Object> createTypes(@RequestBody List<Type> types) {
        LOG.info("Request to create types: " + types);
        typeService.create(types);
        return new ResponseEntity<>(CREATED);
    }

    @ApiOperation(value = "Get model types", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/api/types", method = GET)
    public ResponseEntity<List<Type>> getTypes() {
        LOG.info("Request to get types ");
        List<Type> types = typeService.getTypes();
        return new ResponseEntity(types, OK);
    }

}
