import org.example.model.User;
import org.example.role.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUser extends TestRoutine {

    public void checkParameters ( User user, String testUsername, String testEmail,
                                  String testPassword, String role ) {
        assertAll(
                () -> assertNotNull( user ),
                () -> assertEquals( testUsername, user.getUsername() ),
                () -> assertEquals( testEmail, user.getEmail() ),
                () -> assertEquals( testPassword, user.getPassword() ),
                () -> assertEquals( role, user.getRole() )
        );
    }

    @Test
    void testInstance () {
        User user = new User( "username teste", "email teste", "password teste",
                UserRole.ADMIN_ROLE );

        checkParameters( user, "username teste", "email teste",
                "password teste", user.getRole() );
    }

    @Test
    void testInstanceWithoutParameters () {
        User user = buildUser();

        checkParameters( user, "username teste", "email teste",
                "password teste", user.getRole() );
    }
}
