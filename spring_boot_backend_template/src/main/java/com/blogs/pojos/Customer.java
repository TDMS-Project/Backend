package com.blogs.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "user_ID")
public class Customer extends User {
}