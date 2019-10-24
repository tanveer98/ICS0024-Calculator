package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@CacheConfig(cacheNames={"Request"})
public class RequestService {
    @Autowired
    RequestRepo requestRepo;

    @CachePut(cacheNames = {"Request"})
    public void save(RequestEntity r) {
        requestRepo.save(r);
    }

    public boolean isNotExisting(RequestEntity r) {

        return requestRepo.findExisting(r.getMinval(), r.getMaxVal()) == 0L;
    }

    public Long count() {
        return requestRepo.count();
    }

    @Cacheable(cacheNames = {"Request"})
    public List<RequestEntity> get_all() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return requestRepo.findAll();
    }

    @Cacheable(cacheNames = {"Request"})
    public RequestEntity get_one_by_id(Long id) throws EntityNotFoundException {

        return requestRepo.findById(id).orElseThrow(EntityNotFoundException::new);
       //return requestRepo.getOne(id);

    }
}
