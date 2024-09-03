package com.sessjr.demo_park_api.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration // define uma classe de configuração no Spring
public class SpringTimezoneConfig {

    @PostConstruct // faz com que após a classe ser inicializada o metodo seja executado
    public void timezoneConfig() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/São_Paulo"));
    }
}
