//package com.blogs.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.blogs.dao.UserDao;
//import com.blogs.pojos.User;
//
//
//
//@Service
//@Transactional
//public class CustomUserDetailsServiceImpl implements UserDetailsService {
////depcy
//	@Autowired
//	private UserDao userEntityRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		// invoke dao' s method
//		User userEntity = userEntityRepository.findByEmail(email)
//				.orElseThrow(() -> new UsernameNotFoundException("Email not found !!!!!"));
//		return new CustomUserDetailsImpl(userEntity);
//	}
//
//}
