package game.entities;

import game.gfx.Colours;
import game.gfx.Screen;
import game.gfx.SpriteSheet;
import game.level.Level;

import static game.entities.Direction.*;

public class Bullet extends Entity {

	private SpriteSheet sheet;
	private Direction direction;
	private int colour = Colours.get(-1, 333, 555, 200);
	
	public Bullet(Level level, SpriteSheet sheet, int x, int y, Direction direction) {
		super(level);
		this.sheet = sheet;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void tick() {
		if (direction == UP) {
			y = y - 2;
		}
		if (direction == DOWN) {
			y = y + 2;
		}
		if (direction == LEFT) {
			x = x - 2;
		}
		if (direction == RIGHT) {
			x = x + 2;
		}
}

	@Override
	public void render(Screen screen) {
		screen.render(sheet, x, y, 0, colour);
	}
	
}
