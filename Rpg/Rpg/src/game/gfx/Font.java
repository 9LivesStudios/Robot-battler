package game.gfx;

public class Font {

	@SuppressWarnings("unused")
	private static String chars = "" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ      "
			+ "0123456789.,:;'\"!?$%()-=+/      ";

	public static void render(String msg, Screen screen, int x, int y,
			int colour) {
		msg = msg.toUpperCase();
	}
}
