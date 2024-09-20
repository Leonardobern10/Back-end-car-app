import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.example.model.User;
import org.example.role.UserRole;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestRoutine {

    @BeforeAll
    static void init () {
        System.out.println( "Iniciando bateria de testes..." );
    }

    Cars initCarsWithParameters () {

        List<String> features = initFeatures( "featureTest1", "featureTest2" );
        DimensionsCar dimensionsCar = initDimensionsCar();
        SpecificationsCar specificationsCar = initSpecificationsCar();

        return new Cars( "model teste", 0, "produced teste",
                "image teste", 0.0, specificationsCar,
                features, dimensionsCar );
    }

    Cars buildCarWithoutParameters () {

        Cars carWithoutParams = new Cars();
        carWithoutParams.setModel( "model teste" );
        carWithoutParams.setYearProduction( 0 );
        carWithoutParams.setProducedBy( "produced teste" );
        carWithoutParams.setImageUrl( "image teste" );
        carWithoutParams.setCarValue( 0.0 );

        return carWithoutParams;
    }

    List<String> initFeatures ( String... params ) {
        return new ArrayList<>( Arrays.asList( params ) );
    }

    DimensionsCar initDimensionsCar () {
        return new DimensionsCar( "length teste", "width teste",
                "height teste", "wheelbase teste" );
    }

    DimensionsCar buildDimensionsCar () {
        DimensionsCar dimensionsCar = new DimensionsCar();

        dimensionsCar.setLength( "length teste" );
        dimensionsCar.setWidth( "width teste" );
        dimensionsCar.setHeight( "height teste" );
        dimensionsCar.setWheelBase( "wheelbase teste" );

        return dimensionsCar;
    }

    SpecificationsCar initSpecificationsCar () {
        return new SpecificationsCar( "engineType teste",
                "engineCapacity teste", "range teste",
                "acceleration teste", "topSpeed teste" );
    }

    SpecificationsCar buildSpecificationsCar () {

        SpecificationsCar specificationsCar = new SpecificationsCar();

        specificationsCar.setEngineType( "engineType teste" );
        specificationsCar.setEngineCapacity( "engineCapacity teste" );
        specificationsCar.setRange( "range teste" );
        specificationsCar.setAcceleration( "acceleration teste" );
        specificationsCar.setTopSpeed( "topSpeed teste" );

        return specificationsCar;
    }

    User buildUser () {
        User user = new User();

        user.setUsername( "username teste" );
        user.setEmail( "email teste" );
        user.setPassword( "password teste" );
        user.setRole( UserRole.ADMIN_ROLE );

        return user;
    }

}
