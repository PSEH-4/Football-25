package com.sapient.league.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class StandingsResponseDto (
        var countryId: String? = "",
        var countryName: String? = "",
        var leagueId: String? = "",
        var leageName: String? = "",
        var teamId: String? = "",
        var teamName: String? = "",
        var overallLeaguePosition: String? = ""
)