package org.example.build.BuildCar;

import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;

import java.util.List;

/**
 * Interface para construir um objeto {@link Cars} passo a passo.
 * <p>
 * Esta interface define métodos para configurar os diferentes atributos do carro e construir um objeto {@link Cars} com base nesses atributos.
 * </p>
 */
public interface BuilderCar {

    /**
     * Define o modelo do carro.
     *
     * @param model o modelo do carro
     */
    void buildModel ( String model );

    /**
     * Define o ano de produção do carro.
     *
     * @param yearProduction o ano de produção do carro
     */
    void buildYearProduction ( Integer yearProduction );

    /**
     * Define o fabricante do carro.
     *
     * @param producedBy o fabricante do carro
     */
    void buildProducedBy ( String producedBy );

    /**
     * Define a URL da imagem do carro.
     *
     * @param imageUrl a URL da imagem do carro
     */
    void buildImageUrl ( String imageUrl );

    /**
     * Define o valor do carro.
     *
     * @param carValue o valor do carro
     */
    void buildCarValue ( Double carValue );

    /**
     * Define as especificações do carro.
     *
     * @param specificationsCar as especificações do carro
     */
    void buildSpecitifactions ( SpecificationsCar specificationsCar );

    /**
     * Define as características do carro.
     *
     * @param features uma lista com as características do carro
     */
    void buildFeatures ( List<String> features );

    /**
     * Define as dimensões do carro.
     *
     * @param dimensionsCar as dimensões do carro
     */
    void buildDimensions ( DimensionsCar dimensionsCar );

    /**
     * Constrói e retorna o objeto carro com as propriedades especificadas.
     *
     * @return o objeto carro construído
     */
    Cars buildCar ();
}
