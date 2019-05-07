package me.tj3828;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author tj3828
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureRestDocs
public class SampleWebMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SampleService sampleService;    // @Service는 @WebMvcTest가 빈으로 등록하지 않기 때문에 MockBean으로 생성후 사용

    @Test
    public void testFoo() throws Exception {
        given(sampleService.getName()).willReturn("tj3828");

        mockMvc.perform(get("/foo"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("foo"))
                .andExpect(status().isOk())
                .andExpect(content().string("tj3828"));

    }

    @TestConfiguration
    static class ResultHandlerConfiguration {

        @Bean
        public RestDocumentationResultHandler restDocumentation() {
            return MockMvcRestDocumentation.document("{method-name}");
        }

    }

}
