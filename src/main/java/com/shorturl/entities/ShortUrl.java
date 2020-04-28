package com.shorturl.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ShortUrl {
    @Id
    private long id;

    private String key;

    private String original;

    public ShortUrl() {}

    public ShortUrl(String _key, String _original)
    {
        key = _key;
        original = _original;
    }
}
