package com.example.app

import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}

/**
  * Spring boot application configuration and servlet initializer.
  */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
class SpringBootScalaApplication {

    @Bean
    def servletContainer: JettyEmbeddedServletContainerFactory = new JettyEmbeddedServletContainerFactory()

    @Bean def scalaModule = DefaultScalaModule
}

object SpringBootScalaApplication extends App {
    SpringApplication run classOf[SpringBootScalaApplication]
}
