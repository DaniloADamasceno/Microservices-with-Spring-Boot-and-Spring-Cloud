package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)                           //-> EAGER -> Carrega os dados do usuário e os perfis
    @JoinTable(name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "user_id"),            //-> Nome da Chave estrangeira da primeira tabela
            inverseJoinColumns = @JoinColumn(name = "role_id"))       //-> Nome da Chave estrangeira da segunda tabela
    private Set<Role> roles = new HashSet<>();

    //?--------------------------------------------   Constructors    --------------------------------------------------
    public User() {
    }

    public User(Long id, String name, String email, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    //?--------------------------------------------   Getters and Setters    -------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    //?--------------------------------------------   HashCode and Equals    -------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
