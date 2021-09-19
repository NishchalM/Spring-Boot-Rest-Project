package com.example.restcontrol.demo.model;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name="SHAPEMODEL")
public class ShapeModel {
    @Id
    private Integer id;
    private String type;
    @ElementCollection
    private List<Integer> sides = new ArrayList<Integer>();

    public ShapeModel(){}

    public ShapeModel(Integer id, String type, List<Integer> sides) {
        this.id = id;
        this.type = type;
        this.sides = sides;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getSides() {
        return sides;
    }

    public void setSides(List<Integer> sides) {
        this.sides = sides;
    }
}
