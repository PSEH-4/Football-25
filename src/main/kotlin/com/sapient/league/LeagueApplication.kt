package com.sapient.league

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class LeagueApplication

fun main(args: Array<String>) {
	runApplication<LeagueApplication>(*args)
}
