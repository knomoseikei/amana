package pe.rmlabs.amana.loader;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SpriteStore {

	private static SpriteStore single = new SpriteStore();
	private static final String PATH = "pe/rmlabs/amana/sprites/";

	private SpriteStore() {
	}

	public static SpriteStore get() {
		return single;
	}

	private HashMap<String, ImageIcon> sprites = new HashMap<String, ImageIcon>();

	public Icon getSprite(String ref) throws Exception {
		if (sprites.get(ref) != null) {
			return sprites.get(ref);
		}

		ImageIcon sourceImage = null;

		try {
			URL url = this.getClass().getClassLoader().getResource(PATH + ref);

			if (url == null) {
				throw new Exception("Can't find ref: " + PATH + ref);
			}

			sourceImage = new ImageIcon(url);
		} catch (IOException e) {
			throw new Exception("Failed to load: " + PATH + ref, e);
		}

		sprites.put(ref, sourceImage);

		return sourceImage;
	}
	
//	public static void main(String args[]){
//		try {
//			JOptionPane.showMessageDialog(null, new JLabel(get().getSprite(ItemConst.ATLAS.getImage())));
//		} catch (HeadlessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
