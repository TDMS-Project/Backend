package com.blogs.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "delivery_person")
@PrimaryKeyJoinColumn(name = "user_ID")
public class DeliveryPerson extends User {
}