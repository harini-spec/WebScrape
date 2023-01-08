package io.harini.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.harini.models.DataModel;
import io.harini.repository.MongoRepo;

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
//	            String[] tags = table.getElementsByTag("a").text().split(" ");
	            Elements names = table.getElementsByClass("sc-10d3a64b-1 gVSZWp");
	            
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
	            
//	            for(int j=1;j<19;j++)
//	            	System.out.println(ar[j]);
//	            String[] tags = links.getElementsByTag("a");
//	            System.out.println(links);
//	            	sc-b3014eb9-1 fMnolV
//	            }
	            
//	            System.out.println(final_list);
	            
//	            for (int i = 1; i < 22; i++)
//	            { Element row = rows.get(i);
//	            	Elements cols = row.select("td");
////	            	System.out.println(cols.get(3).getElementsByTag("span").text());
//	            	}
	            
	           
	            
//	            for (int i = 1; i < rows.size(); i++) {
//	            	Element row = rows.get(i);
//	            	Elements cols = row.select("td");
//	            	System.out.println(cols);
	            
//	            Elements _1dChange = table.getElementsByTag("span");
	            
//	            for (Element val: _1dChange)
//	            	System.out.println(val.text());
	            
//	            Elements _7dChange = table.getElementsByClass("css-j5b1uy");
	            
//	            for (Element name: names)
//	            	System.out.println(name.text());
	            
//	            System.out.println(table.select("a").second());
	            
//	            To get links
//	            Elements chains = table.getElementsByClass("sc-b3014eb9-1 fMnolV");
//	            for (int i = 1; i < rows.size(); i++) {
//		            Element link = chains.select("a").get(i);
//		            System.out.println(i+" "+link.attr("href")+" ");
//		            }
	            
//	            String linkHref = chains.attr("href");
//	            for (Element chain: chains)
//	            	System.out.println(chain.attr("href"));
//	            	System.out.println(chain.text());
	            
	            
//	            for (String tag: tags)
//	            	System.out.println(tag);
	            
//	            String[] chains = table.getElementsByTag("a").text().split(" ");
//	            for (String chain: chains)
//	            	System.out.println(chain);
	            
//	            for (int i = 1; i < rows.size(); i++) { 
//	                Element row = rows.get(i);
//	                Elements cols = row.select("td");
//	                Elements elements = cols.getElementsByTag("a");
//	                System.out.println(cols);
//	                System.out.println(row.getElementsByTag("a"));
	                
	            }
	       catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    	return final_list;
	    }

}
