package pe.rmlabs.amana.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

@Deprecated
public class SpriteStoreOld {
	
	private static Map<String, byte[]> resourcesMap;
	
	public static Map<String, byte[]> getResourcesMap() {
		return resourcesMap;
	}

	public static void loadResources() throws IOException{
		resourcesMap = new HashMap<String, byte[]>();
		loadRscFile("rsc\\am.rsc");
		loadRscFile("rsc\\pilot.rsc");
		loadRscFile("rsc\\item.rsc");
		loadRscFile("rsc\\mode.rsc");
		loadRscFile("rsc\\map.rsc");
		loadRscFile("rsc\\misc.rsc");
	}

	private static void loadRscFile(String filePath) throws IOException {
		ZipFile zipFile = new ZipFile(filePath);
		Enumeration<? extends ZipEntry> en = zipFile.entries();
		ZipEntry o;
		while (en.hasMoreElements()) {
			o = en.nextElement();
			InputStream is = zipFile.getInputStream(o);
			byte[] bytes = IOUtils.toByteArray(is);
			resourcesMap.put(o.getName(), bytes);
			//JOptionPane.showMessageDialog(null, o.getName(),null, JOptionPane.PLAIN_MESSAGE, new ImageIcon(bytes));
		}
		zipFile.close();
		System.out.println(filePath+" loaded successfully");
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("START");
		loadResources();
		System.out.println("END");
	}

}
