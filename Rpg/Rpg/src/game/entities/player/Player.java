package game.entities.player;

import game.InputHandler;
import game.entities.Bullet;
import game.entities.Direction;
import game.entities.Mob;
import game.gfx.Colours;
import game.gfx.Screen;
import game.gfx.SpriteSheet;
import game.level.Level;

public class Player extends Mob {

	private InputHandler input;
	private SpriteSheet playerSheet;
	private SpriteSheet bulletSheet;
	private int colour = Colours.get(-1, 333, 444, 000);
	private int cooldown = 0;
	private Direction direction;

	public Player(Level level, SpriteSheet playerSheet, SpriteSheet bulletSheet, int x, int y, InputHandler input, Direction direction) {
		super(level, "Player", x, y, 1);
		this.input = input;
		this.playerSheet = playerSheet;
		this.bulletSheet = bulletSheet;
		this.direction = direction;
	}

	public void tick() {
		int xa = 0;
		int ya = 0;
		if (input.MUp.isPressed()) {
			ya--;
			direction = Direction.UP;
		}
		if (input.MDown.isPressed()) {
			ya++;
			direction = Direction.DOWN;
		}
		if (input.MLeft.isPressed()) {
			xa--;
			direction = Direction.LEFT;
		}
		if (input.MRight.isPressed()) {
			xa++;
			direction = Direction.RIGHT;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			isMoving = true;
		} else {
			isMoving = false;
		}
		if (cooldown == 0) {
			if (input.SUp.isPressed()) {
				level.addEntity( new Bullet(level, bulletSheet, x, y, Direction.UP));
				cooldown = 20;
			}
			if (input.SDown.isPressed()) {
				level.addEntity( new Bullet(level, bulletSheet, x, y, Direction.DOWN));
				cooldown = 20;
			}
			if (input.SLeft.isPressed()) {
				level.addEntity( new Bullet(level, bulletSheet, x, y, Direction.LEFT));
				cooldown = 20;
			}
			if (input.SRight.isPressed()) {
				level.addEntity( new Bullet(level, bulletSheet, x, y, Direction.RIGHT));
				cooldown = 20;
			}
		}
		if (cooldown > 0) {
			cooldown--;
		}
			
	}

	public void render(Screen screen) {
		int xTile = 0;
		int yTile = 0;
		
		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;
		
		switch (direction) {
		case DOWN:
			break;
		case LEFT:
			break;
		case RIGHT:
			break;
		case UP:
			xTile = xTile + 2;
			break;
		}
		
		screen.render(playerSheet, xOffset, yOffset, xTile + yTile * 32, colour);
		screen.render(playerSheet, xOffset + modifier, yOffset, (xTile + 1) + yTile * 32, colour);
		
		screen.render(playerSheet, xOffset, yOffset + modifier, xTile + (yTile + 1) * 32, colour);
		screen.render(playerSheet, xOffset + modifier, yOffset + modifier, (xTile + 1) + (yTile + 1) * 32, colour);
	}

	public boolean hasCollided(int xa, int ya) {
		return false;
	}

}
