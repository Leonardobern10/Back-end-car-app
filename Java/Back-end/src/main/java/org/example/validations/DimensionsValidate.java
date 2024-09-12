package org.example.validations;

import org.example.model.DimensionsCar;

/**
 * Classe responsável pela validação das dimensões de um carro.
 * <p>
 * Fornece métodos para verificar se as dimensões do carro são válidas.
 * As dimensões incluem comprimento, largura, altura e distância entre eixos.
 * </p>
 */
public class DimensionsValidate {

    /**
     * Valida as dimensões de um carro.
     * <p>
     * Este método verifica se todos os campos das dimensões do carro são válidos.
     * Isso inclui comprimento, largura, altura e distância entre eixos. Se qualquer
     * um desses campos não for válido, uma exceção será lançada.
     * </p>
     *
     * @param dimensionsCar o objeto DimensionsCar contendo as dimensões a serem validadas
     * @throws RuntimeException se algum dos campos de dimensões não for válido
     */
    public static void validate ( DimensionsCar dimensionsCar ) {
        isValid( dimensionsCar.getLength() );
        isValid( dimensionsCar.getWidth() );
        isValid( dimensionsCar.getHeight() );
        isValid( dimensionsCar.getWheelBase() );
    }

    // D   R   Y

    /**
     * Verifica se uma dimensão fornecida é válida.
     * <p>
     * Este método realiza a validação de uma dimensão, que deve ser uma string válida.
     * Se a dimensão não for válida, uma exceção será lançada.
     * </p>
     *
     * @param string a dimensão a ser verificada
     * @throws RuntimeException se a dimensão fornecida não for válida
     */
    private static void isValid ( String string ) {
        CarStringValidation.validate( string, "FIELD IS NOT VALID: " + string );
    }
}
