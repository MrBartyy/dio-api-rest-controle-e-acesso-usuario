package com.digitalinnovationone.live.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Empresa {
    @Id
    @GeneratedValue
    private Long id;

    private String cnpj;
    private String nome;
    private String Endereço;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String Telefone;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Usuario> usuario;
}
