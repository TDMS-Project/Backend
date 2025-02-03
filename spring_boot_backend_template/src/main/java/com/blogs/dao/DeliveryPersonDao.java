package com.blogs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.DeliveryPerson;
import com.blogs.pojos.Vendor;

public interface DeliveryPersonDao extends JpaRepository<DeliveryPerson,Integer> {

	List<DeliveryPerson> findByRoleRoleID(int roleId);
	
}
