package com.gorilla.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gorilla.game.Gorilla;
import com.gorilla.game.sprites.pets;

/**
 * Created by chaac on 10/16/2017.
 */

public class MenuState extends State{
    private Texture background;
    private Texture button;
    private Sprite sprite;
    private pets pet;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        pet = new pets();
        background = new Texture("background1.png");
        button = new Texture("MenuButton.png");
        sprite = new Sprite(button);
        sprite.setPosition(0,0);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            if((Gdx.input.getX() <= 311 && Gdx.input.getX() >= 160) && (Gdx.input.getY() <= 325 && Gdx.input.getY() >= 240)) {
                gsm.set(new PlayState(gsm,pet));
                dispose();
            }
        }
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            if((Gdx.input.getX() <= 311 && Gdx.input.getX() >= 160) && (Gdx.input.getY() <= 560  && Gdx.input.getY() >= 480)) {
                gsm.set(new HelpState(gsm));
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
        sb.draw(background,0,0, Gorilla.WIDTH, Gorilla.HEIGHT);
        sb.draw(sprite, 1,0);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        button.dispose();
    }
}
