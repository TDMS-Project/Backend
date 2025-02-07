package com.blogs.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Vendor;


public interface VendorDao extends JpaRepository<Vendor, Integer> {
	
	List<Vendor> findByRoleRoleID(Integer id);
	
	Optional<Vendor> findById(int vendorId);
	
}
