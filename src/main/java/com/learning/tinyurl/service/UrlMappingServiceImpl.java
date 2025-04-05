package com.learning.tinyurl.service;

import com.learning.tinyurl.domain.UrlMapping;
import com.learning.tinyurl.repository.UrlMappingRepository;
import com.learning.tinyurl.web.response.UrlMappingCreateResponse;
import java.security.SecureRandom;
import org.springframework.stereotype.Service;

@Service
public class UrlMappingServiceImpl implements UrlMappingService {

    private final UrlMappingRepository repository;

    public UrlMappingServiceImpl(UrlMappingRepository repository) {
        this.repository = repository;
    }

    @Override
    public UrlMappingCreateResponse createShortUrl(String originalUrl) {
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortCode(generateShortCode());
        UrlMapping savedMapping = repository.save(urlMapping);

        UrlMappingCreateResponse response = new UrlMappingCreateResponse();
        //response.setShortCode(savedMapping.getShortCode());
        return response;
    }

    @Override
    public String generateShortCode() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
