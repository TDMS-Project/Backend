package com.blogs.service;

import com.blogs.dao.MenuItemsDao;
import com.blogs.dao.MenuTypeDao;
import com.blogs.dao.OrderDao;
import com.blogs.dao.UserDao;
import com.blogs.dao.VendorDao;
import com.blogs.dtos.MenuItemsWithMenuType;
import com.blogs.dtos.OrdersResponseDtos;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.MenuType;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;
import com.blogs.pojos.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private MenuItemsDao menuItemsRepository;

    @Autowired
    private VendorDao vendorRepository;

    @Autowired
    private OrderDao orderRepository;
    
    @Autowired
    private MenuTypeDao menuTypeRepository;
    
    @Autowired
    private UserDao userRepository;

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

    @Override
	public List<Vendor> getAllVendors(int roleId) {
		// TODO Auto-generated method stub
		       return vendorRepository.findByRoleRoleID(roleId);
	}


	@Override
	public List<Order> getAllOrders(int vendorId) {
		// TODO Auto-generated method stub
		return orderRepository.findByVendorUserID(vendorId);
	}


	@Override
	public Vendor getVendorById(int vendorId) {
		// TODO Auto-generated method stub
		  return vendorRepository.findById(vendorId).orElse(null);
	}

	@Override
	public User updateVendorProfile(Integer vendorId, User updatedVendor) {
		// TODO Auto-generated method stub
		Optional<User> optionalCustomer = userRepository.findById(vendorId);

        if (optionalCustomer.isPresent()) {
            User existingCustomer = optionalCustomer.get();
            existingCustomer.setEmail(updatedVendor.getEmail());
            existingCustomer.setPassword(updatedVendor.getPassword());
            existingCustomer.setContactNo(updatedVendor.getContactNo());
            existingCustomer.setAddress(updatedVendor.getAddress());
            existingCustomer.setFname(updatedVendor.getFname());
            existingCustomer.setLname(updatedVendor.getLname());

            return userRepository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }
	}

	
   
    
	
}
