package com.example.demo.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc; // <1>

    @MockBean
    private AccountService accountService; // <2>

    @Test
    public void getUserAccountsShouldReturnAccounts() throws Exception {
        String content = "[{\"username\": \"user\", \"accountNumber\": \"123456789\"}]";

        // <3>
        given(this.accountService.getUserAccounts())
                .willReturn(singletonList(new Account("user", "123456789")));

        // <4>
        this.mvc.perform(get("/v1/accounts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json(content));
    }
}
