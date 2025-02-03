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

@Data
@Entity
@Table(name = "menu_items")
@Getter
@Setter
public class MenuItems {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuItemID;
    private String name;
    private boolean availability;
    private String image;
    private float price;
    
    @ManyToOne
    @JoinColumn(name = "menuType_ID")
    @JsonBackReference("menuType-menuItems")
    private MenuType menuType;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id")  // Add this mapping
    @JsonBackReference("vendor-menuItems")
    private Vendor vendor;

	
   
    
}