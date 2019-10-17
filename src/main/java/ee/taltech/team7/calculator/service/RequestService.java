package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.entities.Request;
import ee.taltech.team7.calculator.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RequestService {
    @Autowired
    RequestRepo requestRepo;

    public void save(Request r) {
        requestRepo.save(r);
    }

    public boolean isNotExisting(Request r) {

        return requestRepo.findExisting(r.getMinval(), r.getMaxVal()) == 0L;
    }

    public Long count() {
        return requestRepo.count();
    }

    public List<Request> get_all() {
        return requestRepo.findAll();
    }

    public Request get_one_by_id(Long id) throws EntityNotFoundException {
        return requestRepo.findById(id).orElseThrow(EntityNotFoundException::new);
       //return requestRepo.getOne(id);

    }
}
