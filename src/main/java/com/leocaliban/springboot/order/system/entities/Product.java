package com.leocaliban.springboot.order.system.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Getter	
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private Double price;

	private String imgUrl;

	@Setter(value = AccessLevel.NONE)
	@Singular
	@ManyToMany
	@JoinTable(
			  name = "tb_product_category", 
			  joinColumns = @JoinColumn(name = "product_id"), 
			  inverseJoinColumns = @JoinColumn(name = "category_id"))
	@JsonManagedReference
	private Set<Category> categories = new HashSet<>();

	@Builder
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public void removeCategory(Category category) {
		categories.remove(category);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
