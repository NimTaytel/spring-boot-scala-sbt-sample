package com.example.app

import com.fasterxml.jackson.annotation.{JsonFormat, JsonProperty}
import org.hibernate.validator.constraints.NotBlank
import org.joda.time.DateTime


package object controllers {

    case class HelloRequest(@NotBlank @JsonProperty("hello_message") helloMessage:String,
                            @JsonProperty("date")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                            date: DateTime
                           )
}




