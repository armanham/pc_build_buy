package team.foura.backend.model.entity;

import jakarta.persistence.*;
import team.foura.backend.model.dto.AdminDTO;
import team.foura.backend.model.enums.Status;
import team.foura.entity.BaseEntity;

/**
 * Represents an admin user.
 *
 * <p>The {@code Admin} class is an entity mapped to the "admin" table in the database. It contains
 * properties and methods related to an admin user, including username, password, email, phone,
 * and status.
 *
 * @author Ani Hakobyan, Arman Hambardzumyan
 */

@Entity
@Table(
        name = "admin",
        uniqueConstraints = {
                @UniqueConstraint(name = "UC_email", columnNames = {"email"}),
                @UniqueConstraint(name = "UC_phone", columnNames = {"phone"})
        }
)
public class Admin extends BaseEntity {

    @Id
    @Column(name = "username", length = 32)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, length = 64)
    private String email;

    @Column(name = "phone", nullable = false, length = 64)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    public Admin() {
    }

    public Admin(
            final String username,
            final String password,
            final String email,
            final String phone,
            final Status status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    /**
     * Constructs an Admin object based on the provided AdminDTO.
     *
     * @param dto the AdminDTO object containing the details of the admin user
     */
    public Admin(final AdminDTO dto) {
        this.username = dto.username();
        this.password = dto.password();
        this.email = dto.email();
        this.phone = dto.phone();
        this.status = Status.valueOf(dto.status());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}