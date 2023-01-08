package io.WebScrape.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "defillama")
public class DataModel {
	
	private String Name;
	private List Chains;
	private String _1dChange;
	private String _7dChange;
	private String _1mChange;
	private String Tvl;
	private String McapTVL;
	private String Borrowed;
	private String Supplied;
	private String SuppliedTvl;
	
	public DataModel() {}
	
	public DataModel(String name, List chains, String _1dChange, String _7dChange, String _1mChange, String tvl,
			String mcapTVL, String borrowed, String supplied, String suppliedTvl) {
		super();
		Name = name;
		Chains = chains;
		this._1dChange = _1dChange;
		this._7dChange = _7dChange;
		this._1mChange = _1mChange;
		Tvl = tvl;
		McapTVL = mcapTVL;
		Borrowed = borrowed;
		Supplied = supplied;
		SuppliedTvl = suppliedTvl;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List getChains() {
		return Chains;
	}
	public void setChains(List chains) {
		Chains = chains;
	}
	public String get_1dChange() {
		return _1dChange;
	}
	public void set_1dChange(String _1dChange) {
		this._1dChange = _1dChange;
	}
	public String get_7dChange() {
		return _7dChange;
	}
	public void set_7dChange(String _7dChange) {
		this._7dChange = _7dChange;
	}
	public String get_1mChange() {
		return _1mChange;
	}
	public void set_1mChange(String _1mChange) {
		this._1mChange = _1mChange;
	}
	public String getTvl() {
		return Tvl;
	}
	public void setTvl(String tvl) {
		Tvl = tvl;
	}
	public String getMcapTVL() {
		return McapTVL;
	}
	public void setMcapTVL(String mcapTVL) {
		McapTVL = mcapTVL;
	}
	public String getBorrowed() {
		return Borrowed;
	}
	public void setBorrowed(String borrowed) {
		Borrowed = borrowed;
	}
	public String getSupplied() {
		return Supplied;
	}
	public void setSupplied(String supplied) {
		Supplied = supplied;
	}
	public String getSuppliedTvl() {
		return SuppliedTvl;
	}
	public void setSuppliedTvl(String suppliedTvl) {
		SuppliedTvl = suppliedTvl;
	}

	
}
