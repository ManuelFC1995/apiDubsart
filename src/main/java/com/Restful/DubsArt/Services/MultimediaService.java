package com.Restful.DubsArt.Services;
import com.Restful.DubsArt.model.Multimedia;
import com.Restful.DubsArt.repositories.MultimediaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MultimediaService {

    @Autowired
    MultimediaRepository imagenRepository;
//trae todos los archvos multimedia
    public List<Multimedia> list(){
        return imagenRepository.findByOrderById();
    }


//ontiene un archivo multimedia por id
    public Optional<Multimedia> getOne(int id){
        return imagenRepository.findById(id);
    }


//inserta un archivo multimedia
    public void save(Multimedia imagen){
        imagenRepository.save(imagen);
    }


//elimina un archivo multimedia
    public void delete(int id){
        imagenRepository.deleteById(id);
    }


//devuelve un boolean si existe un archivo buscandolo por id
    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }




}
