package com.Restful.DubsArt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Multimedia")
public class Multimedia {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
    @NotNull
    @Column(name="name", length=30)
        private String name;
    @NotNull
    @Column(name="Url", length=300000)
        private String Url;
    @NotNull
    @Column(name="MultimediaID", length=300)
        private String MultimediaId;
    @JsonIgnore
    @OneToOne(mappedBy = "multimedia")
    private Publicacion publicacion;

        public Multimedia() {
        }

        public Multimedia(String name, String imagenUrl, String imagenId) {
            this.name = name;
            this.Url = imagenUrl;
            this.MultimediaId = imagenId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return Url;
        }

        public void setImagenUrl(String imagenUrl) {
            this.Url = imagenUrl;
        }

        public String getMultimediaId() {
            return MultimediaId;
        }

        public void setMultimediaId(String imagenId) {
            this.MultimediaId = imagenId;
        }

    public void setUrl(String url) {
        Url = url;
    }
    @JsonIgnore
    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Url='" + Url + '\'' +
                ", MultimediaId='" + MultimediaId + '\'' +
                ", publicacion=" + publicacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return id == that.id && Url.equals(that.Url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Url);
    }
}
