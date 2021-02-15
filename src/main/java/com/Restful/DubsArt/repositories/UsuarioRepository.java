package com.Restful.DubsArt.repositories;

import com.Restful.DubsArt.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario,String> {

    @Query(
            value="SELECT * FROM Usuarios AS u WHERE u.name LIKE %?1%",
            nativeQuery=true)
    public List<Usuario> getByName(String title);
/*
    @Query(
            value="SELECT * FROM Usuarios AS u inner join followers on u.id= LIKE %?1%",
            nativeQuery=true)
    public List<Usuario> getSeguidores(int id);
    */

}
