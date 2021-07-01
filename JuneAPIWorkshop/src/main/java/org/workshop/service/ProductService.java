package org.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.entity.Product;
import org.workshop.repos.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	//Post
	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	//Post
	public List<Product> saveProducts(List<Product> products) {
		return repo.saveAll(products);
	}

	//Get
	public List<Product> getProducts(){
		return repo.findAll();
	}

	//Get
	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);
	}

	//Get
	public Product getProductByName(String name) {
		return repo.findByName(name);
	}

	//Delete
	public String deleteProduct(int id) {
		repo.deleteById(id);
		return "Product removed sucessfully " + id;
	}

	//Update
	public Product updateProduct(Product product) {
		Product existingProduct = repo.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repo.save(existingProduct);
	}

}
