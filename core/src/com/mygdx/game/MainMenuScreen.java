package  com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen extends ScreenAdapter implements InputProcessor{
	AliunGame game;
	OrthographicCamera guiCam;
	Rectangle CreateVisitBounds;
	Rectangle AboutBounds;
	Rectangle HelpBounds;
	Rectangle SoundBounds;
	Rectangle MusicBounds;
	Boolean CreateVisitOn = false, AboutOn = false, HelpOn = false, SoundOn = false, MusicOn = false;
	Vector3 touchPoint;

	public MainMenuScreen (AliunGame game) {
		this.game = game;

		guiCam = new OrthographicCamera(1080, 1921); 
		guiCam.position.set(1080 / 2, 1921 / 2, 0);
		
		CreateVisitBounds = new Rectangle   ((1080-480)/2, 1150, 480, 200); 
		AboutBounds = new Rectangle    ((1080-480)/2, 350, 480, 200);
		HelpBounds = new Rectangle     ((1080-480)/2, 600, 480, 200);
		SoundBounds = new Rectangle (20, 20, 120, 120);
		MusicBounds = new Rectangle (1080-140, 20, 120, 120);
		
		
		touchPoint = new Vector3();
	
		Gdx.input.setInputProcessor(this);
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
		
		game.batch.draw(Assets.logo,   (1080-780)/2, 1400, 780, 390); 

		if (CreateVisitOn)
		game.batch.draw(Settings.aliunCreated ? Assets.onvisit : Assets.oncreate, (1080-480)/2, 1150, 480, 200);
		else
		game.batch.draw(Settings.aliunCreated ? Assets.visit : Assets.create, (1080-480)/2, 1150, 480, 200);	
		
		
		game.batch.draw(HelpOn ? Assets.onhelp : Assets.help,    (1080-480)/2, 600, 480, 200);  
		game.batch.draw(AboutOn ? Assets.onabout : Assets.about,   (1080-480)/2, 350, 480, 200); 
		
		
		if (SoundOn)
		game.batch.draw(Settings.soundEnabled ? Assets.onsoundon : Assets.onsoundoff, 20, 20, 120, 120);
		else
		game.batch.draw(Settings.soundEnabled ? Assets.soundon : Assets.soundoff, 20, 20, 120, 120);
		
		
		if (MusicOn)
		game.batch.draw(Settings.musicEnabled ? Assets.onmusicon : Assets.onmusicoff, 1080-140, 20, 120, 120);
		else
		game.batch.draw(Settings.musicEnabled ? Assets.musicon : Assets.musicoff, 1080-140, 20, 120, 120);
		
		
		game.batch.end();	
	}

	@Override
	public void render (float delta) {
		draw();
	}

	@Override
	public void pause () {
		Settings.save();
	}

	
	

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		CreateVisitOn = false;
		HelpOn = false;
		AboutOn = false;
		MusicOn = false;
		SoundOn = false;
		
		float x = 1000 * screenX / (Gdx.graphics.getWidth());
		float y = 1000 * screenY / (Gdx.graphics.getHeight());
		
		
		screenX = Math.round(x*1.08f);
		screenY = Math.round(1921-y*1.921f);
		
		
		if (CreateVisitBounds.contains(screenX, screenY)) CreateVisitOn = true;
		if (AboutBounds.contains(screenX, screenY)) AboutOn = true;
		if (HelpBounds.contains(screenX, screenY)) HelpOn = true;
		if (SoundBounds.contains(screenX, screenY)) SoundOn = true;
		if (MusicBounds.contains(screenX, screenY)) MusicOn = true;
		
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		CreateVisitOn = false;
		HelpOn = false;
		AboutOn = false;
		MusicOn = false;
		SoundOn = false;
		
		
		float x = 1000 * screenX / (Gdx.graphics.getWidth());
		float y = 1000 * screenY / (Gdx.graphics.getHeight());
		
		
		screenX = Math.round(x*1.08f);
		screenY = Math.round(1921-y*1.921f);
		
		
		if (CreateVisitBounds.contains(screenX, screenY)) {

			//Assets.playSound(Assets.click);
				
			if (Settings.aliunCreated) game.setScreen(new VisitScreen(game));
			else game.setScreen(new CreateScreen(game));
		}
			
		if (HelpBounds.contains(screenX, screenY)) {

			//Assets.playSound(Assets.click);
				
			game.setScreen(new HelpScreen(game));
		}
			
		if (AboutBounds.contains(screenX, screenY)) {
				
			//Assets.playSound(Assets.click);
				
			game.setScreen(new AboutScreen(game));
		}
			
		if (SoundBounds.contains(screenX, screenY)) {
				
			//Assets.playSound(Assets.click);
			
			Settings.soundEnabled = ! Settings.soundEnabled;
				
		}
			
		if (MusicBounds.contains(screenX, screenY)) {
				
			//Assets.playSound(Assets.click);
				
			if (Settings.musicEnabled) Assets.music.stop();
			else Assets.music.play();
				
			Settings.musicEnabled = ! Settings.musicEnabled;
		}
			
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
