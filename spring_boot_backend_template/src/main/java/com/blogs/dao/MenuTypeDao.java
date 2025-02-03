package com.blogs.dao;

import com.blogs.pojos.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuTypeDao extends JpaRepository<MenuType, Integer> {
}
