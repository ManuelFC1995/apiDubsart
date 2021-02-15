package com.Restful.DubsArt.repositories;

import com.Restful.DubsArt.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

    @Query(
            value="SELECT * FROM publicaciones AS p WHERE p.id_usuario = %?1%",
            nativeQuery=true)
    public List<Publicacion> getByUser(int id);
}
