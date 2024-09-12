package org.example.validations;

import org.example.exceptions.ResourceNotFoundException;
import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe responsável pela validação de informações relacionadas a carros.
 * Fornece métodos para validar informações antes de salvar ou atualizar um carro,
 * bem como verificar a existência de um carro.
 */
@Component
public class CarValidations {

    @Autowired
    private IfCarsExistsValidation ifCarsExistsValidation;

    @Autowired
    private DuplicatedFoundValidation duplicatedFoundValidation;

    /**
     * Valida as informações a serem atualizadas para um carro.
     * Verifica se os campos de modelo e URL são válidos e se o valor do carro é aceitável.
     *
     * @param model    o modelo do carro
     * @param imageUrl a URL associada ao carro
     * @param carValue o valor do carro
     * @throws RuntimeException se algum dos parâmetros for inválido
     */
    public void validateUpdatedInformations ( String model, Integer yearProduction, String producedBy, String imageUrl,
                                              Double carValue, SpecificationsCar specificationsCar, List<String> feature,
                                              DimensionsCar dimensionsCar ) throws RuntimeException {
        CarStringValidation.validate( model, "FIELD MODEL IS INVALID" );
        CarIntegerValidation.validate( yearProduction );
        CarStringValidation.validate( producedBy, "FIELD IS NOT VALID" + producedBy );
        CarStringValidation.validate( imageUrl, "FIELD URL IS INVALID" );
        CarValueValidation.validate( carValue );
        SpecificationsValidate.validate( specificationsCar );
        IsEmptyValidation.validate( feature );
        DimensionsValidate.validate( dimensionsCar );
    }

    /**
     * Valida as informações para salvar um carro.
     * Verifica se o ID do carro é válido, se não há duplicatas, e valida os campos de modelo,
     * URL e valor do carro.
     *
     * @param car      o objeto Cars a ser validado
     * @param model    o modelo do carro
     * @param imageUrl a URL associada ao carro
     * @param carValue o valor do carro
     * @throws RuntimeException se o ID for inválido, houver duplicatas, ou qualquer outro campo for inválido
     */
    public void validateSaveCar ( Cars car, String model, Integer yearProduction, String producedBy, String imageUrl,
                                  Double carValue, SpecificationsCar specificationsCar, List<String> feature,
                                  DimensionsCar dimensionsCar ) throws RuntimeException {
        CarStringValidation.validate( car.getId(), "FIELD ID IS INVALID" );
        duplicatedFoundValidation.validate( car );
        CarStringValidation.validate( model, "FIELD MODEL IS INVALID" );
        CarIntegerValidation.validate( yearProduction );
        CarStringValidation.validate( producedBy, "FIELD IS NOT VALID" + producedBy );
        CarStringValidation.validate( imageUrl, "FIELD URL IS INVALID" );
        CarValueValidation.validate( carValue );
        SpecificationsValidate.validate( specificationsCar );
        IsEmptyValidation.validate( feature );
        DimensionsValidate.validate( dimensionsCar );
    }

    /**
     * Valida a existência de um carro com base no ID fornecido.
     * Verifica se um carro com o ID especificado existe.
     *
     * @param id o ID do carro a ser validado
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    public void validateCarExistence ( String id ) {
        ifCarsExistsValidation.validate( id );
    }
}
