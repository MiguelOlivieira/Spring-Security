package br.springSecurity.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity

public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @Column(unique = true)
    private String login;

    @Setter
    @Getter
    private String password;


}
