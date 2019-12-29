package ee.taltech.team7.calculator.controller;

import ee.taltech.team7.calculator.dto.ResponseDTO;
import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.exceptions.OverflowedLongException;
import ee.taltech.team7.calculator.service.CalculatorService;
import ee.taltech.team7.calculator.service.RequestService;
import ee.taltech.team7.calculator.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>This class contains the controller methods for processing http requests and
 * performing the calculation</p>
 */

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    CalculatorService calculatorService;
    /**
     * @param listOfParams takes in a list of Longs contained in the URL (as this controller trigged for a
     *                     get request)
     * @return ResposeDTO object, which is simply a wrapper around a Long value.
     * The Long value contains the result
     */
    @GetMapping
    public ResponseDTO calculate_distance(@RequestParam(name = "v") List<Long> listOfParams) {

        ResponseDTO res;
        res = calculatorService.sanitize_and_calculate(listOfParams);
        return res;
    }

}
