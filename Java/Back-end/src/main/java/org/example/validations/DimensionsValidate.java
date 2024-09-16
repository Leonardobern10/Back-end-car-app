package org.example.validations;

import org.example.model.Cars;
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
     * @param dimensionsCar o objeto {@link Cars} contendo as dimensões a serem validadas
     * @throws RuntimeException se algum dos campos de dimensões não for válido
     */
    public static void validate ( DimensionsCar dimensionsCar ) {
        StringValidation.validate( dimensionsCar.getLength(), "FIELD length IS NOT VALID" + dimensionsCar.getLength() );
        StringValidation.validate( dimensionsCar.getWidth(), "FIELD width IS NOT VALID" + dimensionsCar.getWidth() );
        StringValidation.validate( dimensionsCar.getWheelBase(), "FIELD wheelBase IS NOT VALID" + dimensionsCar.getWheelBase() );
        StringValidation.validate( dimensionsCar.getHeight(), "FIELD height IS NOT VALID" + dimensionsCar.getHeight() );
    }
}
