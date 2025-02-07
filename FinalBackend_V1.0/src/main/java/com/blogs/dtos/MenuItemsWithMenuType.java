package com.blogs.dtos;

import com.blogs.pojos.MenuType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemsWithMenuType {
	    private String name;
	    private boolean availability;
	    private String image;
	    private String description;
	    private float price;
	    private MenuType menuType;  // Contains MenuType info
	    
}
