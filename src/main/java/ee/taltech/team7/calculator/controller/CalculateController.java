package ee.taltech.team7.calculator.controller;

import ee.taltech.team7.calculator.entities.Request;
import ee.taltech.team7.calculator.entities.Response;
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

    private Request request;
    private Response response;
    static long itemCount = 0;


    @GetMapping
    public Long calculate_distance(@RequestParam(name = "v") List<Long> listOfParams) {
        itemCount = requestService.count(); //get the latest item count from the repository.
        itemCount++;

        if (listOfParams == null)
            return 0L;

        List<Long> sortedVals = new ArrayList<>(listOfParams);
        sortedVals.sort(Long::compareTo);
        Long min = sortedVals.get(0);
        Long max = sortedVals.get(sortedVals.size() - 1);
        request = new Request(itemCount,min,max);
        try {
            calculate(request);
        } catch (OverflowedLongException e) {
            return -1L;
        }

        if(requestService.isNotExisting(request)) {
            requestService.save(request);
            responseService.save(response);
        }


        return response.getSquaredVal();
    }

    private void calculate(Request req) throws OverflowedLongException {
        long result = req.getMaxVal() - req.getMinval();

        if (is_overflowed(result)) {
            System.out.println("result: " + result + " will overflow when squared!");
            throw new OverflowedLongException("Result will overflow when squared!");
        }
        response = new Response(itemCount,result * result);
        //response.getSquaredVal();
    }

    private boolean is_overflowed(Long result) {
        long threshold = (long) Math.sqrt(Long.MAX_VALUE);
        return result > threshold;
    }

}
