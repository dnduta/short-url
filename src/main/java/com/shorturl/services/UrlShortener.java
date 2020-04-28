package com.shorturl.services;

import com.shorturl.entities.ShortUrl;

public interface UrlShortener {
    String hashUrl(String url) throws Exception;
    ShortUrl saveUrl(String url) throws Exception;
    ShortUrl getUrl(String url);
}
