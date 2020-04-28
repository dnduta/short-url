package com.shorturl.services;

import com.shorturl.entities.ShortUrl;
import com.shorturl.repositories.ShortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

@Service
public class UrlShortenerImpl implements UrlShortener {
    @Autowired
    private MessageDigest md5instance;

    @Autowired
    private ShortRepository shortRepository;

    @Override
    public String hashUrl(String url)  throws Exception
    {
        md5instance.update(url.getBytes());
        return DatatypeConverter.printHexBinary( md5instance.digest() ).substring(0, 6);
    }

    @Override
    public ShortUrl saveUrl(String url) throws Exception {
        String hashed = hashUrl(url);
        ShortUrl shorturl = getUrl(hashed);
        if(shorturl != null)
        {
            return shorturl;
        }
        return shortRepository.save(new ShortUrl(hashed, url));
    }

    @Override
    public ShortUrl getUrl(String key) {
        return shortRepository.findByKey(key);
    }
}
