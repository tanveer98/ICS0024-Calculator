package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.entities.Response;
import ee.taltech.team7.calculator.repository.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    @Autowired
    ResponseRepo responseRepo;
    
    public void save(Response r) {
        responseRepo.save(r);
    }

}
