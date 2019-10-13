package ee.taltech.team7.calculator.controller;

import ee.taltech.team7.calculator.entities.Request;
import ee.taltech.team7.calculator.entities.Response;
import ee.taltech.team7.calculator.repository.RequestRepo;
import ee.taltech.team7.calculator.repository.ResponseRepo;
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
    RequestRepo requestRepo;
    @Autowired
    ResponseRepo responseRepo;

    private Request request;
    Response response;


    @GetMapping
    public Long calculate_distance(@RequestParam(name = "v") List<Long> listOfParams) throws Exception {
        if (listOfParams == null)
            return 0L;

        List<Long> sortedVals = new ArrayList<>(listOfParams);
        sortedVals.sort(Long::compareTo);
        Long min = sortedVals.get(0);
        Long max = sortedVals.get(sortedVals.size() - 1);
        request = new Request(min, max);

        return calculate(request);
    }

    private Long calculate(Request req) throws Exception {
        long result = req.getMaxVal() - req.getMinval();

        if (is_overflowed(result)) {
            System.out.println("result: " + result + " will overflow when squared!");
            //throw new Exception();
        }
        response = new Response(result * result);
        return response.getSquaredVal();
    }

    private boolean is_overflowed(Long result) {
        long threshold = (long) Math.sqrt(Long.MAX_VALUE);
        return result > threshold;
    }

}
