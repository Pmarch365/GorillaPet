package com.gorilla.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by chaac on 10/18/2017.
 */

public class pets {
    private String name;
    private int energy;
    private int smart;
    private int age;
    private int money;
    private boolean clean;
    //private Texture texture;
    private TextureAtlas gorillaAtlas;


    public pets(){
        energy = 10;
        smart = 0;
        age = 0;
        money = 0;
        clean = true;
       // texture = new Texture("gorilla500.png");
        gorillaAtlas = new TextureAtlas(Gdx.files.internal("gorillaz.atlas"));
    }

    public int getEnergy(){
        return energy;
    }

    public void setEnergy(int x){energy = x; }

    public int getSmart(){
        return smart;
    }

    public int getAge(){
        return age;
    }

    public int getMoney(){
        return money;
    }

    /*public Texture getTexture(){
        return texture;
    } */

    public String getName() {
        return name; }

    public TextureAtlas getAtlas(){
        return gorillaAtlas;
    }

    public void setAtlas(String x){
        gorillaAtlas = new TextureAtlas(Gdx.files.internal(x));
    }

    public boolean getClean(){
        return clean;
    }

    public void setClean(boolean x){
        clean = x;
        if(clean == false)
            setAtlas("dirtybby1.atlas");
        else
            setAtlas("gorillaz.atlas");
    }
}
