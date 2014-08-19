package game.level.tiles;

public class BasicSolidTile extends BasicTile {
    
    public BasicSolidTile(int id, int x, int y, int tileColour){
    super(id, x, y, tileColour);
    this.solid = true;
    
    }
}