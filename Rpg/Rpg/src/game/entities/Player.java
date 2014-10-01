package game.entities;

import game.InputHandler;
import game.gfx.Colours;
import game.gfx.Screen;
import game.gfx.SpriteSheet;
import game.level.Level;

public class Player extends Mob {

	private InputHandler input;
	private SpriteSheet sheet;
	private int colour = Colours.get(-1, 333, 444, 000);

	public Player(Level level, SpriteSheet sheet, int x, int y, InputHandler input) {
		super(level, "Player", x, y, 1);
		this.input = input;
		this.sheet = sheet;
	}

	public void tick() {
		int xa = 0;
		int ya = 0;
		if (input.MUp.isPressed())
			ya--;
		if (input.MDown.isPressed())
			ya++;
		if (input.MLeft.isPressed())
			xa--;
		if (input.MRight.isPressed())
			xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			isMoving = true;
		} else {
			isMoving = false;
		}
	}

	public void render(Screen screen) {
		int xTile = 0;
		int yTile = 0;
		
		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;
		
		screen.render(sheet, xOffset, yOffset, xTile + yTile * 32, colour);
		screen.render(sheet, xOffset + modifier, yOffset, (xTile + 1) + yTile * 32, colour);
		
		screen.render(sheet, xOffset, yOffset + modifier, xTile + (yTile + 1) * 32, colour);
		screen.render(sheet, xOffset + modifier, yOffset + modifier, (xTile + 1) + (yTile + 1) * 32, colour);
	}

	public boolean hasCollided(int xa, int ya) {
		return false;
	}

}
