package com.blogs.pojos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vendor")
@PrimaryKeyJoinColumn(name = "user_ID")
public class Vendor extends User {
    private String businessName;
    private String businessAddress;
    
    @OneToMany(mappedBy = "vendor", cascade=CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonManagedReference("vendor-menuItems")
   List<MenuItems>menu=new ArrayList<>();
    
}