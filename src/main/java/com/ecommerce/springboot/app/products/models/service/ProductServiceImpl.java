package com.ecommerce.springboot.app.products.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.springboot.app.products.models.dao.ProductDao;
import com.ecommerce.springboot.app.products.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductsService{
	
	@Autowired
	ProductDao productDao;

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

}
