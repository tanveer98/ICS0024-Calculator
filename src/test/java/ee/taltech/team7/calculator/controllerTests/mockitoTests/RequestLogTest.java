package ee.taltech.team7.calculator.controllerTests.mockitoTests;

import ee.taltech.team7.calculator.entities.RequestEntity;
import ee.taltech.team7.calculator.service.RequestService;
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

//mocked mvc tests for this controller
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc

public class RequestLogTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    RequestService requestService;

    @Test
    public void returns_one_mock() throws Exception {
        RequestEntity mockRequstEntity = new RequestEntity(0L,1L,2L);
        Mockito.when(requestService.get_one_by_id(0L)).thenReturn(mockRequstEntity);

        mockMvc.perform(get("/logs/request/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", CoreMatchers.equalTo(mockRequstEntity.getId().intValue())))
                .andExpect(jsonPath("minval", CoreMatchers.equalTo(mockRequstEntity.getMinval().intValue())))
                .andExpect(jsonPath("maxVal", CoreMatchers.equalTo(mockRequstEntity.getMaxVal().intValue())));
    }


}
