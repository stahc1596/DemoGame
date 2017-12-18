package com.cameron.demogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DemoGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
        private float x;
        private float y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("slide_5.jpg");
                x = 0;
                y = 0;
	}

	@Override
	public void render () {
            //Keyboard stuff
                if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                    x = x + 1;
                }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                    x = x - 1;
                }
                //Mouse/Touch stuff
                if(Gdx.input.isTouched()){
                    int mouseX = Gdx.input.getX();
                    if(mouseX > Gdx.app.getGraphics().getWidth()/2){
                        x = x + 1;
                    }else if(mouseX < Gdx.app.getGraphics().getWidth()/2){
                        x = x - 1;
                    }
                }
            
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y, 700, 500);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
