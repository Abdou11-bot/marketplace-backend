package com.project.marketplace.repository;

import com.project.marketplace.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
//    Image findFirstByClientId(Long id);
//    void deleteAllByClientId(Long id);
//    Image findFirstBy(Long id);
}
