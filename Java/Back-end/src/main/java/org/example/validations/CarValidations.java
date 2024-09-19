package org.example.validations;

import org.example.exceptions.ResourceNotFoundException;
import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe responsável pela validação das informações relacionadas a carros.
 * <p>
 * Fornece métodos para validar informações antes de salvar ou atualizar um carro, bem como verificar a existência de um carro.
 * </p>
 */
@Component
public class CarValidations {

    @Autowired
    private IfCarsExistsValidation ifCarsExistsValidation;

    @Autowired
    private DuplicatedFoundValidation duplicatedFoundValidation;

    /**
     * Valida as informações a serem atualizadas para um carro.
     * <p>
     * Este método realiza validações nos campos do carro que estão sendo atualizados, incluindo o modelo, ano de produção,
     * fabricante, URL da imagem, valor do carro, especificações, recursos e dimensões. Se qualquer uma dessas informações
     * for inválida, uma exceção é lançada.
     * </p>
     *
     * @param model             o modelo do carro
     * @param yearProduction    o ano de produção do carro
     * @param producedBy        o fabricante do carro
     * @param imageUrl          a URL associada ao carro
     * @param carValue          o valor do carro
     * @param specificationsCar as especificações do carro
     * @param feature           uma lista de recursos do carro
     * @param dimensionsCar     as dimensões do carro
     * @throws RuntimeException se algum dos parâmetros for inválido
     */
    public void validateUpdatedInformations ( String model, Integer yearProduction, String producedBy, String imageUrl,
                                              Double carValue, SpecificationsCar specificationsCar, List<String> feature,
                                              DimensionsCar dimensionsCar ) throws RuntimeException {
        StringValidation.validate( model, producedBy, imageUrl );
        IntegerValidation.validate( yearProduction );
        CarValueValidation.validate( carValue );
        ValidateObjectProperties.validate( specificationsCar, dimensionsCar );
        IsEmptyValidation.validate( feature );
    }

    /**
     * Valida as informações para salvar um carro.
     * <p>
     * Este método realiza validações nos campos do carro que está sendo salvo, incluindo o ID, modelo, ano de produção,
     * fabricante, URL da imagem, valor do carro, especificações, recursos e dimensões. Além disso, verifica se o carro já existe
     * para evitar duplicatas. Se qualquer uma dessas informações for inválida ou se o carro já existir, uma exceção é lançada.
     * </p>
     *
     * @param car               o objeto {@link Cars} a ser validado
     * @param model             o modelo do carro
     * @param yearProduction    o ano de produção do carro
     * @param producedBy        o fabricante do carro
     * @param imageUrl          a URL associada ao carro
     * @param carValue          o valor do carro
     * @param specificationsCar as especificações do carro
     * @param feature           uma lista de recursos do carro
     * @param dimensionsCar     as dimensões do carro
     * @throws RuntimeException se o ID for inválido, houver duplicatas, ou qualquer outro campo for inválido
     */
    public void validateSaveCar ( Cars car, String model, Integer yearProduction, String producedBy, String imageUrl,
                                  Double carValue, SpecificationsCar specificationsCar, List<String> feature,
                                  DimensionsCar dimensionsCar ) throws RuntimeException {
        StringValidation.validate( car.getId(), model, producedBy, imageUrl );
        duplicatedFoundValidation.validate( car );
        IntegerValidation.validate( yearProduction );
        CarValueValidation.validate( carValue );
        ValidateObjectProperties.validate( specificationsCar, dimensionsCar );
        IsEmptyValidation.validate( feature );
    }

    /**
     * Valida a existência de um carro com base no ID fornecido.
     * <p>
     * Este método verifica se um carro com o ID especificado existe no repositório. Se o carro
     * não for encontrado, uma exceção {@link ResourceNotFoundException} é lançada.
     * </p>
     *
     * @param id o ID do carro a ser validado
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    public void validateCarExistence ( String id ) {
        ifCarsExistsValidation.validate( id );
    }
}
