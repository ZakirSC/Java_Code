package com.burnaev.repositories;


import com.burnaev.models.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
    Optional<List<Bucket>> findByUserId(Long userId);
    List<Bucket> findAllByUserId(Long userId);
    Bucket findByUserIdAndCarId(Long userId, Long carId);

}
