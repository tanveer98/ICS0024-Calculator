package ee.taltech.team7.calculator.controller;

import ee.taltech.team7.calculator.entities.Request;
import ee.taltech.team7.calculator.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/logs/requests/")
public class RequestLogsController {
    @Autowired
    RequestService requestService;

    @GetMapping()
    public List<Request> get_all_requests() {
        return requestService.get_all();
    }

    @GetMapping(path = "/{id}")
    public Request get_request_by_id(@PathVariable Long id) throws EntityNotFoundException {
        return requestService.get_one_by_id(id);
    }



}
