package game.entities;

import game.gfx.Colours;
import game.gfx.Screen;
import game.gfx.SpriteSheet;
import game.level.Level;

import static game.entities.Direction.*;

public class Bullet extends Entity {

	private SpriteSheet sheet;
	private Direction direction;
	private int colour = Colours.get(-1, 444, 555, 450);
	
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
		int mirrorDir = 0;
		int sprite = 0;
		switch (direction) {
		case DOWN:
			mirrorDir = Screen.BIT_MIRROR_Y;
			break;
		case LEFT:
			sprite =  1;
			mirrorDir = screen.BIT_MIRROR_X;
			break;
		case RIGHT:
			sprite = 1;
			break;
		case UP:
			break;
		}
		screen.render(sheet, x, y, sprite, colour, mirrorDir);
	}
	
}
