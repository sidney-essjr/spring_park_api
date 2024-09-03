package com.sessjr.demo_park_api.web.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDto {

    private Long id;


    private String username;
    private String role;
}
