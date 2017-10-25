package com.gorilla.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gorilla.game.Gorilla;
import com.gorilla.game.sprites.pets;

/**
 * Created by chaac on 10/23/2017.
 */

public class AnimationState extends State{
    private Texture background;
    private Animation<TextureRegion> animation;
    private Animation<TextureRegion> foods;
    private float dt = 0;
    private pets pet;
    private Texture food;

    private TextureAtlas bananaAtlas;
    private TextureAtlas appleAtlas;
    private TextureAtlas leafAtlas;
    private TextureAtlas burgerAtlas;

    public AnimationState(GameStateManager gam, int x, pets a) {
        super(gam);
        this.gsm = gam;
        pet = a;
        animation = new Animation(1f/1.25f, pet.getAtlas().getRegions());
        background = new Texture("playbackground1.png");
        food = new Texture("food.png");

        bananaAtlas = new TextureAtlas(Gdx.files.internal("bananaAnimation.atlas"));
        appleAtlas = new TextureAtlas(Gdx.files.internal("appleAnimation.atlas"));
        burgerAtlas = new TextureAtlas(Gdx.files.internal("burgerAnimation.atlas"));
        leafAtlas = new TextureAtlas(Gdx.files.internal("leafAnimation.atlas"));

        if(x == 1)
            foods = new Animation(1f/.75f, bananaAtlas.getRegions());
        if(x == 2)
            foods = new Animation(1f/.75f, appleAtlas.getRegions());
        if(x == 3)
            foods = new Animation(1/.75f, leafAtlas.getRegions());
        if(x == 4)
            foods = new Animation(1/.75f, burgerAtlas.getRegions());

    }

    @Override
    protected void handleInput() {
        if(dt > 5){
            gsm.set(new PlayState(gsm,pet));
            dispose();
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
        sb.draw(foods.getKeyFrame(dt,false),300,460);
        sb.end();
    }

    @Override
    public void dispose() {
        food.dispose();
        background.dispose();
    }
}
