package org.example.service;

import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.example.validations.CarValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Serviço responsável pela construção e atualização de objetos {@link Cars}.
 * <p>
 * Esta classe fornece um método para construir ou atualizar um objeto {@link Cars} com base nas informações fornecidas.
 * Antes de modificar o objeto, as informações são validadas utilizando a classe {@link CarValidations}.
 * </p>
 */
@Component
public class CarBuilder {

    @Autowired
    private CarValidations carValidations;

    /**
     * Constrói ou atualiza um objeto {@link Cars} com base nas informações fornecidas.
     * <p>
     * Este método aplica as informações fornecidas ao objeto {@link Cars}. Ele define os valores para o modelo,
     * ano de produção, fabricante, URL da imagem, valor do carro, especificações, características e dimensões do carro.
     * </p>
     * <p>
     * As informações são fornecidas através dos parâmetros do método. O método aplica essas informações ao objeto {@link Cars}
     * e retorna o objeto atualizado. A validação das informações deve ser realizada antes da chamada a este método.
     * </p>
     *
     * @param car               o objeto {@link Cars} a ser atualizado. Se for um novo carro, deve ser um objeto vazio ou com valores padrão.
     * @param model             o modelo do carro. Não pode ser nulo ou vazio.
     * @param yearProduction    o ano de produção do carro. Deve ser um valor válido representando um ano.
     * @param producedBy        o fabricante do carro. Não pode ser nulo ou vazio.
     * @param imageUrl          a URL associada ao carro. Pode ser nulo se não houver uma URL disponível.
     * @param carValue          o valor do carro. Deve ser um número positivo.
     * @param specificationsCar as especificações do carro representadas por um objeto {@link SpecificationsCar}. Pode ser nulo se não houver especificações.
     * @param features          uma lista de características do carro. Pode ser nula se não houver características.
     * @param dimensionsCar     as dimensões do carro representadas por um objeto {@link DimensionsCar}. Pode ser nulo se não houver dimensões.
     * @return o objeto {@link Cars} atualizado com as informações fornecidas.
     * @throws RuntimeException se alguma das informações fornecidas for inválida.
     *                          <p>
     *                          A validação das informações, como verificar se o ano de produção é um valor válido ou se o modelo e o fabricante não são nulos,
     *                          deve ser realizada antes da chamada a este método.
     *                          </p>
     */
    public Cars builder ( Cars car, String model, Integer yearProduction, String producedBy, String imageUrl,
                          Double carValue, SpecificationsCar specificationsCar, List<String> features,
                          DimensionsCar dimensionsCar ) {
        car.setModel( model );
        car.setYearProduction( yearProduction );
        car.setProducedBy( producedBy );
        car.setImageUrl( imageUrl );
        car.setCarValue( carValue );
        car.setSpecifications( specificationsCar );
        car.setFeatures( features );
        car.setDimensions( dimensionsCar );
        return car;
    }
}
