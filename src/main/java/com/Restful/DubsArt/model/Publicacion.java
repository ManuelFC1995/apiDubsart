package com.Restful.DubsArt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name="publicaciones")

public class Publicacion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected int id;

    @NotNull
    @Column(name="descripcion", length=128)
    protected String descripcion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "multimedia_id", referencedColumnName = "id")

    protected  Multimedia multimedia;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    protected Usuario usuario;


/*
    @JoinTable(name="Comenta", joinColumns= {@JoinColumn(name="id_publicacion")},
            inverseJoinColumns= {@JoinColumn(name="id_comentario")})
    @ManyToMany(cascade= {CascadeType.MERGE})
    private ArrayList<Comentario> comentarios;

*/
    public Publicacion() {

    }

    public Publicacion(String descripcion, Multimedia multimedia, Usuario usuario) {
        this.descripcion = descripcion;
        this.multimedia = multimedia;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }




    @JsonIgnore
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", multimedia=" + multimedia +
                ", usuario=" + usuario +
                '}';
    }
}
