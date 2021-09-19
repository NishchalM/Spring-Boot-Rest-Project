package com.example.restcontrol.demo.core;

import com.example.restcontrol.demo.model.AreaModel;
import com.example.restcontrol.demo.model.ShapeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Core {

    public AreaModel getArea(ShapeModel shapeModel) throws  IllegalStateException{
        AreaModel am = new AreaModel();
        String type = shapeModel.getType().toUpperCase();
        List<Integer> sides = shapeModel.getSides();
        am.setId(shapeModel.getId());
        switch (type){
            case Constants.Circle:     am.setArea(Math.PI * sides.get(0) * sides.get(0));
                break;
            case Constants.Rectangle:  am.setArea((double) (sides.get(0) * sides.get(1)));
                 break;
            case Constants.Square:     am.setArea((double) (sides.get(0) * sides.get(0)));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return  am;
    }
}
