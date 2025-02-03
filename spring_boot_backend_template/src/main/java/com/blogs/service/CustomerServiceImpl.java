package com.blogs.service;

import com.blogs.dao.CustomerDao;
import com.blogs.dao.FeedBackDao;
import com.blogs.dao.MenuItemsDao;
import com.blogs.dao.OrderDao;
import com.blogs.dao.RoleDao; // Assuming you have a RoleDao for fetching roles
import com.blogs.dao.UserDao;
import com.blogs.dao.VendorDao;
import com.blogs.pojos.Customer;
import com.blogs.pojos.FeedBack;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.Order;
import com.blogs.pojos.OrderItems;
import com.blogs.pojos.Role;
import com.blogs.pojos.User;
import com.blogs.pojos.Vendor;
import com.blogs.service.CustomerService;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerRepository;

    @Autowired
    private RoleDao roleRepository; // Inject Role repository

    @Autowired
    private MenuItemsDao menu;
    
    @Autowired
    private UserDao userRepository;
    // Add new customer
    
    @Autowired
    private VendorDao vendorRepository;
    
    @Autowired
    private OrderDao orderRepository;
    
    @Autowired
    private FeedBackDao feedbackRepository;
    
    @Override
    public Customer addCustomer(Customer customer) {
        // Check if the 'Customer' role already exists
        Role customerRole = roleRepository.findByRoleName("Customer");
        
        // If the 'Customer' role does not exist, create it
        if (customerRole == null) {
            customerRole = new Role();
            customerRole.setRoleName("Customer");
            customerRole = roleRepository.save(customerRole);  // Save the new role in the role table
        }

        // Set the 'Customer' role to the customer object
        customer.setRole(customerRole);

        // Save the customer to the database
        return customerRepository.save(customer);
    }

    // Get customer by id
    @Override
    public Customer getCustomerById(int userId) {
        return customerRepository.findById(userId).orElse(null);
    }

	@Override
	public String deleteCustomerById(int userId) {
	       customerRepository.deleteById(userId);
		   return "Customer deleted Successfully";
	}

	@Override
	public List<MenuItems> getMenuItemsByVendorID(int vendorID) {
		return menu.findByMenuType_Vendor_userID(vendorID);
	}
	
	 public List<MenuItems> getMenuItemsByVendorId(int vendorId) {
	        return menu.findByVendorUserID(vendorId); // ✅ Fetch menu items by vendor ID
	    }

	 
	@Override
	public User updateCustomerProfile(Integer customerId, User updatedCustomer) {
		// TODO Auto-generated method stub
		Optional<User> optionalCustomer = userRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            User existingCustomer = optionalCustomer.get();
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPassword(updatedCustomer.getPassword());
            existingCustomer.setContactNo(updatedCustomer.getContactNo());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setFname(updatedCustomer.getFname());
            existingCustomer.setLname(updatedCustomer.getLname());

            return userRepository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }
	}
        //order placed code
        public Order placeOrder(int userId, int vendorId, List<OrderItems> items) {
            User customer = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            Vendor vendor = vendorRepository.findById(vendorId)
                    .orElseThrow(() -> new RuntimeException("Vendor not found"));

            Order newOrder = new Order();
            newOrder.setUser(customer);
            newOrder.setVendor(vendor);
            newOrder.setOrderDate(LocalDateTime.now());
            newOrder.setOrderStatus("PENDING");
            newOrder.setOrderItems(items);

            // Link order items to this order
            for (OrderItems item : items) {
                item.setOrder(newOrder);
            }

            return orderRepository.save(newOrder);
        }
        
        public List<Order> getOrdersForCustomer(int userID) {
            return orderRepository.findByUserUserID(userID);
        }

		@Override
		public String addFeedBack(FeedBack feedback) {
			 feedbackRepository.save(feedback) ;
			 return "Thank you for your feedback!";
		}
        

}
        
        
		
	

