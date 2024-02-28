package com.clone.instagram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(length = 20, unique = true, nullable = false)
	private String username;

    @Column(nullable = false)
    private String password;

	@Column(nullable = false)
	private String name;
    
    private String website;

    private String bio;    

	@Column(nullable = false)
	private String email;    

	private String phone;

	private String gender;

	private String profileImageUrl; // 사진

	private String role; // 권한

	

}
