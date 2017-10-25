package com.gorilla.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by chaac on 10/16/2017.
 */

public abstract class State {
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gam){
        this.gsm = gam;
        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
