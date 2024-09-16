package org.example.build.BuildCar;

import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe responsável por construir um objeto {@link Cars} usando um {@link BuilderCar}.
 * A construção é feita através da configuração passo a passo do objeto carro.
 */
@Component
public class DirectorCar {

    /**
     * Constrói um objeto {@link Cars} utilizando o {@link BuilderCar} e as propriedades fornecidas.
     *
     * @param builderCar        o construtor de carro que será usado para construir o objeto carro
     * @param model             o modelo do carro
     * @param yearProduction    o ano de produção do carro
     * @param producedBy        o fabricante do carro
     * @param imageUrl          a URL da imagem do carro
     * @param carValue          o valor do carro
     * @param specificationsCar as especificações do carro
     * @param features          uma lista com as características do carro
     * @param dimensionsCar     as dimensões do carro
     * @return o objeto carro construído
     */
    public Cars construct ( BuilderCar builderCar, String model, Integer yearProduction, String producedBy, String imageUrl,
                            Double carValue, SpecificationsCar specificationsCar, List<String> features,
                            DimensionsCar dimensionsCar ) {
        builderCar.buildModel( model );
        builderCar.buildYearProduction( yearProduction );
        builderCar.buildProducedBy( producedBy );
        builderCar.buildImageUrl( imageUrl );
        builderCar.buildCarValue( carValue );
        builderCar.buildSpecitifactions( specificationsCar );
        builderCar.buildFeatures( features );
        builderCar.buildDimensions( dimensionsCar );
        return builderCar.buildCar();
    }
}
