package com.br.tggp.techselect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecrutadorRequest {

    @NotBlank
    @Email
    @Size(max = 100, message = "O email não pode ter mais que 100 caracteres.")
    private String email;

    @NotBlank
    @Size(max = 255, message = "A senha não pode ter mais que 255 caracteres.")
    private String senha;

    @NotBlank
    @Size(max = 100, message = "O nome da empresa não pode ter mais que 100 caracteres.")
    private String nomeEmpresa;

    @NotNull(message = "O arquivo do logo é obrigatório")
    private MultipartFile urlLogo;

    @NotBlank
    @Size(max = 100, message = "O nome completo não pode ter mais que 100 caracteres.")
    private String nomeCompleto;
}