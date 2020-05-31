package com.my;

import com.my.dto.AccessToken;
import com.my.utils.HttpClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpUtils;

@SpringBootTest
class PracticeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws Exception {

        AccessToken accessToken = new AccessToken();
        accessToken.setState("1");
        accessToken.setRedirect_uri("http://localhost:80/callback");
        accessToken.setClient_secret("636e21f1ec61ae48bf5d4ac954787874eaa29335");
        accessToken.setCode("88920d8419e6fb9e72af");
        accessToken.setClient_id("f26076fd69065020e891");

        String url = "https://github.com/login/oauth/access_token";

        String string = HttpClientUtils.get(url,HttpClientUtils.objectToMap(accessToken));
        System.out.println(string);

    }

}
