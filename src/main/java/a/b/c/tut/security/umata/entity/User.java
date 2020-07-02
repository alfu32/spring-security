package a.b.c.tut.security.umata.entity;

import javax.persistence.*;

import a.b.c.tut.security.umata.repository.StringListConverter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue()
    private long id;

    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "password is required")
    private String password;
    @Column
    private boolean isAccountNonExpired = true;
    @Column
    private boolean isAccountNonLocked = true;
    @Column
    private boolean isCredentialsNonExpired = true;
    @Column
    private boolean isEnabled = true;

    @Column
    @Convert(converter = StringListConverter.class)
    private List<String> grantedAuthorities;
    protected User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<String> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(List<String> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",this.grantedAuthorities));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("isAccountNonExpired=" + isAccountNonExpired)
                .add("isAccountNonLocked=" + isAccountNonLocked)
                .add("isCredentialsNonExpired=" + isCredentialsNonExpired)
                .add("isEnabled=" + isEnabled)
                .add("grantedAuthorities=" + grantedAuthorities)
                .toString();
    }
}
