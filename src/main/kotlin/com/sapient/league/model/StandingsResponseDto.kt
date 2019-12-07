package com.sapient.league.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class StandingsResponseDto (
        var country_id: String? = "",
        var country_name: String? = "",
        var league_id: String? = "",
        var league_name: String? = "",
        var team_id: String? = "",
        var team_name: String? = "",
        var overall_league_position: String? = ""
)