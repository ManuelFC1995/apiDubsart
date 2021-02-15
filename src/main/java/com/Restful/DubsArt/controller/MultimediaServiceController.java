package com.Restful.DubsArt.controller;
import com.Restful.DubsArt.Services.CloudinaryService;
import com.Restful.DubsArt.Services.MultimediaService;
import com.Restful.DubsArt.Services.PublicationService;
import com.Restful.DubsArt.dto.Mensaje;
import com.Restful.DubsArt.model.Multimedia;
import com.Restful.DubsArt.model.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cloudinary")


@CrossOrigin
public class MultimediaServiceController {
    @Autowired
    PublicationService Publicationservice;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    MultimediaService imagenService;

    @GetMapping("/list")
    public ResponseEntity<List<Multimedia>> list(){
        List<Multimedia> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/GetOne")
    public ResponseEntity<Multimedia> GetOne(@PathVariable("id") int id) {
        Optional<Multimedia> list = imagenService.getOne(id);
        return new ResponseEntity(list, HttpStatus.OK);
    }



    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile,@RequestParam int publicacion)throws IOException {
     /*   BufferedImage bi = ImageIO.read(multipartFile.getInputStream());

        if(bi == null){
            return new ResponseEntity(new Mensaje("archivo no válido"), HttpStatus.BAD_REQUEST);
        }
        */

        Map result = cloudinaryService.upload(multipartFile);
        Multimedia imagen =
                new Multimedia((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        Publicacion p = Publicationservice.getPubById(publicacion);
        imagen.setPublicacion( p);

        imagenService.save(imagen);
        p.setMultimedia(imagen);
        Publicationservice.UpdatePublication(p);
        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id)throws IOException {
        if(!imagenService.exists(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Multimedia imagen = imagenService.getOne(id).get();
        Map result = cloudinaryService.delete(imagen.getMultimediaId());
        imagenService.delete(id);
        return new ResponseEntity(new Mensaje("imagen eliminada"), HttpStatus.OK);
    }

    //Hcer el upload diciendole la publicacion que es

}
