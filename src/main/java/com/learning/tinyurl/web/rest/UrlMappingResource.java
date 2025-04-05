package com.learning.tinyurl.web.rest;

import com.learning.tinyurl.service.UrlMappingService;
import com.learning.tinyurl.web.request.UrlMappingCreateRequest;
import com.learning.tinyurl.web.response.UrlMappingCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tiny-url")
public class UrlMappingResource {

    private final UrlMappingService service;

    public UrlMappingResource(UrlMappingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UrlMappingCreateResponse> generateTinyUrl(@RequestBody UrlMappingCreateRequest request) {
        UrlMappingCreateResponse mapping = service.createShortUrl(request.getOriginalUrl());
        UrlMappingCreateResponse response = new UrlMappingCreateResponse();
        response.setShortCode(mapping.getShortCode());
        return ResponseEntity.ok(response);
    }
}
