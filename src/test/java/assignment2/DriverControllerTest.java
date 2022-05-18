package assignment2;
import assignment2.model.Driver;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DriverControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getDriverList() throws Exception {
        String uri = "/drivers";
        mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(7)));
    }

    @Test
    public void getADriverById() throws Exception {
        String uri = "/drivers/";
        mvc.perform(MockMvcRequestBuilders.get(uri + 3)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", org.hamcrest.Matchers.is(3)));;
    }

    @Test
    public void addADriver() throws Exception {
        String uri = "/drivers";
        Driver driver = new Driver();
        driver.setLicense("TESTLICENSE");
        driver.setPhone("0192929292");
        driver.setRating(3);

        String inputJson = super.mapToJson(driver);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, driver.getId());
    }

    
}