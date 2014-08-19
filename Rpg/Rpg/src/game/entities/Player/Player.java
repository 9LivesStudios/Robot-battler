package game.entities;

import game.InputHandler;
import game.gfx.Colours;
import game.gfx.Screen;
import game.level.Level;

public class Player extends Mob {

	private InputHandler input;
	private int colour = Colours.get(-1, 333, 444, 000);

	public Player(Level level, int x, int y, InputHandler input) {
		super(level, "Player", x, y, 1);
		this.input = input;
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

	public void render(Screen robot1Res) {
		int xTile = 0;
		int yTile = 28;
		
		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;
		
		robot1Res.render(xOffset, yOffset, xTile + yTile * 32, colour);
		robot1Res.render(xOffset + modifier, yOffset, (xTile + 1) + yTile * 32, colour);
		
		robot1Res.render(xOffset, yOffset + modifier, xTile + (yTile + 1) * 32, colour);
		robot1Res.render(xOffset + modifier, yOffset + modifier, (xTile + 1) + (yTile + 1) * 32, colour);
	}

	public boolean hasCollided(int xa, int ya) {
		int xMin = 0;
		int xMax = 15;
		int yMin = 0;
		int yMax = 7;
		for (int x = xMin; x < xMax;x++){
			if (isSolidTile(xa, ya, x, yMin)) {
				return true;
			}
		}
		for (int x = xMin; x < xMax;x++){
			if (isSolidTile(xa, ya, x, yMax)) {
				return true;
			}
		}
		for (int y = yMin; x < yMax;y++){
			if (isSolidTile(xa, ya, xMin, y)) {
				return true;
			}
		}
		for (int y = yMin; x < yMax;y++){
			if (isSolidTile(xa, ya, xMax, y)) {
				return true;
			}
		}
		return false;
	}

}
