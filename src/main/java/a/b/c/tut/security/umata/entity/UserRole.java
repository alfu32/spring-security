package a.b.c.tut.security.umata.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

// @Entity
public class UserRole {
    public UserRole() {
    }

    @EmbeddedId
    private UserRoleId id = new UserRoleId();
    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    private Role role;


}
