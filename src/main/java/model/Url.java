package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Url {

	@Id
	@GeneratedValue
	private Long id;
	private String alias;
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", alias=" + alias + ", url=" + url + "]";
	}

	public Url(Long id, String alias, String url) {
		super();
		this.id = id;
		this.alias = alias;
		this.url = url;
	}

	
	
}
