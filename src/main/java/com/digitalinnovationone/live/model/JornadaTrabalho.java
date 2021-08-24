package com.digitalinnovationone.live.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
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
public class JornadaTrabalho {
    @Id
    @NotNull
    @GeneratedValue
    private Long id;

    private String descricao;
    private String inicioJornada;
    private String fimJornada;


    @OneToMany(mappedBy = "jornadaTrabalho", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Usuario> usuario;
}
