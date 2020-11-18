package com.comit.repository;

import com.comit.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin(origins = "http://localhost:4200")
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
