package com.gorilla.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gorilla.game.Gorilla;
import com.gorilla.game.sprites.pets;

/**
 * Created by chaac on 10/17/2017.
 */

public class PlayState extends State {
    //private Texture gorilla;
    private Texture background;
    private Animation<TextureRegion> animation;
    private float dt = 0;
    private pets pet;
    private BitmapFont font;
    private float textWidth;

    public PlayState(GameStateManager gam, pets a) {
        super(gam);
        this.gsm = gam;
        pet = a;
        animation = new Animation(1f/1.25f, pet.getAtlas().getRegions());
        //gorilla = new Texture("babygorilla500.png");
        background = new Texture("plyback.png");
        font = new BitmapFont(Gdx.files.internal("letters.fnt"),false);
        GlyphLayout layout = new GlyphLayout(font, "Goober");
        textWidth = layout.width;
    }

    @Override
    protected void handleInput() {
        System.out.println(pet.getClean());
        System.out.println(pet.getEnergy());
        if (dt >= .25) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if ((Gdx.input.getX() <= 80 && Gdx.input.getX() >= 24) && (Gdx.input.getY() <= 72 && Gdx.input.getY() >= 24)) {
                    gsm.set(new MenuState(gsm));
                    dispose();
                }
            }


            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if ((Gdx.input.getX() <= 232 && Gdx.input.getX() >= 88) && (Gdx.input.getY() <= 600 && Gdx.input.getY() >= 544)) {
                    if(pet.getClean() == true) {
                        gsm.set(new FeedState(gsm,pet));
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
        font.draw(sb,"Goober", (Gorilla.WIDTH/2) - (textWidth/2), 725+font.getCapHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        //gorilla.dispose();
        background.dispose();
    }
}
