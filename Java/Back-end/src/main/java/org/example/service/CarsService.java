package org.example.service;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.validations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CarStringValidation carStringValidation;

    @Autowired
    private CarValidations carValidations;

    @Autowired
    private CarBuilder carBuilder;

    public List<Cars> getAllCars () {
        return carsRepository.findAll();
    }

    @Cacheable( value = "carsByModel", key = "#model" )
    public Cars getByModel ( String model ) {
        return carsRepository.findByModel( model );
    }

    @Cacheable( value = "cars", key = "#id" )
    public Cars getById ( String id ) {
        String str = FormatInfo.check( id );
        carValidations.validateCarExistence( str );
        return carsRepository.findById( str ).orElseThrow();
    }

    @Cacheable( value = "carByValue", key = "#value" )
    public List<Cars> getByValue ( Double value ) {
        CarValueValidation.validate( value );
        return carsRepository.findByValue( value );
    }

    @Cacheable( value = "carsByLessThanValue", key = "#lessValue" )
    public List<Cars> getByLessThanValue ( Double value ) {
        CarValueValidation.validate( value );
        return carsRepository.findByLessThanValue( value );
    }

    @Cacheable( value = "carByBiggerThanValue", key = "#biggerValue" )
    public List<Cars> getBiggerThanValue ( Double value ) {
        CarValueValidation.validate( value );
        return carsRepository.findBiggerThanValue( value );
    }

    @Cacheable( value = "getByYear", key = "#year" )
    public List<Cars> getByYear ( Integer year ) {
        CarIntegerValidation.validate( year );
        return carsRepository.findByYear( year );
    }

    @Cacheable( value = "carNewerYear", key = "#carNewerYear" )
    public List<Cars> getNewerThanYear ( Integer year ) {
        CarIntegerValidation.validate( year );
        return carsRepository.findNewerThanYear( year );
    }

    @Cacheable( value = "carOlderYear", key = "#carOlderYear" )
    public List<Cars> getOlderThanYear ( Integer year ) {
        CarIntegerValidation.validate( year );
        return carsRepository.findOlderThanYear( year );
    }

    @Cacheable( value = "carProducedBy", key = "#carProducedBy" )
    public List<Cars> getProducedBy ( String producedBy ) {
        String str = FormatInfo.check( producedBy );
        return carsRepository.findProducedBy( str );
    }

    @Cacheable( value = "carEngineType", key = "#carEngineType" )
    public List<Cars> getByEngineType ( String engineType ) {
        String str = FormatInfo.check( engineType );
        return carsRepository.findByEngineType( str );
    }

    @Cacheable( value = "carTopSpeed", key = "#carTopSpeed" )
    public List<Cars> getByTopSpeed ( Integer topSpeed ) {
        CarIntegerValidation.validate( topSpeed );
        String searchFormat = topSpeed.toString() + " mph";
        return carsRepository.findByTopSpeed( searchFormat );
    }

    @Cacheable( value = "carByFeature", key = "#carByFeature" )
    public List<Cars> getByFeature ( String feature ) {
        String str = FormatInfo.check( feature );
        return carsRepository.findByFeature( str );
    }

    public Cars saveCar ( Cars car ) {
        carValidations.validateSaveCar( car, car.getModel(), car.getYearProduction(), car.getProducedBy(),
                car.getImageUrl(), car.getCarValue(), car.getSpecifications(), car.getFeatures(), car.getDimensions() );
        return carsRepository.save( car );
    }

    @CacheEvict( value = "cars", key = "#id" )
    public void deleteCar ( String id ) {
        String str = FormatInfo.check( id );
        carValidations.validateCarExistence( str );
        carsRepository.deleteById( str );
    }

    @CachePut( value = "cars", key = "#car.id" )
    public Cars updateCar ( String id, Cars car ) {
        Cars oldCar = carsRepository.findById( id ).orElseThrow();
        carValidations.validateUpdatedInformations( car.getModel(), car.getYearProduction(), car.getProducedBy(),
                car.getImageUrl(), car.getCarValue(), car.getSpecifications(), car.getFeatures(), car.getDimensions() );
        Cars updatedCar = carBuilder.builder( oldCar, car.getModel(), car.getYearProduction(), car.getProducedBy(),
                car.getImageUrl(), car.getCarValue(), car.getSpecifications(), car.getFeatures(), car.getDimensions() );
        return carsRepository.save( updatedCar );
    }
}
