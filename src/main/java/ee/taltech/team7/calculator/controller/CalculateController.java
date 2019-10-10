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
    public Long calculate_distance(@RequestParam(name = "values") List<Long> listOfParams) {
        List<Long> numbers = new ArrayList<>(listOfParams);
        numbers.sort(Long::compareTo);
        return calculate(numbers);
    }

    private Long calculate(List<Long> sortedValues) {
        Long min = sortedValues.get(0);
        Long max = sortedValues.get(sortedValues.size() - 1);
        Long result = max - min;
        return result * result;

    }
}
