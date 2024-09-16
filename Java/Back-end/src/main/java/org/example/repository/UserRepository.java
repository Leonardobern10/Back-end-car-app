package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link User}.
 * <p>
 * Esta interface estende {@link JpaRepository} e fornece métodos para realizar operações CRUD
 * e consultas específicas na tabela de usuários. Inclui um método adicional para buscar um usuário
 * pelo nome de usuário.
 * </p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * Encontra um usuário pelo nome de usuário.
     * <p>
     * Este método é utilizado para buscar um usuário específico baseado no seu nome de usuário.
     * </p>
     *
     * @param username o nome de usuário do usuário a ser encontrado
     * @return o objeto {@link User} correspondente ao nome de usuário fornecido, ou {@code null}
     * se nenhum usuário com o nome de usuário especificado for encontrado
     */
    User findByUsername ( String username );
}
