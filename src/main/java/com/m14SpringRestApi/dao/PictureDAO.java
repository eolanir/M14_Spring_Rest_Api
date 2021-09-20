package com.m14SpringRestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m14SpringRestApi.entity.Picture;

public interface PictureDAO extends JpaRepository<Picture, Long>{

}
