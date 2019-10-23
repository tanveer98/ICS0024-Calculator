package ee.taltech.team7.calculator.controller;

import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.exceptions.ObjectNotFoundException;
import ee.taltech.team7.calculator.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>This class contains methods for showing all the request values
 * (or input values) for the calculator controller</p>
 */

@RestController
@RequestMapping("/logs/request")
public class RequestLogsController {
    @Autowired
    RequestService requestService;

    /**
     *
     * @return a list of RequestEntity Objects containing the values used for the calculation
     * (min and max) and the id.
     */
    @GetMapping()
    public List<RequestEntity> get_all_requests() {
        return requestService.get_all();
    }

    /**
     *
     * @param id is the id of the request object being retreieved
     * @return RequestEntity object, containing min-max values and id
     * @throws ObjectNotFoundException if the object is not found in the database
     */
    @GetMapping(path = "/{id}")
    public RequestEntity get_request_by_id(@PathVariable Long id) throws ObjectNotFoundException {
        return requestService.get_one_by_id(id);
    }


}
