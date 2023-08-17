package com.asacsm.Dockerizing.a.Spring.Boot.by.selene.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .components(Components())
        .info(apiInfo())

    private fun apiInfo() = Info()
            .title("Multi-container 통신 확인")
            .description("Swagger Ui를 이용해 통신 확인하기")
            .version("1.0.0")
}