package br.com.deroldo.passwordvalidator.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider
import springfox.documentation.swagger.web.SwaggerResource
import springfox.documentation.swagger.web.SwaggerResourcesProvider
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    @Primary
    fun swaggerResourcesProvider(
            defaultResourcesProvider: InMemorySwaggerResourcesProvider
    ) = SwaggerResourcesProvider {
        listOf(
                SwaggerResource().apply {
                    name = "Password-Validator"
                    swaggerVersion = "2.0"
                    location = "/password-validator-spec.yml"
                }
        )
    }
}