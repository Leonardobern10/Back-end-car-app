package org.example.validations;

import org.example.exceptions.ResourceNotFoundException;
import org.example.repository.CarsRepository;
import org.example.utils.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe responsável pela validação da existência de um carro no repositório.
 * Fornece um método para verificar se um carro com um determinado ID existe no repositório.
 */
@Component
public class IfCarsExistsValidation {

    @Autowired
    private CarsRepository carsRepository;

    /**
     * Valida se um carro com o ID fornecido existe no repositório.
     * Se o carro não existir, lança uma exceção ResourceNotFoundException.
     *
     * @param id o ID do carro a ser validado
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    public void validate ( String id ) {
        if ( ! carsRepository.existsById( id ) ) {
            throw new ResourceNotFoundException( Errors.RESOURCE_NOT_FOUND_ERROR + id );
        }
    }
}
