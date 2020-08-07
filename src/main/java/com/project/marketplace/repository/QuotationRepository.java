package com.project.marketplace.repository;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
    List<Quotation> findAllByProductEquals(Product product);

}
