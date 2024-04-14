package com.example.myproject.controllers;

import com.example.myproject.model.AirportFilter;
import com.example.myproject.repositories.AirportFilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportFilterController {

    @Autowired
    private AirportFilterRepository airportFilterRepository;

    @PostMapping("/api/v0/airports/filter")
    public List<Object> filterAirports(@RequestBody AirportFilter airportFilter, @RequestBody boolean countryAsRoot) {
        if (countryAsRoot) {
            return airportFilterRepository.formatResponseWithCountryAsRoot(airportFilter);
        } else {
            return airportFilterRepository.formatResponseWithAirportAsRoot(airportFilter);
        }
    }
}
