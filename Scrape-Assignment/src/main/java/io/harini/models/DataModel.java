package io.harini.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "defillama")
public class DataModel {
	
	@Id
	@Indexed(unique = true)
	private String id;
	private String Name;
	private List chains;
	private String _1dChange;
	private String _7dChange;
	private String _1mChange;
	private String tvl;
	private String McapTVL;
	private String borrowed;
	private String supplied;
	private String suppliedTvl;
	
	public DataModel() {}
	
	public DataModel(String name, String _1dChange, String _7dChange, String _1mChange, String tvl,
			String mcapTVL, String borrowed, String supplied, String suppliedTvl) {
		super();
		Name = name;
		this._1dChange = _1dChange;
		this._7dChange = _7dChange;
		this._1mChange = _1mChange;
		this.tvl = tvl;
		McapTVL = mcapTVL;
		this.borrowed = borrowed;
		this.supplied = supplied;
		this.suppliedTvl = suppliedTvl;
	}
	
	public List getChains() {
		return chains;
	}

	public void setChains(List chains) {
		this.chains = chains;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
		return tvl;
	}

	public void setTvl(String tvl) {
		this.tvl = tvl;
	}

	public String getMcapTVL() {
		return McapTVL;
	}

	public void setMcapTVL(String mcapTVL) {
		McapTVL = mcapTVL;
	}

	public String getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(String borrowed) {
		this.borrowed = borrowed;
	}

	public String getSupplied() {
		return supplied;
	}

	public void setSupplied(String supplied) {
		this.supplied = supplied;
	}

	public String getSuppliedTvl() {
		return suppliedTvl;
	}

	public void setSuppliedTvl(String suppliedTvl) {
		this.suppliedTvl = suppliedTvl;
	}
}
