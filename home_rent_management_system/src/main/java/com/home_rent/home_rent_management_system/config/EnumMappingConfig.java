package com.home_rent.home_rent_management_system.config;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class EnumMappingConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        ApplicationConversionService.configure(formatterRegistry);
    }
}
