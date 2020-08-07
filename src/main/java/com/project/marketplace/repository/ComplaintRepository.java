package com.project.marketplace.repository;

import com.project.marketplace.entity.Complaint;
import com.project.marketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    List<Complaint> findAllByProductEquals(Product product);
}
