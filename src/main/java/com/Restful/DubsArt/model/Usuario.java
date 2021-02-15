package com.Restful.DubsArt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="usuarios")

public class Usuario {
   @Id


    private String id;



     @Column(name="name", length=30)
    private String name;

    @Column(name="Foto", length=30000)
    String Foto;
    @Column(name="Biografia", length=128)
    private String Biografia;

   /* @JoinTable(name = "Followers", joinColumns = {
            @JoinColumn(name = "le sigue", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "es seguido", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private ArrayList<Usuario> Seguidores;

    @JoinTable(name = "Followers", joinColumns = {
            @JoinColumn(name = "es seguido", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "le sigue", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private ArrayList<Usuario> Seguidos;
*/
    @OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Publicacion> Publicaciones ;


    public Usuario() {

    }

    public Usuario( String name) {

        this.name = name;
        this.Biografia="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Publicacion> getPublicaciones() {
        return Publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        Publicaciones = publicaciones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiografia() {
        return Biografia;
    }

    public void setBiografia(String biografia) {
        Biografia = biografia;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name=" + name +
                ", Biografia=" + Biografia +
                ", Publicaciones=" + Publicaciones +
                '}';
    }
}
