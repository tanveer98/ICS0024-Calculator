package ee.taltech.team7.calculator.serviceTests.junitTest;

import ee.taltech.team7.calculator.exceptions.NullParameterException;
import ee.taltech.team7.calculator.exceptions.OverflowedLongException;
import ee.taltech.team7.calculator.service.CalculatorService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public  class CalculatorServiceTest {

    @Test(expected = NullParameterException.class)
    public void null_test(){
        var c = new CalculatorService();
        c.sanitize_and_calculate(null);
    }

    @Test(expected = NullParameterException.class)
    public void null_list_with_one_element() {
        var c = new CalculatorService();
        List<Long> n = new ArrayList<>();
        n.add(null);
        c.sanitize_and_calculate(n);

    }


    @Test(expected = NullParameterException.class)
    public void null_list_with_multiple_element() {
        var c = new CalculatorService();
        List<Long> n = new ArrayList<>();
        n.add(100L);
        n.add(null);
        n.add(-70L);
        c.sanitize_and_calculate(n);

    }

    @Test(expected = OverflowedLongException.class)
    public void check_Min(){
        var c = new CalculatorService();
        List<Long> numbers = new ArrayList<Long>();
        numbers.add((long)2);
        numbers.add((Long.MIN_VALUE));
        c.sanitize_and_calculate(numbers);
    }

    @Test(expected = OverflowedLongException.class)
    public void check_Max(){
        var c = new CalculatorService();
        List<Long> numbers = new ArrayList<Long>();
        numbers.add((long)-2);
        numbers.add((Long.MAX_VALUE));
        c.sanitize_and_calculate(numbers);
    }

}