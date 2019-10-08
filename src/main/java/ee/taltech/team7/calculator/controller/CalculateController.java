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
    public Integer calculate_distance(@RequestParam(name = "values") List<Integer> listOfParams) {
        List<Integer> numbers = new ArrayList<>(listOfParams);
        numbers.sort(Integer::compareTo);
        return calculate(numbers);
    }

    private Integer calculate(List<Integer> sortedValues) {
        Integer min = sortedValues.get(0);
        Integer max = sortedValues.get(sortedValues.size() - 1);
        Integer result = max - min;
        return result * result;

    }
}
