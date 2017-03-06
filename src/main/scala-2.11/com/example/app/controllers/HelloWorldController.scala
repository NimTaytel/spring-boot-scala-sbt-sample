package com.example.app.controllers

import javax.annotation.PostConstruct
import javax.validation.Valid

import com.typesafe.scalalogging.slf4j.LazyLogging
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}


@RestController
@RequestMapping(Array("/helloworld"))
class HelloWorldController @Autowired() (val helloFormatter: HelloFormatter) extends LazyLogging {

  @Value("${hello.message}")
  var helloMessage: String = ""

  @RequestMapping(Array("/"))
  def sayHello(): String = helloMessage

  @RequestMapping(path = Array("/"), method = Array(RequestMethod.POST))
  def postHello(@RequestBody @Valid helloRequest: HelloRequest): ResponseEntity[String] = {

    logger.info("Received hello request {}", helloRequest)

    ResponseEntity.ok(helloFormatter.format(helloRequest))
  }
}
