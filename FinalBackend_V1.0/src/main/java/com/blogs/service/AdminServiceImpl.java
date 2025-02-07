package com.blogs.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dao.DeliveryPersonDao;
import com.blogs.dao.FeedBackDao;
import com.blogs.dao.OrderDao;
import com.blogs.dao.RoleDao;
import com.blogs.dao.UserDao;
import com.blogs.dao.VendorDao;
import com.blogs.pojos.Customer;
import com.blogs.pojos.DeliveryPerson;
import com.blogs.pojos.FeedBack;
import com.blogs.pojos.Order;
import com.blogs.pojos.Role;
import com.blogs.pojos.User;
import com.blogs.pojos.Vendor;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private VendorDao vendorRepository;

    @Autowired
    private DeliveryPersonDao deliveryPersonRepository;

    @Autowired
    private RoleDao roleRepository;
    
    @Autowired
    private UserDao userRepository;
    
    @Autowired
    private OrderDao orderRepository;
    
    @Autowired
    private FeedBackDao feedbackRepository;
    
    @Override
    public Vendor addVendor(Vendor vendor) {
    	
    	 Role vendorRole = roleRepository.findByRoleName("Vendor");
         
         
         if (vendorRole == null) {
             vendorRole = new Role();
             vendorRole.setRoleName("Vendor");
             vendorRole = roleRepository.save(vendorRole);  // Save the new role in the role table
         }
         vendor.setRole(vendorRole);
    	
        return vendorRepository.save(vendor);
    }

    
    @Override
    public DeliveryPerson addDeliveryPerson(DeliveryPerson dp) {
    	Role deliveryPersonRole = roleRepository.findByRoleName("DeliveryPerson");
        
       
        if (deliveryPersonRole == null) {
            deliveryPersonRole = new Role();
            deliveryPersonRole.setRoleName("DeliveryPerson");
            deliveryPersonRole = roleRepository.save(deliveryPersonRole);  // Save the new role in the role table
        }
        dp.setRole(deliveryPersonRole);
    	
        return deliveryPersonRepository.save(dp);
    }


	@Override
	public DeliveryPerson getDeliveryPersonById(int userId) {
		
		return deliveryPersonRepository.findById(userId).orElse(null);
	}


	@Override
	public Vendor getVendorById(int userId) {
		// TODO Auto-generated method stub
		return vendorRepository.findById(userId).orElse(null);
	}


	@Override
	public String deleteVendorById(int userId) {
		vendorRepository.deleteById(userId);
		return "vendor deleted successfully";
	}


	@Override
	public String deleteDeliveryPersonById(int userId) {
		deliveryPersonRepository.deleteById(userId);
		return "delivery Person deleted successfully";
	}


	@Override
	public List<Vendor> getAllVendors(int roleId) {
		// TODO Auto-generated method stub
		       return vendorRepository.findByRoleRoleID(roleId);
	}


	@Override
	public List<DeliveryPerson> getAllDeliveryPersons(int roleId) {
		// TODO Auto-generated method stub
		return deliveryPersonRepository.findByRoleRoleID(roleId);
	}


	@Override
	public User updateUser(Integer id, User admin) {
		// TODO Auto-generated method stub
		Optional<User> optionalAdmin = userRepository.findById(id);

        if (optionalAdmin.isPresent()) {
            User existingAdmin = optionalAdmin.get();
            existingAdmin.setEmail(admin.getEmail());
            existingAdmin.setPassword(admin.getPassword());
            existingAdmin.setContactNo(admin.getContactNo());
            existingAdmin.setAddress(admin.getAddress());
            existingAdmin.setFname(admin.getFname());
            existingAdmin.setLname(admin.getLname());


            return userRepository.save(existingAdmin);
        } else {
            throw new RuntimeException("Admin not found with id: " + id);
        }
    
	}


	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		 return orderRepository.findAll();
	}


	@Override
	public List<FeedBack> getFeedBacks() {
		// TODO Auto-generated method stub
		return feedbackRepository.findAll();
	}


	 public User getAdminById(Integer adminId) {
	        Optional<User> admin = userRepository.findById(adminId);
	        if (admin.isPresent() && admin.get().getRole().getRoleID() == 2) {
	            return admin.get();
	        } else {
	            throw new RuntimeException("Admin not found with id: " + adminId);
	        }
	    }


	 public Order assignOrderToDeliveryPerson(int orderId, int deliveryPersonId) {
	        // Fetch the order by orderId
	        Optional<Order> orderOptional = orderRepository.findById(orderId);
	        if (!orderOptional.isPresent()) {
	            throw new RuntimeException("Order not found with ID: " + orderId);
	        }

	        // Fetch the delivery person by deliveryPersonId
	        Optional<DeliveryPerson> deliveryPersonOptional = deliveryPersonRepository.findById(deliveryPersonId);
	        if (!deliveryPersonOptional.isPresent()) {
	            throw new RuntimeException("Delivery Person not found with ID: " + deliveryPersonId);
	        }

	        // Assign the delivery person to the order
	        Order order = orderOptional.get();
	        order.setDeliveryPerson(deliveryPersonOptional.get());
	        order.setOrderStatus("ASSIGNED"); // Change order status if needed

	        // Save the updated order
	        return orderRepository.save(order);
	    }


	
}
