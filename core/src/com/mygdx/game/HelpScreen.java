package  com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class HelpScreen extends ScreenAdapter {
	AliunGame game;
	OrthographicCamera guiCam;
	
	//Rectangle CreateBounds;

	Vector3 touchPoint;

	public HelpScreen (AliunGame game) {
		this.game = game;

		guiCam = new OrthographicCamera(1600, 6000); //podesi ove koordinate
		guiCam.position.set(1600 / 2, 6000 / 2, 0);
		
		//CreateBounds = new Rectangle   ((1600-1560)/2, (1600+1560)/2, 0, 700); 
		
		
		touchPoint = new Vector3();
	}

	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			
			//if (CreateBounds.contains(touchPoint.x, touchPoint.y)) {
				
				//Assets.playSound(Assets.clickSound);
				//game.setScreen(new GameScreen(game));
				
				//return;
			//}
			
			
		}
	}

	public void draw () {
		
		GL20 gl = Gdx.gl;
		gl.glClearColor(0, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		game.batch.setProjectionMatrix(guiCam.combined);

		game.batch.disableBlending();
		game.batch.begin();
		//game.batcher.draw(Assets.backgroundRegion, 0, 0, 320, 480);
		game.batch.end();

		game.batch.enableBlending();
		game.batch.begin();
		
		//game.batch.draw(Assets.create,  (1600-1560)/2, 2820, 1560,  705);
		
		//game.batcher.draw(Settings.soundEnabled ? Assets.soundOn : Assets.soundOff, 0, 0, 64, 64);
		
		game.batch.end();	
	}

	@Override
	public void render (float delta) {
		update();
		draw();
	}

	@Override
	public void pause () {
		Settings.save();
	}
}
