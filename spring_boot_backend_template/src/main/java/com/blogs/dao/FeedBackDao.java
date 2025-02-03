package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.FeedBack;

public interface FeedBackDao extends JpaRepository<FeedBack,Integer> {

}
