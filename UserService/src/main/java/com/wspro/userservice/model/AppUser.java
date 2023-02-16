package com.wspro.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "firstname")

	private String firstName;
	@Column(unique = true)
	private String cin;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String phone;
	private String password;
}
