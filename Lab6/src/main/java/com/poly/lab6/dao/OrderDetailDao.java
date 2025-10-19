package com.poly.lab6.dao;

import com.poly.lab6.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM OrderDetail od WHERE od.product.id = :productId")
    void deleteByProductId(Integer productId);
}

