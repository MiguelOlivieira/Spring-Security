package br.springSecurity.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String login;

    private String password;
}
