package a.b.c.tut.security.umata.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Entity
public class Role {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String scope;
    private String role;

    @Column
    private String description;

    @ManyToMany(mappedBy = "userRoles",fetch = FetchType.LAZY)
    // @JsonBackReference
    @JsonIgnoreProperties({"id","roles"})
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(getScope(), role.getScope()) &&
                Objects.equals(getRole(), role.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScope(), getRole());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Role.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("scope='" + scope + "'")
                .add("right='" + role + "'")
                .add("description='" + description + "'")
                .add("roleUsers=" + users)
                .toString();
    }
}
