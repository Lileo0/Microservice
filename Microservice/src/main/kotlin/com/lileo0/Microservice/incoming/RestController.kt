package com.lileo0.Microservice.incoming

import com.lileo0.Microservice.domain.Request
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestController {
    @PostMapping("/calc")
    fun calculate(@RequestBody request: Request) : Float{
        return when(request.operation){
            "+" ->  request.number1+request.number2;
            "-" ->  request.number1-request.number2;
            ":" ->  request.number1/request.number2;
            "/" ->  request.number1/request.number2;
            "*" ->  request.number1/request.number2;
            "x" ->  request.number1/request.number2;
            else -> throw Exception("Unknown operation")
        }
    }
}