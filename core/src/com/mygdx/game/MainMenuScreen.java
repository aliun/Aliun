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

		guiCam = new OrthographicCamera(1080, 1921); 
		guiCam.position.set(1080 / 2, 1921 / 2, 0);
		
		CreateBounds = new Rectangle   ((1080-480)/2, 1150, 480, 200); 
		VisitBounds = new Rectangle    ((1080-480)/2, 900, 480, 200);
		AboutBounds = new Rectangle    ((1080-480)/2, 650, 480, 200);
		HelpBounds = new Rectangle     ((1080-480)/2, 400, 480, 200);
		
		
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
		game.batch.draw(Assets.backgroundRegion, 0, 0, 1080, 1921);
		game.batch.end();

		game.batch.enableBlending();
		game.batch.begin();
		
		game.batch.draw(Assets.create,  (1080-480)/2, 1150, 480, 200);  
		game.batch.draw(Assets.visit,   (1080-480)/2, 900, 480, 200); 
		game.batch.draw(Assets.help,    (1080-480)/2, 650, 480, 200);  
		game.batch.draw(Assets.about,   (1080-480)/2, 400, 480, 200); 
		
		game.batch.draw(Assets.logo,   (1080-780)/2, 1400, 780, 390); 
		
		game.batch.draw(Settings.soundEnabled ? Assets.soundon : Assets.soundoff, 20, 20, 120, 120);
		
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
