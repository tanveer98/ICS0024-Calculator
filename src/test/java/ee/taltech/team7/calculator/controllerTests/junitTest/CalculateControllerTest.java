package ee.taltech.team7.calculator.controllerTests.junitTest;

import ee.taltech.team7.calculator.controller.CalculateController;
import ee.taltech.team7.calculator.exceptions.NullParameterException;
import ee.taltech.team7.calculator.exceptions.OverflowedLongException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateControllerTest {

    @Test(expected = NullParameterException.class)
    public void null_test(){
        CalculateController c = new CalculateController();
        c.calculate_distance(null);
    }

    @Test(expected = NullParameterException.class)
    public void null_list_with_one_element() {
        CalculateController c = new CalculateController();
        List<Long> n = new ArrayList<>();
        n.add(null);
        c.calculate_distance(n);

    }


    @Test(expected = NullParameterException.class)
    public void null_list_with_multiple_element() {
        CalculateController c = new CalculateController();
        List<Long> n = new ArrayList<>();
        n.add(100L);
        n.add(null);
        n.add(-70L);
        c.calculate_distance(n);

    }

    @Test(expected = OverflowedLongException.class)
    public void check_Min(){
        CalculateController c = new CalculateController();
        List<Long> numbers = new ArrayList<Long>();
        numbers.add((long)2);
        numbers.add((Long.MIN_VALUE));
        c.calculate_distance(numbers);
    }

    @Test(expected = OverflowedLongException.class)
    public void check_Max(){
        CalculateController c = new CalculateController();
        List<Long> numbers = new ArrayList<Long>();
        numbers.add((long)-2);
        numbers.add((Long.MAX_VALUE));
        c.calculate_distance(numbers);
    }

}
