package org.example.validations;


import org.example.exceptions.DuplicatedFoundException;
import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.utils.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe responsável pela validação de duplicidade de carros.
 * Fornece um método estático para verificar se um carro já existe no repositório.
 */
@Component
public class DuplicatedFoundValidation {

    private final Cars car = new Cars();
    @Autowired
    private CarsRepository carsRepository;

    /**
     * Valida se um carro já existe no repositório com base no seu ID.
     * Verifica se o carro com o ID fornecido já está presente no repositório. Se estiver,
     * lança uma exceção indicando que a duplicidade foi encontrada.
     *
     * @param car o carro a ser validado
     * @throws DuplicatedFoundException se um carro com o mesmo ID já existir no repositório
     */
    public void validate ( Cars car ) {
        if ( carsRepository.existsById( car.getId() ) ) {
            throw new DuplicatedFoundException( Errors.RESOURCE_NOT_FOUND_ERROR + car.getId() );
        }
    }
}
