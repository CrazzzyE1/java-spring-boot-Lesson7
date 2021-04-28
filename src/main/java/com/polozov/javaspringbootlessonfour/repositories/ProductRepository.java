package com.polozov.javaspringbootlessonfour.repositories;

import com.polozov.javaspringbootlessonfour.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	List<Product> findProductByTitleLike(String title);
	List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max);
	List<Product> findProductByPriceBefore(BigDecimal price);
	List<Product> findProductByPriceAfter(BigDecimal price);
}
