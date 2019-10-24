package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.exceptions.ObjectNotFoundException;
import ee.taltech.team7.calculator.repository.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(cacheNames={"Response"})
public class ResponseService {
    @Autowired
    ResponseRepo responseRepo;

    @CachePut
    public void save(ResponseEntity r) {
        responseRepo.save(r);
    }
    @Cacheable
    public List<ResponseEntity> get_all() {
        return responseRepo.findAll();
    }
    @Cacheable
    public ResponseEntity get_one_by_id(Long id) {
        return responseRepo.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

}
