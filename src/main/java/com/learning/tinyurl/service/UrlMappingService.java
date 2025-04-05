package com.learning.tinyurl.service;

import com.learning.tinyurl.web.response.UrlMappingCreateResponse;

public interface UrlMappingService {
    UrlMappingCreateResponse createShortUrl(String originalUrl);
    String generateShortCode();
}
