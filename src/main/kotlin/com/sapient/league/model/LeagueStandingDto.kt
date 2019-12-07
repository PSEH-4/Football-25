package com.sapient.league.model

data class LeagueStandingDto (
        var countryId: String,
        var countryName: String,
        var leagueId: String,
        var leagueName: String,
        var teamId: String,
        var teamName: String,
        var position: String
)