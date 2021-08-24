package com.digitalinnovationone.live.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String idade;
    private String whatsApp;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "jornada_trabalho_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private JornadaTrabalho jornadaTrabalho;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Empresa empresa;
}
