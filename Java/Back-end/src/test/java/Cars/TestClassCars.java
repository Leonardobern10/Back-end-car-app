package Cars;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para verificar a funcionalidade da classe {@link Cars}.
 *
 * <p>Esta classe contém testes unitários que verificam a criação de instâncias da classe {@link Cars},
 * a geração de IDs, a definição de propriedades como modelo, URL e valor do carro.</p>
 */
public class TestClassCars extends TestRoutine {

    /**
     * Testa a criação de instâncias da classe {@link Cars} com e sem parâmetros.
     * Verifica se as instâncias são criadas corretamente.
     */
    @Test
    @DisplayName( "Verificando a instanciação da classe com e sem parâmetros..." )
    void checkInstance () {
        assertNotNull( carsWithoutParams, "A instância sem parâmetros deve ser criada" );
        assertNotNull( carsWithParams, "A instância com parâmetros deve ser criada" );
    }


    /**
     * Testa a definição do modelo do carro nas instâncias da classe {@link Cars}.
     * Verifica se o modelo é definido e recuperado corretamente.
     */
    @Test
    @DisplayName( "Verificando a definição de modelos de carros..." )
    void checkSetterModel () {
        String testModel = "String inserida para test...";
        carsWithParams.setModel( testModel );
        carsWithoutParams.setModel( testModel );
        assertAll( "Modelos devem ser definidos corretamente",
                () -> assertEquals( "String inserida para test...", carsWithParams.getModel() ),
                () -> assertEquals( "String inserida para test...", carsWithoutParams.getModel() )
        );
    }


    /**
     * Testa a definição da URL do carro nas instâncias da classe {@link Cars}.
     * Verifica se a URL é definida e recuperada corretamente.
     */
    @Test
    @DisplayName( "Verificando a definição de URL..." )
    void checkUrlDefinition () {
        String testUrl = "URL para test...";
        carsWithParams.setImageUrl( testUrl );
        carsWithoutParams.setImageUrl( testUrl );
        assertAll( "URLs devem ser definidas corretamente",
                () -> assertEquals( "URL para test...", carsWithParams.getImageUrl() ),
                () -> assertEquals( "URL para test...", carsWithoutParams.getImageUrl() )
        );
    }

    /**
     * Testa a definição do valor do carro nas instâncias da classe {@link Cars}.
     * Verifica se o valor é definido como {@link Double} e se é igual ao valor esperado.
     */
    @Test
    @DisplayName( "Verificando a adição de valores para preços..." )
    void checkValue () {
        double testValues = 0.0;
        carsWithParams.setCarValue( testValues );
        carsWithoutParams.setCarValue( testValues );
        assertAll(
                () -> assertInstanceOf( Double.class, carsWithParams.getCarValue() ),
                () -> assertEquals( 0.0, carsWithParams.getCarValue() ),
                () -> assertInstanceOf( Double.class, carsWithoutParams.getCarValue() ),
                () -> assertEquals( 0.0, carsWithoutParams.getCarValue() )
        );
    }
}
