package com.project.marketplace.repository;

import com.project.marketplace.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  {
    boolean addProvider(Provider provider);
    boolean blockProduct(long product, long provider);
    boolean blockProvider(long provider);
    boolean addSpeciality(Speciality speciality);
    boolean deleteSpeciality(long id);
}
