package  com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen extends ScreenAdapter {
	AliunGame game;
	OrthographicCamera guiCam;
	Rectangle CreateBounds;
	Rectangle VisitBounds;
	Rectangle OptionsBounds;
	Rectangle AboutBounds;
	Rectangle HelpBounds;
	Vector3 touchPoint;

	public MainMenuScreen (AliunGame game) {
		this.game = game;

		guiCam = new OrthographicCamera(4500, 8000); 
		guiCam.position.set(4500 / 2, 8000 / 2, 0);
		
		CreateBounds = new Rectangle   ((4500-480)/2, 4000, 480, 200); 
		VisitBounds = new Rectangle    ((4500-480)/2, 5000, 480, 200);
		AboutBounds = new Rectangle    ((4500-480)/2, 6000, 480, 200);
		HelpBounds = new Rectangle     ((4500-480)/2, 7000, 480, 200);
		
		
		touchPoint = new Vector3();
	}

	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			
			if (CreateBounds.contains(touchPoint.x, touchPoint.y)) {

				Assets.playSound(Assets.click);
				game.setScreen(new CreateScreen(game));
				
				return;
			}
			
			if (VisitBounds.contains(touchPoint.x, touchPoint.y)) {

				Assets.playSound(Assets.click);
				game.setScreen(new VisitScreen(game));
				
				return;
			}
			
			
			if (HelpBounds.contains(touchPoint.x, touchPoint.y)) {

				Assets.playSound(Assets.click);
				
				game.setScreen(new HelpScreen(game));
				
				return;
			}
			
			if (AboutBounds.contains(touchPoint.x, touchPoint.y)) {
				
				Assets.playSound(Assets.click);
				
				game.setScreen(new AboutScreen(game));
				
				return;
			}
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
		game.batch.draw(Assets.backgroundRegion, 0, 0, 4500, 8000);
		game.batch.end();

		game.batch.enableBlending();
		game.batch.begin();
		
		game.batch.draw(Assets.create,  (4500-480)/2, 4000, 480, 200); 
		game.batch.draw(Assets.visit,   (4500-480)/2, 5000, 480, 200); 
		game.batch.draw(Assets.help,    (4500-480)/2, 6000, 480, 200); 
		game.batch.draw(Assets.about,   (4500-480)/2, 7000, 480, 200); 
		
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
