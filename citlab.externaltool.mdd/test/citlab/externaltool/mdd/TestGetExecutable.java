package citlab.externaltool.mdd;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestGetExecutable {

	@Test
	public void testNotInPath() {
		//
		String oldPath = emptyPath();
		TSGeneratorByMedici tg = new TSGeneratorByMedici();
		try {
			System.out.println(tg.getMddExecutable());
		} catch (Throwable t) {
			System.out.println(t.toString());
			return;
		} finally {
			restorePath(oldPath);
		}
		fail("medici should not found");
	}

	@Test
	public void testmediciAddedInPath() {
		// it works on my machine AG
		String oldPath = addToPath("C:\\Users\\garganti\\Dropbox\\code\\citlab_svn\\medici\\binaries");
		TSGeneratorByMedici tg = new TSGeneratorByMedici();
		try {
			tg.getMddExecutable();
		} catch (Throwable t) {
			fail("medici should be found");
		} finally {
			restorePath(oldPath);
		}
	}

	private String addToPath(String string) {
		Map<String, String> env = new HashMap<String, String>(System.getenv());
		String oldPath = env.get("Path");
		env.put("Path", oldPath + ";" + string);
		System.out.println(System.getenv().get("Path"));
		return oldPath;
	}

	private void restorePath(String oldPath) {
		Map<String, String> env = new HashMap<String, String>(System.getenv());
		env.put("Path", oldPath);
	}

	private String emptyPath() {
		Map<String, String> env = new HashMap<String, String>(System.getenv());
		String oldPath = env.get("Path");
		env.put("Path", "");
		return oldPath;
	}

}
