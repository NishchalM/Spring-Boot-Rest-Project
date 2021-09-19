package com.example.restcontrol.demo.service;

import com.example.restcontrol.demo.core.Core;
import com.example.restcontrol.demo.model.AreaModel;
import com.example.restcontrol.demo.model.ShapeModel;
import com.example.restcontrol.demo.repo.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShapeService {

    private ShapeRepository shapeRepository;
    private AreaModel areaModel;
    private Core core;

    @Autowired
    public ShapeService(ShapeRepository shapeRepository, AreaModel areaModel, Core core) {
        this.shapeRepository = shapeRepository;
        this.areaModel = areaModel;
        this.core = core;
    }

   public ArrayList<AreaModel> list(){
        List<ShapeModel> shapeModel = shapeRepository.findAll();
        ArrayList<AreaModel> lam = new ArrayList<AreaModel>();
        for(ShapeModel sm :shapeModel)
            lam.add(core.getArea(sm));
        return lam;
    }

    public AreaModel listByID(Integer id){
        ShapeModel shapeModel = shapeRepository.findById(id).get();
        return  core.getArea(shapeModel);
    }

    public void insert(List<ShapeModel> shapeModel){
        for (ShapeModel sm:shapeModel)
           shapeRepository.save(sm);
    }

    public void insertById(ShapeModel shapeModel){
        shapeRepository.save(shapeModel);
    }

    public void deleteById(Integer id){
        shapeRepository.deleteById(id);
    }
}
