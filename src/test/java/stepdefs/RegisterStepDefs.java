package stepdefs;

import com.comit.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class RegisterStepDefs {

    @Autowired
    private MockMvc mvc;
    ResultActions action;

    @Given("^comit app register page$")
    public void comit_app_register_page() throws Exception {
    }

    //([^"]*)
    @When("^the user fill register form, User object is posted$")
    public void theUserFillRegisterFormObjectIsPosted(User user) throws Throwable {
        mvc.perform( MockMvcRequestBuilders
                .post("http://localhost:8080/register")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("^Registration process should be successful$")
    public void registration_process_should_be_successful() throws Exception {
        action.andExpect(status().is(200));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
