package com.burnaev.services;

import com.burnaev.forms.AddToBucketForm;
import com.burnaev.models.Bucket;
import com.burnaev.models.User;
import com.burnaev.repositories.BucketRepository;
import com.burnaev.repositories.CarRepository;
import com.burnaev.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BucketServiceImpl implements BucketService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BucketRepository bucketRepository;

    @Override
    public void save(AddToBucketForm form) {
        Bucket bucket = bucketRepository.findByUserIdAndCarId(form.getUserId(), form.getCarId());
        if (bucket != null) {
            bucket.setCount(bucket.getCount() + form.getCount());
            bucketRepository.save(bucket);
        } else {
            bucketRepository.save(Bucket.builder()
                    .user(usersRepository.findOne(form.getUserId()))
                    .car(carRepository.findOne(form.getCarId()))
                    .count(form.getCount())
                    .build());
        }
    }

    @Override
    public boolean hasUserBuckets(User user) {
        Optional<List<Bucket>> optional = bucketRepository.findByUserId(user.getId());
        if (optional.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public Bucket findByUserIdAndProductId(Long userId, Long carId) {
        return bucketRepository.findByUserIdAndCarId(userId, carId);
    }

    @Override
    public void delete(Long bucketId) {
        bucketRepository.delete(bucketId);
    }
}
