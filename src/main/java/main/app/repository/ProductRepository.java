package main.app.repository;

import main.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p WHERE p.product_name=:productName", nativeQuery = true)
    public List<Product> getProductDetailsByName(String productName);

    @Query(value = "SELECT * FROM product p WHERE p.product_name like %:productNameContains%", nativeQuery = true)
    public List<Product> getProductsContainsName(String productNameContains);

    @Query(value = "SELECT * FROM product p WHERE p.is_active_product=true", nativeQuery = true)
    public List<Product> getAllActiveProducts();

    @Query(value = "SELECT * FROM product p WHERE p.is_active_product=false", nativeQuery = true)
    public List<Product> getAllInActiveProducts();
}
