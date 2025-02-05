//package com.blogs.security;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.blogs.pojos.User;  // Adjusted import for the User class
//
//public class CustomUserDetailsImpl implements UserDetails {
//    private User user;  // The User class you provided
//
//    public CustomUserDetailsImpl(User user) {
//        super();
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // Using roleName field from Role class for authority
//        return List.of(new SimpleGrantedAuthority(user.getRole().getRoleName()));  // Adjusted to 'getRoleName()'
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();  // Return the password from User POJO
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getEmail();  // Return the email as the username
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;  // Assuming the account is non-expired
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;  // Assuming the account is not locked
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;  // Assuming credentials are non-expired
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;  // Assuming the user is enabled
//    }
//
//    // This is a helper method to return the full user entity if needed
//    public User getUserEntity() {
//        return user;
//    }
//}
