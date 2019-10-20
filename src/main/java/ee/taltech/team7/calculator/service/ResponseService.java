package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.exceptions.ObjectNotFoundException;
import ee.taltech.team7.calculator.repository.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ResponseService {
    @Autowired
    ResponseRepo responseRepo;
    
    public void save(ResponseEntity r) {
        responseRepo.save(r);
    }

    public List<ResponseEntity> get_all() {
        return responseRepo.findAll();
    }

    public ResponseEntity get_one_by_id(Long id) {
        return responseRepo.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

}
