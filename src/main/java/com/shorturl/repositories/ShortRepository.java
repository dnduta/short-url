package com.shorturl.repositories;

import com.shorturl.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortRepository extends JpaRepository<ShortUrl, Long> {
        ShortUrl findByKey(String key);
}
