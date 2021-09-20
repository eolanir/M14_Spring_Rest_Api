package com.m14SpringRestApi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m14SpringRestApi.dao.PictureDAO;
import com.m14SpringRestApi.dao.ShopDAO;
import com.m14SpringRestApi.entity.Picture;
import com.m14SpringRestApi.entity.Shop;

@RestController
@RequestMapping("/shops")
public class ControllerRest {
	
	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private PictureDAO pictureDAO;
	
	@GetMapping
	public ResponseEntity<List<Shop>> getShops(){
		List<Shop> shops = shopDAO.findAll();
		return ResponseEntity.ok(shops);
	}
	
	@RequestMapping(value="{shopId}")
	public ResponseEntity<Shop> getShopById(@PathVariable("shopId") Long shopId){
		Optional<Shop> optionalShop = shopDAO.findById(shopId);
		if(optionalShop.isPresent()) {
			return ResponseEntity.ok(optionalShop.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Shop> postShop(@RequestBody Shop shop){
		Shop newShop = shopDAO.save(shop);
		return ResponseEntity.ok(newShop);
	}
	
	@PostMapping("/picture")
	public ResponseEntity<Picture> postPicture(@RequestBody Picture picture){
		Picture newPicture = pictureDAO.save(picture);
		return ResponseEntity.ok(newPicture);
	}
	
	@RequestMapping(value="{shopId}/pictures")
	public ResponseEntity<List<Picture>> getPictureByShopId(@PathVariable("shopId") Long shopId){
		List<Picture> pictures = pictureDAO.findAll().stream().filter(i -> i.getShopId()==shopId).collect(Collectors.toList());
		return ResponseEntity.ok(pictures);
	}
	
	@DeleteMapping(value="{shopId}/pictures")
	public ResponseEntity<Void> burnPictures(@PathVariable("shopId") Long shopId) {
		List<Picture> pictures = pictureDAO.findAll().stream().filter(i -> i.getShopId()==shopId).collect(Collectors.toList());
		pictureDAO.deleteAll(pictures);
		return ResponseEntity.ok(null);
	}

}
