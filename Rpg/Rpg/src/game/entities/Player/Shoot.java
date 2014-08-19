package game.entities;

public class Bullet extends Entity{

    boolean shot = false;
    int direction;

    public void tick() {
        int xa = player.xa;
		int ya = player.ya;
		if (input.SUp.isPressed()){
			if(!hit){
			    direction=0;
			}
		}
		
		if (input.SDown.isPressed()) {
			if(!hit){
			    direction=2;
			}
		}
		
		if (input.SLeft.isPressed()) {
			if(!hit){
			    direction=3;
			}
		}
		
		if (input.SRight.isPressed()) {
			if(!hit){
			    direction=1;
			}
		}

		if ( input.SUp.isPressed() || input.SDown.isPressed() || input.SLeft.isPressed() || input.SRight.isPressed() ) {
			if(shot){
			    level.addEntity(Bullet);
			    shot=true;
			}
		} else {
			shot = false;
		}
    }

}