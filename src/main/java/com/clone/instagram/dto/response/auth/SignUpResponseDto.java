package com.clone.instagram.dto.response.auth;

import com.clone.instagram.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto extends ResponseDto{
    

    public SignUpResponseDto(String code, String message){
        super(code, message);
    }

    
    
}
