package ee.taltech.team7.calculator.controller;


import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.exceptions.ObjectNotFoundException;
import ee.taltech.team7.calculator.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>This class contains methods for showing all the response values
 * (or output values) for the calculator controller</p>
 */

@RestController
@RequestMapping("/logs/response")
public class ResponseLogsController {
    @Autowired
    ResponseService responseService;

    /**
     *
     * @return a list of ResponseEntity Objects containing the calculated value and the id
     */
    @GetMapping()
    public List<ResponseEntity> get_all_requests() {
        return responseService.get_all();
    }

    /**
     *
     * @param id id of the response object being retrieved
     * @return a response object containg the result and it
     * @throws ObjectNotFoundException if that particular id is not present in the database
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity get_response_by_id(@PathVariable Long id) throws ObjectNotFoundException {
        return responseService.get_one_by_id(id);
    }

}
