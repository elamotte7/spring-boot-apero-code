package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "BEER_TABLE")
public class Beer {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "beer_name")
	private String name;
	@Column(name = "beer_color")
	private String color;
	@Column(name = "tasted")
	private Boolean tasted;
	@Transient
	public int order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getTasted() {
		return tasted;
	}

	public void setTasted(Boolean tasted) {
		this.tasted = tasted;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
