package com.example.main.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


import com.example.main.models.Example;

import com.example.main.services.WeatherService;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/")
    @CrossOrigin(origins = "https://omnify-lac.vercel.app")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("forecast/{city}")
    @CrossOrigin(origins = "https://omnify-lac.vercel.app")
    public Example getWeatherForFive(
            @PathVariable String city) throws ParseException {
        List<Example> res =  this.weatherService.getWeatherForFive(city);
        return res.get(0);
    }

    @RequestMapping("weather/{city}")
    @CrossOrigin(origins = "https://omnify-lac.vercel.app")
    public List<Example> getWeather(
            @PathVariable String city)throws ParseException {
        return this.weatherService.getWeather(city);
    }



}