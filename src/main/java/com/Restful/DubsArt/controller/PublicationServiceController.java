package com.Restful.DubsArt.controller;
import com.Restful.DubsArt.Services.PublicationService;
import com.Restful.DubsArt.exceptions.RecordNotFoundException;
import com.Restful.DubsArt.exceptions.RecordNotFoundException1;
import com.Restful.DubsArt.model.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Publications")
public class PublicationServiceController {


    @Autowired

    PublicationService service;

    @GetMapping
    public ResponseEntity<List<Publicacion>> getAllPublicatios() {
        List<Publicacion> list = service.getAllPublications();

        return new ResponseEntity<List<Publicacion>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getPublicationById(@PathVariable("id") int id)
            throws RecordNotFoundException1 {
        Publicacion entity = service.getPubById(id);

        return new ResponseEntity<Publicacion>(entity, new HttpHeaders(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Publicacion> createPublication(@Valid @RequestBody Publicacion myItem){
        Publicacion created = service.createPublication(myItem);
        return new ResponseEntity<Publicacion>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Publicacion> UpdatePublication(@Valid @RequestBody Publicacion myItem)
            throws RecordNotFoundException1 {
        Publicacion updated = service.UpdatePublication(myItem);
        return new ResponseEntity<Publicacion>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePublicationById(@PathVariable("id") int id)
            throws RecordNotFoundException1 {
        service.deletePublicationById(id);
        return HttpStatus.ACCEPTED;
    }
}
