package com.mazhar.urlshortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazhar.urlshortner.model.ClickEventModel;

public interface ClickEventRepository extends JpaRepository<ClickEventModel, Long>{

}
