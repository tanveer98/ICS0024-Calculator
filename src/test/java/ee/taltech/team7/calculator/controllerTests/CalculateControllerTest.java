package ee.taltech.team7.calculator.controllerTests;

import ee.taltech.team7.calculator.controller.CalculateController;
import ee.taltech.team7.calculator.dto.ResponseDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateControllerTest {

    //TODO: write 3 unit test for the controller itself
    // 1. null input list gives 0 as answer
    // 2. Long.MIN + some other value throws exception
    // 3. Long.MAX + some other value throws exception
    // Tests for overflow/underflow of result.
    @Test
    public void null_test(){
        CalculateController c = new CalculateController();
        List<Long> numbers = new ArrayList<Long>();
        numbers.add((long)7);
        numbers.add((long)10);
        c.calculate_distance(numbers);

    }

    @Test
    public void check_Min(){
        CalculateController c = new CalculateController();
        List<Long> numbers = new ArrayList<Long>();
        numbers.add((long)0);
        numbers.add((Long.MIN_VALUE));
        c.calculate_distance(numbers);
    }

    @Test
    public void check_Max(){
        CalculateController c = new CalculateController();
        List<Long> numbers = new ArrayList<Long>();
        numbers.add((long)0);
        numbers.add((Long.MAX_VALUE));
        c.calculate_distance(numbers);
    }
}
