package com.comit.repository;

import com.comit.model.Order;
import com.comit.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200")
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("SELECT o FROM Order o WHERE o.user.id = ?1")
    List<Order> getOrdersByUserId(int id);

}
