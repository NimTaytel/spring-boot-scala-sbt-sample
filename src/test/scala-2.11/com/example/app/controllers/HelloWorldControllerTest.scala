package com.example.app.controllers

import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, ShouldMatchers}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.{HttpEntity, HttpHeaders, ResponseEntity}
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest extends FlatSpec with ShouldMatchers {

  @Autowired private[controllers] val restTemplate: TestRestTemplate = null

  @Test
  def if_say_hello_then_response_contains_hello(): Unit = {
    val response: ResponseEntity[String] = restTemplate.getForEntity("/helloworld/", classOf[String])

    assertTrue(response.getBody.contains("Hello"))
  }

  @Test
  def if_post_hello_then_response_status_is_200(): Unit = {

    val helloRequestJson =
      """
        |{
        | "hello_message": "Hello World",
        | "date": "2017-01-01"
        |}
      """.stripMargin

    val headers = new HttpHeaders()
    headers.set("Content-Type","application/json")

    val entity = new HttpEntity[String](helloRequestJson, headers)

    val response = restTemplate.postForEntity("/helloworld/", entity, classOf[String])

    assertTrue(200 == response.getStatusCode.value())
  }
}
