package com.m14SpringRestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m14SpringRestApi.entity.Shop;

public interface ShopDAO extends JpaRepository<Shop, Long> {

}
