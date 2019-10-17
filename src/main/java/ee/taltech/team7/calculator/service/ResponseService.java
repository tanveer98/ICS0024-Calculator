package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.entities.Response;
import ee.taltech.team7.calculator.repository.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ResponseService {
    @Autowired
    ResponseRepo responseRepo;
    
    public void save(Response r) {
        responseRepo.save(r);
    }

    public List<Response> get_all() {
        return responseRepo.findAll();
    }

    public  Response get_one_by_id(Long id) {
        return responseRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
