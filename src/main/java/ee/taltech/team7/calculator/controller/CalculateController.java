package ee.taltech.team7.calculator.controller;

import ee.taltech.team7.calculator.dto.ResponseDTO;
import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.exceptions.NullParameterException;
import ee.taltech.team7.calculator.exceptions.OverflowedLongException;
import ee.taltech.team7.calculator.service.RequestService;
import ee.taltech.team7.calculator.service.ResponseService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This class contains the controller methods for processing http requests and
 * performing the calculation</p>
 */

@Slf4j
@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    RequestService requestService;
    @Autowired
    ResponseService responseService;

    private RequestEntity requestEntity;
    private ResponseEntity responseEntity;
    private long threshold = (long) Math.sqrt(Long.MAX_VALUE);
    private static long itemCount = 0;

    /**
     *
     * @param listOfParams takes in a list of Longs contained in the URL (as this controller trigged for a
     *                     get request)
     * @return ResposeDTO object, which is simply a wrapper around a Long value.
     * The Long value contains the result
     */
    @GetMapping
    public ResponseDTO calculate_distance(@RequestParam(name = "v") List<Long> listOfParams) {
        if(requestService != null) {
            itemCount = requestService.count(); //get the latest item count from the repository.
            itemCount++;
        }

        if (listOfParams == null || listOfParams.size() == 0)
            throw new NullParameterException(); //if no parameters were given throw an exception

        List<Long> sortedVals = new ArrayList<>(listOfParams);
        try{
            sortedVals.sort(Long::compareTo); //if there is any null value inside sort will throw an exception
            long n = sortedVals.get(0); //if there is only one object which is null
        } catch (NullPointerException e) {
            throw new NullParameterException();
        }

        Long min = sortedVals.get(0);
        Long max = sortedVals.get(sortedVals.size() - 1);
        requestEntity = new RequestEntity(itemCount,min,max);
        calculate(requestEntity);


        if(requestService != null && requestService.isNotExisting(requestEntity)) {
            requestService.save(requestEntity);
            responseService.save(responseEntity);
        }
        log.info("Input values max {} min {}, \t output value {}", max, min, responseEntity.getSquaredVal());
        return new ResponseDTO(responseEntity.getSquaredVal());
    }

    private void calculate(RequestEntity req) throws OverflowedLongException {
        long result = req.getMaxVal() - req.getMinval();

        if (is_overflowed(result)) {
            System.out.println("result: " + result + " will overflow when squared!");
            throw new OverflowedLongException("Result will overflow when squared!");
        }
        responseEntity = new ResponseEntity(itemCount,result * result);
    }

    private boolean is_overflowed(Long result) {
        if(result > 0)
            return result > threshold;
        else
            return result < -threshold;
    }

}
