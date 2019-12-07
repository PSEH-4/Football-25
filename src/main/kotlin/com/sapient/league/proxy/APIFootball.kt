package com.sapient.league.proxy

import com.sapient.league.model.StandingsResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "footballApi", url = "https://apiv2.apifootball.com")
interface APIFootball {

    @GetMapping("/")
    fun getData(@RequestParam("action") action: String,
                @RequestParam("APIkey") APIkey: String,
                @RequestParam("country_id", required = false) countryId: String? = null,
                @RequestParam("league_id", required = false) leagueId: String? = null): List<StandingsResponseDto>
}