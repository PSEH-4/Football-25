package com.sapient.league.resource

import com.sapient.league.service.LeagueProbeService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LeagueProbeResource {

    companion object {
        private val log = LoggerFactory.getLogger(LeagueProbeResource::class.java)
    }

    @Autowired
    private lateinit var leagueProbeService: LeagueProbeService


    @GetMapping("/standing")
    fun getLeagueStanding(@RequestParam("countryName") countryName: String,
                          @RequestParam("leagueName") leagueName: String,
                          @RequestParam("teamName") teamName: String) =
            leagueProbeService.getLeagueStanding(countryName, leagueName, teamName)

}