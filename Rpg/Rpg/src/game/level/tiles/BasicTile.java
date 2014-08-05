package game.level.tiles;

import game.gfx.Screen;
import game.level.Level;

public class BasicTile extends Tile {

	protected int tileid;
	protected int tileColour;

	public BasicTile(int id, int x, int y, int tileColour) {
		super(id, false, false);
		this.tileid = x + y;
		this.tileColour = tileColour;
	}

	public void render(Screen screen, Level level, int x, int y) {
		screen.render(x, y, tileid, tileColour);
	}

}