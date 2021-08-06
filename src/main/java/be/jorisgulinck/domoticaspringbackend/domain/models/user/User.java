package be.jorisgulinck.domoticaspringbackend.domain.models.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "roles", nullable = false)
    private String roles;

    public User() {
    }

    public User(int id, String userName, String password, boolean active, String roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}