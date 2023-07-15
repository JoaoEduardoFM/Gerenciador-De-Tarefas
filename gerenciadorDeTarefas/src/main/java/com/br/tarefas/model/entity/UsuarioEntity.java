package com.br.tarefas.model.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "Id usuário", required = true)
    private BigInteger id;

    @NotNull(message ="O nome não pode ser nulo.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "O nome deve conter apenas letras maiúsculas e minúsculas.")
    @ApiModelProperty(example = "Fulano",value = "nome", required = true)
    private String nome;

    @NotNull(message ="O sobrenome não pode ser nulo.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "O nome deve conter apenas letras maiúsculas e minúsculas.")
    @ApiModelProperty(example = "ciclano", value = "sobrenome", required = false)
    private String sobrenome;

    @Email(message = "E-mail inválido.")
    @ApiModelProperty(example = "example@teste.com",value = "email", required = false)
    private String email;

    @ApiModelProperty(required = false, value = "Lista de endereco do Contato")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Um usuário pode ter muitas tarefas
    @JoinColumn(name = "usuario")
    private List<TarefaEntity> listaDeTarefas;
}
