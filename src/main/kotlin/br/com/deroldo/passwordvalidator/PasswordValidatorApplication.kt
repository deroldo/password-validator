package br.com.deroldo.passwordvalidator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PasswordValidatorApplication

fun main(args: Array<String>) {
    runApplication<PasswordValidatorApplication>(*args)
}
