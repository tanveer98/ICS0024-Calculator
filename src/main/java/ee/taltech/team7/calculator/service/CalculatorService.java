package ee.taltech.team7.calculator.service;

import ee.taltech.team7.calculator.dto.ResponseDTO;
import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.exceptions.NullParameterException;
import ee.taltech.team7.calculator.exceptions.OverflowedLongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalculatorService {
    @Autowired
    RequestService reqS;
    @Autowired
    ResponseService resS;

    private RequestEntity requestEntity;
    private ResponseEntity responseEntity;
    private long threshold = (long) Math.sqrt(Long.MAX_VALUE);
    private static long itemCount = 0;

    public ResponseDTO sanitize_and_calculate(List<Long> listOfParams) {

        Optional<RequestService> requestService = Optional.ofNullable(reqS);
        Optional<ResponseService> responseService = Optional.ofNullable(resS);
        if (requestService.isPresent()) {
            itemCount = requestService.get().count(); //get the latest item count from the repository.
            itemCount++;
        }
        List<Long> sortedVals; long min; long max;
        try{
            sortedVals = listOfParams.stream().sorted().collect(Collectors.toList());
            min = sortedVals.get(0);
            max = sortedVals.get(sortedVals.size() - 1);
        } catch (NullPointerException e) {
            throw new NullParameterException();
        }
        requestEntity = new RequestEntity(itemCount,min,max);
        calculate(requestEntity);
        if(requestService.isPresent() && requestService.get().isNotExisting(requestEntity)) {
            requestService.get().save(requestEntity);
            responseService.get().save(responseEntity);
        }
        Logger theLogger = LoggerFactory.getLogger("rollingFileLogger");
        theLogger.warn("Input values max {} min {}, output value {}" , max,min, responseEntity.getSquaredVal());
        return new ResponseDTO(responseEntity.getSquaredVal());
    }


    private void calculate(RequestEntity req) throws OverflowedLongException {
        long result = req.getMaxVal() - req.getMinval();

        if (is_overflowed(result)) {
            System.out.println("result: " + result + " will overflow when squared!");
            throw new OverflowedLongException("Result will overflow when squared!");
        }
        responseEntity = new ResponseEntity(itemCount, result * result);
    }

    private boolean is_overflowed(Long result) {
        if (result > 0)
            return result > threshold;
        else
            return result < -threshold;
    }
}
