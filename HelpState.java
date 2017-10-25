package com.gorilla.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gorilla.game.Gorilla;

/**
 * Created by chaac on 10/21/2017.
 */

public class HelpState extends State{

    private Texture texture;

    public HelpState(GameStateManager gam) {
        super(gam);
         texture = new Texture("helpbackground.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            if((Gdx.input.getX() <= 80 && Gdx.input.getX() >= 24) && (Gdx.input.getY() <= 72  && Gdx.input.getY() >= 24)) {
                gsm.set(new MenuState(gsm));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(texture,0,0, Gorilla.WIDTH, Gorilla.HEIGHT);
        sb.end();

    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
