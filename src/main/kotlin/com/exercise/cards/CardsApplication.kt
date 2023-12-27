package com.exercise.cards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
class CardsApplication

fun main(args: Array<String>) {
	runApplication<CardsApplication>(*args)
}
