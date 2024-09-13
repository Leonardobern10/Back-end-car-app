package org.example.service;

import org.example.validations.StringValidation;

/**
 * Classe utilitária para operações de formatação e validação de strings.
 * <p>
 * Fornece métodos estáticos para validar e formatar strings. Esta classe é usada para garantir que
 * as strings estejam no formato correto e atender aos requisitos de validação antes de serem usadas
 * em outras partes do código.
 * </p>
 */
public class FormatInfo {

    /**
     * Valida e formata a string fornecida.
     * <p>
     * O método verifica se a string atende aos critérios de validação definidos em {@link StringValidation}.
     * Se a validação falhar, uma exceção será lançada com a mensagem fornecida. Após a validação, a string é
     * removida de espaços em branco nas extremidades e retornada.
     * </p>
     *
     * @param id a string a ser validada e formatada
     * @return a string formatada, com espaços em branco removidos das extremidades
     * @throws IllegalArgumentException se a string não passar na validação
     */
    public static String check ( String id ) {
        StringValidation.validate( id, "FIELD IS NOT VALID" + id );
        return id.trim();
    }
}
