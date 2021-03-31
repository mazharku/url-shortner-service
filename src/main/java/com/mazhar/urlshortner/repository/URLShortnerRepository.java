package com.mazhar.urlshortner.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mazhar.urlshortner.model.URLModel;

public interface URLShortnerRepository extends JpaRepository<URLModel, UUID>{

   @Query(value = "SELECT * FROM {h-schema}URLModel WHERE short_url =:shortUrl", nativeQuery = true)
   public Optional<URLModel> findByShortURL(@Param("shortUrl") String shortUrl);
}
