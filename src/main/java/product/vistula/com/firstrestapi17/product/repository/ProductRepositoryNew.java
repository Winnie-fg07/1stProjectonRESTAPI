package product.vistula.com.firstrestapi17.product.repository;

import org.springframework.stereotype.Repository;
import product.vistula.com.firstrestapi17.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepositoryNew extends JpaRepository<Product, Long> {
}
