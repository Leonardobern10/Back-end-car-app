package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Classe representativa dos dados armazenados no banco de dados
 */
@Document( collection = "cars" )
public class Cars {
    @Id
    private String id;
    private String model;
    private Integer yearProduction;
    private String producedBy;
    private String imageUrl;
    private Double carValue;
    private SpecificationsCar specifications;
    private List<String> features;
    private DimensionsCar dimensions;

    public Cars () {
    }

    public Cars ( String model, int yearProduction, String producedBy, String imageUrl, double carValue,
                  SpecificationsCar specifications, List<String> features, DimensionsCar dimensions ) {
        this.model = model;
        this.yearProduction = yearProduction;
        this.producedBy = producedBy;
        this.imageUrl = imageUrl;
        this.carValue = carValue;
        this.specifications = specifications;
        this.features = features;
        this.dimensions = dimensions;
    }

    public String getId () {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getModel () {
        return model;
    }

    public void setModel ( String model ) {
        this.model = model;
    }

    public Integer getYearProduction () {
        return yearProduction;
    }

    public void setYearProduction ( int yearProduction ) {
        this.yearProduction = yearProduction;
    }

    public String getProducedBy () {
        return producedBy;
    }

    public void setProducedBy ( String producedBy ) {
        this.producedBy = producedBy;
    }

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl ( String imageUrl ) {
        this.imageUrl = imageUrl;
    }

    public Double getCarValue () {
        return carValue;
    }

    public void setCarValue ( double carValue ) {
        this.carValue = carValue;
    }

    public SpecificationsCar getSpecifications () {
        return specifications;
    }

    public void setSpecifications ( SpecificationsCar specifications ) {
        this.specifications = specifications;
    }

    public List<String> getFeatures () {
        return features;
    }

    public void setFeatures ( List<String> features ) {
        this.features = features;
    }

    public DimensionsCar getDimensions () {
        return dimensions;
    }

    public void setDimensions ( DimensionsCar dimensions ) {
        this.dimensions = dimensions;
    }
}
