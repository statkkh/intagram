package com.clone.instagram.dto.request.auth;

// import lombok.AllArgsConstructor;
// import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Data
@NoArgsConstructor
public class SignUpRequestDto {
    
    @Size
    @NotBlank
    private String username;

	@NotBlank
	private String password;    

	@NotBlank
	private String email;

	@NotBlank
	private String name;    
}
