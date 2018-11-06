package com.revature.fightAPI.controller;

import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.fightAPI.model.Results;
import com.revature.fightAPI.model.StarWars;

@RestController
@RequestMapping(value = "/get")
public class FightController {

	@GetMapping(value = "/winner")
	public ResponseEntity<Results> getWinner() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"); 
		String resourceURL= "https://swapi.co/api/people/";
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Results> swResponse = restTemplate.exchange(resourceURL, HttpMethod.GET, entity,
				Results.class);
		if (swResponse.getStatusCode() == HttpStatus.OK) {
			
			/*
			 for(StarWars starwars : swResponse.getBody()) { System.out.println(starwars.gender
			 + " " + starwars.name + " "); }
			*/
			
			Results sw = swResponse.getBody();
			System.out.println("next");
			System.out.println(sw.next);
			System.out.println("results");
			System.out.println(sw.results.get(0).name);
			System.out.println("rsult");
			System.out.println(sw.results.get(1).gender);


		
			System.out.println(swResponse);
			return swResponse;
			
			/*
			StarWars sw = swResponse.getBody();
			System.out.println("Name");
			System.out.println(sw.name);
			System.out.println("Gender");
			System.out.println(sw.gender);
			System.out.println("Film");
			System.out.println(sw.films[0]);
		
			System.out.println(swResponse);
			return swResponse;
			*/
			
		} else {
			System.out.println("ERR");
		}

		

		 

		return null;
	}

}