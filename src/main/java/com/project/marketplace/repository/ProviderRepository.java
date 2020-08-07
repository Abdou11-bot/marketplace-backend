package com.project.marketplace.repository;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider,Long> {
    Provider findFirstByAdminEquals(boolean admin) ;
    Provider findFirstByEmailEquals(String mail) ;
}
