package com.lanqiao.music.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Configuration
public class DefaultConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @Bean
    public DateFormatter dateFormatter() {
        return new MyDateFormatter();
    }

    class MyDateFormatter extends DateFormatter{

        @Override
        public String print(Date date, Locale locale) {
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
    }
}
