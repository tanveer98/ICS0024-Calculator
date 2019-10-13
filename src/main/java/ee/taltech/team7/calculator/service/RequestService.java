package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    @Autowired
    RequestRepo requestRepo;
}
