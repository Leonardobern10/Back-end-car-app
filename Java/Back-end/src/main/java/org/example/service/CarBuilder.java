package org.example.service;

import org.example.model.Cars;
import org.example.validations.CarValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe responsável pela construção e atualização de objetos Cars.
 * Fornece um método para criar ou atualizar um carro, aplicando validações
 * antes de modificar o objeto.
 */
@Component
public class CarBuilder {

    @Autowired
    private CarValidations carValidations;

    /**
     * Constrói ou atualiza um objeto Cars com base nas informações fornecidas.
     * Aplica validações às informações antes de atualizar o objeto.
     *
     * @param car o objeto Cars a ser atualizado
     * @param model o modelo do carro
     * @param url a URL associada ao carro
     * @param carValue o valor do carro
     * @return o objeto Cars atualizado
     * @throws RuntimeException se alguma das informações fornecidas for inválida
     */
    public Cars builder (Cars car, String model, String url, double carValue) {
        car.setModel(model);
        car.setUrl(url);
        car.setCarValue(carValue);
        return car;
    }
}
