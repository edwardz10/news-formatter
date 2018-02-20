package com.jetlore.newsformatter.type.controller;

import com.jetlore.newsformatter.type.model.Type;
import com.jetlore.newsformatter.type.service.TypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TypeController {

    private static Log LOG = LogFactory.getLog(TypeController.class);

    @Autowired
    private TypeService typeService;

    @ApiOperation(value = "Create model types", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/api/types", method = POST)
    public ResponseEntity<List<Type>> createTypes(@RequestBody List<Type> types) {
        LOG.info("Request to create types: " + types);
        typeService.create(types);
        return new ResponseEntity<>(typeService.getTypes(), CREATED);
    }

    @ApiOperation(value = "Get model types", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/api/types", method = GET)
    public ResponseEntity<List<Type>> getTypes() {
        LOG.info("Request to get types ");
        List<Type> types = typeService.getTypes();
        return new ResponseEntity(types, OK);
    }

    @ApiOperation(value = "Delete model types")
    @RequestMapping(value = "/api/types", method = DELETE)
    public ResponseEntity<List<Type>> deleteTypes() {
        LOG.info("Request to get types ");
        typeService.deleteTypes();
        return new ResponseEntity(OK);
    }

    @ApiOperation(value = "Find type by name")
    @RequestMapping(value = "/api/types/{name}", method = GET)
    public ResponseEntity<List<Type>> getTypeByName(
            @ApiParam(value = "Type name", required = true)
            @PathVariable(name = "name") final String name) {
        LOG.info("Request to get type by name: '" + name + "'");
        return new ResponseEntity(typeService.getTypeByName(name), OK);
    }

}
