package com.sessjr.demo_park_api.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSenhaDto {

    @NotBlank
    @Size(min = 6, max = 20)
    private String senhaAtual;

    @NotBlank
    @Size(min = 6, max = 20)
    private String novaSenha;

    @NotBlank
    @Size(min = 6, max = 20)
    private String confirmacaoSenha;
}
