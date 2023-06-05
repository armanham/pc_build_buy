package team.foura.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.foura.backend.model.entity.Admin;

import java.util.Optional;

/**
 * Repository interface for managing admin entities.
 *
 * <p>The {@code AdminRepository} interface extends the {@link JpaRepository} interface,
 * providing CRUD (Create, Read, Update, Delete) operations and other common database operations
 * for the {@link Admin} entity. It allows accessing and manipulating admin entities in the
 * underlying database.
 *
 * <p>This interface acts as a bridge between the application and the database, providing
 * convenient methods to interact with admin entities.
 *
 * @author Arman Hambardzumyan
 */

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Optional<Admin> findByUsername(String username);

    Optional<Admin> findByPhone(String phone);

    Optional<Admin> findByEmail(String email);
}