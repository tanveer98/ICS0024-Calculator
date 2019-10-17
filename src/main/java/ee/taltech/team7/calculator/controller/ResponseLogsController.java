package ee.taltech.team7.calculator.controller;


import ee.taltech.team7.calculator.entities.Response;
import ee.taltech.team7.calculator.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/logs/response/")
public class ResponseLogsController {
    @Autowired
    ResponseService responseService;

    @GetMapping()
    public List<Response> get_all_requests() {
        return responseService.get_all();
    }

    @GetMapping(path = "/{id}")
    public Response get_response_by_id(@PathVariable Long id) throws EntityNotFoundException {
        return responseService.get_one_by_id(id);
    }

}
