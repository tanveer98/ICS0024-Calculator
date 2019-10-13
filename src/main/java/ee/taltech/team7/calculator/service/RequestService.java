package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.entities.Request;
import ee.taltech.team7.calculator.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
