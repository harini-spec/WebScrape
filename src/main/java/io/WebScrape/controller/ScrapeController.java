package io.WebScrape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.WebScrape.Service.ScrapeService;
import io.WebScrape.models.DataModel;

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
