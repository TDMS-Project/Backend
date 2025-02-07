package com.blogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dao.DeliveryPersonDao;
import com.blogs.dao.OrderDao;
import com.blogs.dao.UserDao;
import com.blogs.pojos.Customer;
import com.blogs.pojos.DeliveryPerson;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class DeliveryPersonServiceImpl implements DeliveryPersonService{
	@Autowired
	private OrderDao orderRepository;
	
	@Autowired
	private UserDao userRepository;
	
	@Autowired
	private DeliveryPersonDao dpRepository;
	
	public List<Order> getOrdersForDeliveryPerson(int deliveryPersonId) {
        return orderRepository.findByDeliveryPersonUserID(deliveryPersonId);
    }
	
	 public Order updateOrderStatus(Integer orderId, String status) {
	        Optional<Order> orderOptional = orderRepository.findById(orderId);
	        if (orderOptional.isPresent()) {
	            Order order = orderOptional.get();
	            order.setOrderStatus(status); // Update status
	            return orderRepository.save(order); // Save updated order
	        } else {
	            throw new RuntimeException("Order not found with ID: " + orderId);
	        }
	    }
	 
	 @Override
		public User updateDeliveryPersonProfile(Integer dpId, User updatedDeliveryPerson) {
			// TODO Auto-generated method stub
			Optional<User> optionalCustomer = userRepository.findById(dpId);

	        if (optionalCustomer.isPresent()) {
	            User existingCustomer = optionalCustomer.get();
	            existingCustomer.setEmail(updatedDeliveryPerson.getEmail());
	            existingCustomer.setPassword(updatedDeliveryPerson.getPassword());
	            existingCustomer.setContactNo(updatedDeliveryPerson.getContactNo());
	            existingCustomer.setAddress(updatedDeliveryPerson.getAddress());
	            existingCustomer.setFname(updatedDeliveryPerson.getFname());
	            existingCustomer.setLname(updatedDeliveryPerson.getLname());

	            return userRepository.save(existingCustomer);
	        } else {
	            throw new RuntimeException("Customer not found");
	        }
		}
	 @Override
	    public DeliveryPerson getDeliveryPersonById(int userId) {
	        return dpRepository.findById(userId).orElse(null);
	    }

	

	
}
