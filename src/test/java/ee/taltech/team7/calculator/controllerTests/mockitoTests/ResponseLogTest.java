package ee.taltech.team7.calculator.controllerTests.mockitoTests;


import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.entities.ResponseEntity;
import ee.taltech.team7.calculator.service.RequestService;
import ee.taltech.team7.calculator.service.ResponseService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc

public class ResponseLogTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ResponseService responseService;

    @Test
    public void returns_one_mock() throws Exception {
        ResponseEntity mockResponseEntity = new ResponseEntity(0L, -1L);
        Mockito.when(responseService.get_one_by_id(0L)).thenReturn(mockResponseEntity);

        mockMvc.perform(get("/logs/response/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", CoreMatchers.equalTo(mockResponseEntity.getId().intValue())))
                .andExpect(jsonPath("squaredVal", CoreMatchers.equalTo(mockResponseEntity.getSquaredVal().intValue())));

    }
}

