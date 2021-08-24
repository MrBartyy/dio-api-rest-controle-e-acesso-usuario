package com.digitalinnovationone.live.util;

import com.digitalinnovationone.live.response.MensagemRespostaDTO;

public final class MensagemResposta {
    public static MensagemRespostaDTO create (String mensagem) {
        return MensagemRespostaDTO
                .builder()
                .mensagem(mensagem)
                .build();
    }
}
