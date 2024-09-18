package org.example.validations;

import org.example.exceptions.InvalidFieldException;

import java.lang.reflect.Field;

/**
 * Classe responsável pela validação das propriedades de um objeto.
 * <p>
 * Esta classe fornece uma funcionalidade para validar os campos de um objeto,
 * garantindo que seus valores atendam a critérios de validação específicos.
 * </p>
 */
public class ValidateObjectProperties {

    /**
     * Valida todas as propriedades de um objeto.
     * <p>
     * Este método utiliza reflexão para acessar e validar os campos privados do objeto fornecido.
     * Se um campo não atender aos critérios de validação definidos, uma exceção será lançada.
     * </p>
     *
     * @param object O objeto cujas propriedades devem ser validadas.
     * @throws InvalidFieldException Se ocorrer um erro ao acessar um campo ou se algum campo
     *                               não atender aos critérios de validação.
     */
    public static void validate ( Object object ) {
        Field[] fields = object.getClass().getDeclaredFields();
        for ( Field field : fields ) {
            try {
                field.setAccessible( true );
                Object value = field.get( object );
                StringValidation.validate( value != null ? value.toString() : "",
                        "FIELD" + field.getName() + " IS NOT VALID" );
            } catch ( IllegalAccessException e ) {
                throw new InvalidFieldException( "ERRO AO ACESSAR O CAMPO" + field.getName() );
            }
        }
    }
}
