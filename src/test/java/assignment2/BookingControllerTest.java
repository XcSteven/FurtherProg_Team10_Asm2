package assignment2;
import assignment2.model.Booking;
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

public class BookingControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getBookingList() throws Exception {
        String uri = "/bookings";
        mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    public void getABookingById() throws Exception {
        String uri = "/bookings/";
        mvc.perform(MockMvcRequestBuilders.get(uri + 3)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", org.hamcrest.Matchers.is(3)));;
    }

    @Test
    public void addABooking() throws Exception {
        String uri = "/bookings";
        Booking booking = new Booking();
        booking.setStartLocation("Binh Thanh District");
        booking.setEndLocation("District 7");
        booking.setStartTime("18-05-2022");
        booking.setEndTime("19-05-2022");
        booking.setDistance(8.7);

        String inputJson = super.mapToJson(booking);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, booking.getId());
    }


}