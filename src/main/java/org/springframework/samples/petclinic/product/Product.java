package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Product")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
   
    
    @NotNull
    @Size(min=3, max=50)
    String name;
    
    @NotNull
    @Min(0)
    double price;
    
    @ManyToOne
    @NotNull
    ProductType productType;
}
