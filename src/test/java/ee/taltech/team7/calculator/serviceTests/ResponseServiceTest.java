package ee.taltech.team7.calculator.serviceTests;

import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.exceptions.ObjectNotFoundException;
import ee.taltech.team7.calculator.repository.RequestRepo;
import ee.taltech.team7.calculator.repository.ResponseRepo;
import ee.taltech.team7.calculator.service.RequestService;
import ee.taltech.team7.calculator.service.ResponseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
//test for this service
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ResponseServiceTest {

    @Autowired
    ResponseService responseService;
    @MockBean
    ResponseRepo responseRepo;

    @Test(expected = ObjectNotFoundException.class)
    public void throw_exception() {
        Mockito.when(responseRepo.getOne(-1L)).thenThrow(new ObjectNotFoundException());

        responseService.get_one_by_id(-1L);
    }

}
