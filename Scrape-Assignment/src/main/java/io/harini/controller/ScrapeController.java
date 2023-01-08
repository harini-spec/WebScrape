package io.harini.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.harini.models.DataModel;
import io.harini.service.ScrapeService;

@RestController
@RequestMapping(path = "/")
public class ScrapeController {
	
	@Autowired
	private ScrapeService scrapeService;
	
	@GetMapping()
    public ArrayList<DataModel> extractData() {
        return  scrapeService.extractData("https://defillama.com/protocols/lending");
    }
    
}
