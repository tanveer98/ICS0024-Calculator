package ee.taltech.team7.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @GetMapping
    public Long calculate_distance(@RequestParam(name = "values") List<Long> listOfParams) throws Exception {
        if (listOfParams == null)
            return 0L;

        List<Long> numbers = new ArrayList<>(listOfParams);
        numbers.sort(Long::compareTo);
        return calculate(numbers);
    }

    private Long calculate(List<Long> sortedValues) throws Exception {
        Long min = sortedValues.get(0);
        Long max = sortedValues.get(sortedValues.size() - 1);
        long result = max - min;

        if (is_overflowed(result)) {
            System.out.println("result: " + result + " will overflow when squared!");
            //throw new Exception();
        }
        return result * result;

    }

    private boolean is_overflowed(Long result) throws Exception {
        long threshold = (long) Math.sqrt(Long.MAX_VALUE);
        return result > threshold;
    }

}
