package com.blogs.pojos;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;
    private String roleName;
}