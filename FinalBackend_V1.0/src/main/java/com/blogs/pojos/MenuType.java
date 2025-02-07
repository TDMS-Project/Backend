package com.blogs.pojos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "menu_type")
public class MenuType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuTypeID;
    private String name;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id") // This column will reference Vendor's primary key
    @JsonBackReference
    private Vendor vendor;
    
    
}