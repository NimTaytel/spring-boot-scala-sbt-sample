package com.example.app.controllers

import java.text.MessageFormat

import org.springframework.boot.context.properties.{ConfigurationProperties, EnableConfigurationProperties}
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

import scala.beans.BeanProperty


@Configuration
@Component
@EnableConfigurationProperties
@ConfigurationProperties(locations = Array("classpath:app-config.properties"), prefix = "hello", ignoreUnknownFields = true)
class HelloFormatter {

  @BeanProperty
  var pattern: String = _

  def format(helloRequest: HelloRequest): String = {
    MessageFormat.format(pattern, helloRequest.date, helloRequest.helloMessage)
  }
}
