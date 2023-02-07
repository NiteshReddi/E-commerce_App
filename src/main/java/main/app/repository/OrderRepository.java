package main.app.repository;

import main.app.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select order_id,customer_id from orders where customer_id=:customerId",nativeQuery = true)
    public List<Object> findByCustomerId(Long customerId);

}
