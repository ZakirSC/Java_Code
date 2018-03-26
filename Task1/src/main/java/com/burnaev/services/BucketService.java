package com.burnaev.services;


import com.burnaev.forms.AddToBucketForm;
import com.burnaev.models.Bucket;
import com.burnaev.models.User;

public interface BucketService {
    boolean hasUserBuckets(User user);

    Bucket findByUserIdAndProductId(Long userId, Long productId);

    void delete(Long bucketId);

    void save(AddToBucketForm form);
}
