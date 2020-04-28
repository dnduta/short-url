package com.shorturl.models;

import lombok.Data;

@Data
public class Shorter {
    private String short_url;

    public Shorter() {}

    public Shorter(String _url)
    {
        short_url = _url;
    }
}
