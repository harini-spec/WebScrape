package io.WebScrape.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.WebScrape.Repository.MongoRepo;
import io.WebScrape.models.DataModel;

@Service
public class ScrapeService {
	
	@Autowired
	private MongoRepo mongoRepo;
	    
	    public ArrayList<DataModel> extractData(String url) {
	    	ArrayList<DataModel> final_list = new ArrayList<>();
	    	try {
	            Document document = Jsoup.connect(url).get();
	            
	            Element table = document.select("table").get(0);
	            Elements rows = table.select("tr");
	            Elements names = table.getElementsByClass("sc-10d3a64b-1 gVSZWp");
	            
	            // To get the all the chains
	            List[] ar = new List[19];
	            Elements links = table.getElementsByClass("sc-b3014eb9-1 fMnolV");
	            int j = 1;
	            for(Element link:links) {
	            	List<String> chain = new ArrayList<>();
	            	Elements anchors = link.getElementsByTag("a");
	            	for(Element anchor:anchors) {
	            		try {
	            		chain.add(anchor.attr("href").split("/")[2]);
	            		}
	            		catch(Exception e) {
	            			System.out.println(e);
	            		}
	            	}
	            	ar[j]=chain;
	            	j++;
	            	if(j>18)
	            		break;
	            }
	            
	            for (int i = 1; i < 19; i++)
	            { 
	            	DataModel dataModel = new DataModel();
	            	Element row = rows.get(i);
	            	Elements cols = row.select("td");
	            	dataModel.setName(names.get(i).text());
	            	dataModel.setChains(ar[i]);
	            	dataModel.set_1dChange(cols.get(2).getElementsByTag("span").text());
	            	dataModel.set_7dChange(cols.get(3).getElementsByTag("span").text());
	            	dataModel.set_1mChange(cols.get(4).getElementsByTag("span").text());
	            	dataModel.setTvl(cols.get(5).getElementsByTag("span").get(0).text());
	            	dataModel.setMcapTVL(cols.get(6).text());
	            	dataModel.setBorrowed(cols.get(7).text());
	            	dataModel.setSupplied(cols.get(8).text());
	            	dataModel.setSuppliedTvl(cols.get(9).text());
	            	mongoRepo.save(dataModel);
	            	final_list.add(dataModel);
	            	}
	                
	            }
	       catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    	return final_list;
	    }

}

