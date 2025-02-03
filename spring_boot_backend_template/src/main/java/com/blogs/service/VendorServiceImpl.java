package com.blogs.service;

import com.blogs.dao.MenuItemsDao;
import com.blogs.dao.MenuTypeDao;
import com.blogs.dao.VendorDao;
import com.blogs.dtos.MenuItemsWithMenuType;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.MenuType;
import com.blogs.pojos.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private MenuItemsDao menuItemsRepository;

    @Autowired
    private VendorDao vendorRepository;

    @Autowired
    private MenuTypeDao menuTypeRepository;

    // ✅ Add a Menu Item and set Menu Type & Vendor
    @Override
    public MenuItems addMenuItem(MenuItemsWithMenuType menuItemDto, int vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor with ID " + vendorId + " not found"));

        // Check if the MenuType exists
        MenuType menuType = menuTypeRepository.findById(menuItemDto.getMenuType().getMenuTypeID())
                .orElseGet(() -> {
                    // Create a new MenuType if it doesn't exist
                    MenuType newMenuType = new MenuType();
                    newMenuType.setName(menuItemDto.getMenuType().getName());
                    newMenuType.setDescription(menuItemDto.getMenuType().getDescription());
                    newMenuType.setVendor(vendor);
                    return menuTypeRepository.save(newMenuType);
                });

        // Create MenuItems
        MenuItems menuItem = new MenuItems();
        menuItem.setName(menuItemDto.getName());
        menuItem.setAvailability(menuItemDto.isAvailability());
        menuItem.setImage(menuItemDto.getImage());
        menuItem.setPrice(menuItemDto.getPrice());
        menuItem.setMenuType(menuType);
        menuItem.setVendor(vendor);

        return menuItemsRepository.save(menuItem);
    }


    // ✅ Get all Menu Items by Vendor ID
    @Override
    public List<MenuItems> getMenuItemsByVendorId(int vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        return menuItemsRepository.findByVendor(vendor);
    }
}
