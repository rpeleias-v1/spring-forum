package br.com.rodrigopeleias.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permissao_usuario")
public class PermissaoUsuario implements GrantedAuthority, Serializable{

    @Id
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    protected long id;

    @Column(name = "role", nullable = false, length = 64)
    private String role;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAuthority() {
        return role;
    }
}
