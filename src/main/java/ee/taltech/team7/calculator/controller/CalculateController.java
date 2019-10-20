package ee.taltech.team7.calculator.controller;

import ee.taltech.team7.calculator.dto.ResponseDTO;
import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.exceptions.OverflowedLongException;
import ee.taltech.team7.calculator.service.RequestService;
import ee.taltech.team7.calculator.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/calculate")
public class CalculateController {
    @Autowired
    RequestService requestService;
    @Autowired
    ResponseService responseService;

    private RequestEntity requestEntity;
    private ResponseEntity responseEntity;
    static long itemCount = 0;


    /* GET REQUEST */
    @GetMapping
    public ResponseDTO calculate_distance(@RequestParam(name = "v") List<Long> listOfParams) {
        if(requestService != null) {
            itemCount = requestService.count(); //get the latest item count from the repository.
            itemCount++;
        }

        if (listOfParams == null)
            return new ResponseDTO(0L);

        List<Long> sortedVals = new ArrayList<>(listOfParams);
        sortedVals.sort(Long::compareTo);

        Long min = sortedVals.get(0);
        Long max = sortedVals.get(sortedVals.size() - 1);

        requestEntity = new RequestEntity(itemCount,min,max);
        try {
            calculate(requestEntity);
        } catch (OverflowedLongException e) {
            return new ResponseDTO(-1L);
        }

        if(requestService.isNotExisting(requestEntity)) {
            requestService.save(requestEntity);
            responseService.save(responseEntity);
        }


        return new ResponseDTO(responseEntity.getSquaredVal());
    }

    private void calculate(RequestEntity req) throws OverflowedLongException {
        long result = req.getMaxVal() - req.getMinval();

        if (is_overflowed(result)) {
            System.out.println("result: " + result + " will overflow when squared!");
            throw new OverflowedLongException("Result will overflow when squared!");
        }
        responseEntity = new ResponseEntity(itemCount,result * result);
        //response.getSquaredVal();
    }

    private boolean is_overflowed(Long result) {
        long threshold = (long) Math.sqrt(Long.MAX_VALUE);
        return result > threshold;
    }
}
