package br.com.rodrigopeleias.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "topico")
public class Topico implements Serializable {

    @Id
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Assunto assunto;

    private Date dataCadastro;
    private String titulo;
}
