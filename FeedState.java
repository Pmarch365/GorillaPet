package com.gorilla.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gorilla.game.Gorilla;
import com.gorilla.game.sprites.pets;

/**
 * Created by chaac on 10/21/2017.
 */

public class FeedState extends State {

    private Texture background;
    private Animation<TextureRegion> animation;
    private float dt = 0;
    private Texture food;
    private double rand;
    private pets pet;

    public FeedState(GameStateManager gam, pets a) {
        super(gam);
        this.gsm = gam;
        pet = a;
        animation = new Animation(1f/1.25f, pet.getAtlas().getRegions());
        background = new Texture("playbackground1.png");
        food = new Texture("food.png");
        rand = Math.random();
    }

    @Override
    protected void handleInput() {
        if (dt >= .25) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if ((Gdx.input.getX() <= 80 && Gdx.input.getX() >= 24) && (Gdx.input.getY() <= 72 && Gdx.input.getY() >= 24)) {
                    gsm.set(new PlayState(gsm,pet));
                    dispose();
                }
            }
            //banana
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if ((Gdx.input.getX() <= 200 && Gdx.input.getX() >= 88) && (Gdx.input.getY() <= 560 && Gdx.input.getY() >= 440)) {
                    if (pet.getEnergy() + 1 >= 10) {
                        pet.setEnergy(10);
                        gsm.set(new AnimationState(gsm,1,pet));
                        dispose();

                    } else {
                        pet.setEnergy(pet.getEnergy() + 1);
                        gsm.set(new AnimationState(gsm,1,pet));
                        dispose();
                    }
                }
            }
            //apple
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if ((Gdx.input.getX() <= 400 && Gdx.input.getX() >= 280) && (Gdx.input.getY() <= 560 && Gdx.input.getY() >= 440)) {
                    if (pet.getEnergy() + 2 >= 10) {
                        pet.setEnergy(10);
                        gsm.set(new AnimationState(gsm,2,pet));
                        dispose();

                    } else {
                        pet.setEnergy(pet.getEnergy() + 2);
                        gsm.set(new AnimationState(gsm,2,pet));
                        dispose();
                    }
                }
            }
            //leaf
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if ((Gdx.input.getX() <= 200 && Gdx.input.getX() >= 88) && (Gdx.input.getY() <= 720 && Gdx.input.getY() >= 600)) {
                    if (pet.getEnergy() + 3 >= 10) {
                        pet.setEnergy(10);
                        gsm.set(new AnimationState(gsm,3,pet));
                        dispose();

                    } else {
                        pet.setEnergy(pet.getEnergy() + 3);
                        gsm.set(new AnimationState(gsm,3,pet));
                        dispose();
                    }
                }
            }
            //burger
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if ((Gdx.input.getX() <= 400 && Gdx.input.getX() >= 280) && (Gdx.input.getY() <= 720 && Gdx.input.getY() >= 600)) {
                    if(rand >= .4) {
                        if (pet.getEnergy() + 5 >= 10) {
                            pet.setEnergy(10);
                            gsm.set(new AnimationState(gsm, 4,pet));
                            dispose();

                        } else {
                            pet.setEnergy(pet.getEnergy() + 5);
                            gsm.set(new AnimationState(gsm, 4,pet));
                            dispose();
                        }
                    }
                    else{
                        pet.setEnergy(pet.getEnergy() - 5);
                        if(pet.getEnergy() <= 0)
                            pet.setEnergy(0);
                        gsm.set(new AnimationState(gsm, 4, pet));
                        pet.setClean(false);
                        dispose();
                    }
                }
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
        dt += Gdx.graphics.getDeltaTime();
        sb.draw(background,0,0, Gorilla.WIDTH, Gorilla.HEIGHT);
        sb.draw(animation.getKeyFrame(dt,true), (Gorilla.WIDTH / 2)- 80, Gorilla.HEIGHT/2 +25);
        sb.draw(food,0,0, Gorilla.WIDTH, Gorilla.HEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {
        food.dispose();
        background.dispose();
    }
}
