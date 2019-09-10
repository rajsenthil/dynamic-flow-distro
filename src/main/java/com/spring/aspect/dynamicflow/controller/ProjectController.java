package com.spring.aspect.dynamicflow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger( ProjectController.class);

    @RequestMapping (path="/startProcess", method = RequestMethod.POST, produces = {"application/hal+json"})
    public ResponseEntity<String> createJob( @RequestParam String name) {
        LOGGER.info( "Starting the process");

        return ResponseEntity.ok( "Started the process" );
    }
}
