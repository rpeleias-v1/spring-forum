package br.com.rodrigopeleias.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assunto")
public class Assunto implements Comparable, Serializable{

    @Id
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    protected Long id;

    @Column(name = "nome", unique = true, length = 128)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int compareTo(Object o) {
        if (o instanceof Assunto) {
            return getNome().compareTo(((Assunto)o).getNome());
        } else {
            return 0;
        }

    }
}
