package com.example.restcontrol.demo.contoller;

import com.example.restcontrol.demo.model.AreaModel;
import com.example.restcontrol.demo.model.ShapeModel;

import com.example.restcontrol.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/results")
public class ShapeRestController {

    @Autowired
    private ShapeService shapeService;

    @GetMapping("")
    public ArrayList<AreaModel> list() {
       return shapeService.list();

    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaModel> listByID(@PathVariable Integer id){
        try{
            AreaModel sm = shapeService.listByID(id);
            return new ResponseEntity<AreaModel>(sm,HttpStatus.OK);
        }
        catch(Exception e){
             return new ResponseEntity<AreaModel>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("")
    public ResponseEntity<?> postShapes(@RequestBody List<ShapeModel> shapeModel){
        try{
            shapeService.insert(shapeModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putShapes(@RequestBody ShapeModel shapeModel, @PathVariable Integer id){
              try{
                  shapeModel.setId(id);
                  shapeService.insertById(shapeModel);
                  return new ResponseEntity<>(HttpStatus.CREATED);
              }
              catch(Exception ex){
                    return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
              }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShape(@PathVariable Integer id){
        try{
            shapeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
