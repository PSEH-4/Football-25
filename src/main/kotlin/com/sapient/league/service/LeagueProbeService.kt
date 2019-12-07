package com.sapient.league.service

import com.sapient.league.model.LeagueStandingDto
import com.sapient.league.proxy.APIFootball
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LeagueProbeService {

    companion object {
        private val log = LoggerFactory.getLogger(LeagueProbeService::class.java)
        private val APIkey = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978"
        private val GET_COUNTRIES_ACTION = "get_countries"
        private val GET_LEAGUES_ACTION = "get_leagues"
        private val GET_STANDINGS_ACTION = "get_standings"
    }

    @Autowired
    private lateinit var apiFootball: APIFootball

    fun getLeagueStanding(countryName: String, leagueName: String, teamName: String): LeagueStandingDto{
        log.info("Trying to get league standings for $countryName : $leagueName : $teamName")

        val countries = apiFootball.getData(GET_COUNTRIES_ACTION, APIkey)
        val country = countries.filter { it.country_name?.toLowerCase() == countryName.toLowerCase()}

        if (country.isNullOrEmpty()) throw Exception("$countryName records are not present")

        var leagues = apiFootball.getData(GET_LEAGUES_ACTION, APIkey, countryId = country[0].country_id)
        val league = leagues.filter { it.league_name?.toLowerCase() == leagueName.toLowerCase() }

        if (league.isNullOrEmpty()) throw Exception("$leagueName records are not present")

        val standings = apiFootball.getData(GET_STANDINGS_ACTION, APIkey, leagueId = league[0].league_id)
        val standing = standings.filter{ it.team_name?.toLowerCase() == teamName.toLowerCase()}

        if (standing.isNullOrEmpty()) throw Exception("$leagueName does not have a standing")

        return LeagueStandingDto(standing[0].country_id!!, standing[0].country_name!!, standing[0].league_id!!,
                standing[0].league_name!!, standing[0].team_id!!,
                standing[0].team_name!!, standing[0].overallLeaguePosition!!)
    }
}