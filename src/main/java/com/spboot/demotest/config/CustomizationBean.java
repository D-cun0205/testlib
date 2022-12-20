package com.spboot.demotest.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean implements
        WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    // application.yaml 이용 하지 않고 properties 변경
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8081); // 포트

        factory.setContextPath("/cun"); // 서블릿 컨텍스트 경로

        factory.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
        factory.addErrorPages(new ErrorPage("/errorHaven"));
    }

}
