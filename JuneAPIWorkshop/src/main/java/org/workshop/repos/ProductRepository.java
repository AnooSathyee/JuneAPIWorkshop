package org.workshop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
