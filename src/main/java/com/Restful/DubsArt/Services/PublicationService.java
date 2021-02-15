package com.Restful.DubsArt.Services;

import com.Restful.DubsArt.exceptions.RecordNotFoundException;
import com.Restful.DubsArt.exceptions.RecordNotFoundException1;
import com.Restful.DubsArt.model.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import com.Restful.DubsArt.repositories.PublicacionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PublicationService {

    @Autowired

    PublicacionRepository repository;



    public List<Publicacion> getAllPublications()
    {
        List<Publicacion> PubList = repository.findAll();

        if(PubList.size() > 0) {
            return PubList;
        } else {
            return new ArrayList<Publicacion>();
        }
    }



    public Publicacion getPubById(int id) throws RecordNotFoundException1 {
        Optional<Publicacion> pub = repository.findById(id);

        if(pub.isPresent()) {
            return pub.get();
        } else {
            throw new RecordNotFoundException1("No item record exist for given id",id);
        }
    }


    public Publicacion createPublication(Publicacion entity){
        entity = repository.save(entity);
        return entity;
    }


    public Publicacion UpdatePublication(Publicacion entity) throws RecordNotFoundException1
    {

        Optional<Publicacion> item = repository.findById(entity.getId());

        if(item.isPresent())
        {
            Publicacion newEntity = item.get();
            //newEntity.setId(entity.getId());
            newEntity.setDescripcion(entity.getDescripcion());





            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException1("Publicacion not found",entity.getId());
        }
    }

    public void deletePublicationById(int id) throws RecordNotFoundException1
    {
        Optional<Publicacion> item = repository.findById(id);

        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException1("No item record exist for given id",id);
        }
    }

    public List<Publicacion> getPubByUser(int id) {
        List<Publicacion> itemList = repository.getByUser( id);

        if(itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<Publicacion>();
        }
    }
}
