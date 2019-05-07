package me.tj3828;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tj3828
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)       // default = MOCK (가짜 Test용 servlet 환경), Port 지정 ( 실제 servlet 환경 )
@AutoConfigureMockMvc   // MockMvc 자동 주입
// @AutoConfigureWebTestClient // webFlux 기반일 때
@Import(TestConfig.class)
public class SampleControllerTest {

    // TestConfig 인스턴스에 접근하기 위해 static
    // @Configuration - Application에서 Main Config가 바뀌고 add형식이 아니기 때문에 Controller와 같은 빈 등록이 되지 않음.
    // 이너 클래스가 아닌 외부 클래스로 정의하기 위해서는 @Import 이용
   /* @TestConfiguration // Main Config에 add형식으로 빈 추가. 이너클래스일 경우에만 자동 빈등록.
    static class TestConfig {

        @Bean
        public String myBean() {
            return "myBean";
        }

    }*/

    // Random Port Num
    @LocalServerPort
    int port;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    String testConfig;

    @MockBean
    // @MockBean
    SampleService sampleService;

    @Test
    public void testFoo() throws Exception {
        System.out.println("port Num : " + port);
        assertThat(testConfig).isNotNull();

        assertThat(mockMvc).isNotNull();
        mockMvc.perform(get("/foo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"))
                .andDo(print());

    }

    /*@Test
    public void testFooWithWebTestClient() {
        webTestClient.get().uri("/foo").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello");
    }*/

    @Test
    public void testMockBean() {
        System.out.println(sampleService.getName());    // MockBean : Null, SpyBean : Remote Service

        given(sampleService.getName()).willReturn("Mock");
        assertThat(sampleService.getName()).isEqualTo("Mock");
    }

}
