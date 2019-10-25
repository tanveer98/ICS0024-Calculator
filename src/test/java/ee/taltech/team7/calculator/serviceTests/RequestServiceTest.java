package ee.taltech.team7.calculator.serviceTests;

import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.repository.RequestRepo;
import ee.taltech.team7.calculator.service.RequestService;
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

public class RequestServiceTest {

    @Autowired
    RequestService requestService;
    @MockBean
    RequestRepo requestRepo;

    @Test
    public void mock_is_not_existing() {
        Mockito.when(requestRepo.findExisting(0L,0L)).thenReturn(0L);

        boolean is_not_existing = requestService.isNotExisting(new RequestEntity(0L,0L));
        assertTrue(is_not_existing);

    }

}
