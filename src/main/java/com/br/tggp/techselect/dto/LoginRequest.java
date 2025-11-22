package com.br.tggp.techselect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank
    @Email
    @Size(max = 100, message = "O email não pode ter mais que 100 caracteres.")
    private String email;

    @NotBlank
    @Size(max = 255, message = "A senha não pode ter mais que 255 caracteres.")
    private String senha;
}
