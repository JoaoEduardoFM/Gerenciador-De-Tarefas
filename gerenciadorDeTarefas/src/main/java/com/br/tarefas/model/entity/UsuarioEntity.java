package com.br.tarefas.model.entity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String nome;

    private String sobrenome;

    private String email; // Corrigido para 'email' com 'e' minúsculo

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Um usuário pode ter muitas tarefas
    @JoinColumn(name = "usuario") // Corrigido para 'usuario' com 'u' minúsculo
    private List<TarefaEntity> listaDeTarefas;
}
