/*******************************************************************************
 * Copyright (c) 2013 University of Bergamo - Italy
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
package citlab.model.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import citlab.model.CitLStandaloneSetupGenerated;
import citlab.model.citL.CitModel;

import com.google.inject.Injector;

public class ModelsFromFilesUtils {

	// validate the models when loading them
	// it can cause some errors when using JAR files produced by the eclipse
	// exporter
	public static boolean VALIDATE = true;

	/**
	 * get all the models, useful for testing other stuff with the basic
	 * examples These models are in the citlab.model.tests directory (not in the
	 * benchmark)
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Iterator<CitModel> getExamples() throws IOException {
		File directory = getDirWithRelativePath("examples");
		return getModelsInDir(directory);

	}

	/**
	 * get all the models, useful for testing other stuff with the basic
	 * examples These models are in the citlab.model.tests directory (not in the
	 * benchmark)
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Iterator<CitModel> getTestModels(String path) throws IOException {
		File directory = getDirWithRelativePath(path);
		return getModelsInDir(directory);

	}

	
	/**
	 * Gets the test model - again in citlab.model.tests directory (not in the
	 * benchmark)
	 * 
	 * @param path
	 *            the name of the subdir (relative to the project)
	 * @param name
	 *            the name of the file
	 * @return the example
	 * @throws IOException
	 */
	public static CitModel getTestModel(String path, String name)
			throws IOException {
		String file = getDirWithRelativePath(path).toPath() + File.separator
				+ name;
		return loadModel(file);
	}

	/**
	 * return the benchmark (official) with name mname
	 * 
	 * @param mname
	 * @param constrained
	 *            TODO
	 * @return
	 * @throws IOException
	 */
	public static CitModel getBenchmark(String mname, boolean constrained)
			throws IOException {
		File path = getBenchmarkDir();
		String subDirPath = path.toPath() + File.separator
				+ (constrained ? "constrained" : "unconstrained");
		// System.out.println(path.getAbsolutePath());
		return loadModel(subDirPath + File.separator + mname);
	}

	/**
	 * get all the benchmarks
	 * 
	 * @param constrained
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Iterator<CitModel> getBenchmarks(boolean constrained)
			throws IOException {
		File path = getBenchmarkDir();
		String subDirPath = path.toPath() + File.separator
				+ (constrained ? "constrained" : "unconstrained");
		File subDir = new File(subDirPath);
		assert subDir.exists();
		assert subDir.isDirectory();
		return getModelsInDir(subDir);

	}
	public static Iterator<CitModel> getSPLBenchmarks(boolean simplified)
			throws IOException {
		File path = getBenchmarkDir();
		String subDirPath =null;
		if (simplified){
		subDirPath = path.toPath() + File.separator
				+ "SPLOT";}else{
	    subDirPath = path.toPath() + File.separator
					+ "SPLnotSIMPLIFIED";	}
		File subDir = new File(subDirPath);
		assert subDir.exists();
		assert subDir.isDirectory();
		return getModelsInDir(subDir);

	}
	// get the directory with a relative PATH from this project
	// (citlab.model.tests)
	private static File getDirWithRelativePath(String relativePath)
			throws IOException {
		URL thisClassDir = ModelsFromFilesTester.class.getResource(".");
		System.out.println(thisClassDir.getPath());
		// thisClassDir can be null (for example if a Jar)
		// what to to do in that case ???
		assertNotNull(thisClassDir);
		// FROM IDE (from another project too
		// logger.debug("project dir = " + thisClassDir.getPath());
		// be careful, it depends on the package as well
		
		String projectDirS = thisClassDir.getPath() + "../../../../"
				+ relativePath;
		projectDirS =  URLDecoder.decode(projectDirS, "utf-8");
		File projectDir = new File(projectDirS);
		// logger.debug("project dir = " + projectDir.getCanonicalPath());
		// if it does not exist try the
		if (projectDir.exists()) {
			assertTrue(projectDir.isDirectory());
			return projectDir;
		}
		// otherwise
		throw new IOException("dir " + projectDir.getCanonicalPath() + " not found");
	}

	// get the directory with the benchmarks
	private static File getBenchmarkDir() throws IOException {
		URL thisClassDir = ModelsFromFilesTester.class.getResource(".");
		// thisClassDir can be null (for example if a Jar)
		// what to to do in that case ???
		// search in a dir with name "citlab.benchmarks"
		if (thisClassDir == null) {
			// otherwise search in the citlab.benchmarkk dir (useful for jar and
			// experiments)
			File projectDir = new File("citlab.benchmarks");
			System.out.println("benchmark dir = "
					+ projectDir.getCanonicalPath());
			if (projectDir.exists()) {
				assertTrue(projectDir.isDirectory());
				return projectDir;
			}
		}
		// FROM IDE (from another project too
		// logger.debug("project dir = " + thisClassDir.getPath());
		// be careful, it depends on the package as well
		String projectDirS = thisClassDir.getPath()
				+ "../../../../../citlab.benchmarks/";
		projectDirS =  URLDecoder.decode(projectDirS, "utf-8");
		File projectDir = new File(projectDirS);
		// logger.debug("project dir = " + projectDir.getCanonicalPath());
		System.out.println("benchmark dir = " + projectDir.getCanonicalPath());
		// if it does not exist try the
		if (projectDir.exists()) {
			assertTrue(projectDir.isDirectory());
			return projectDir;
		}
		throw new RuntimeException("benchmarks dir not found (thisclass URL :"
				+ thisClassDir);
	}

	private static Iterator<CitModel> getModelsInDir(File directory) {
		assert (directory.exists() && directory.isDirectory());
		File[] files = directory.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String fileName) {
				return fileName.endsWith(".citl");
			}
		});
		assertTrue(files.length > 0);
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return f1.getName().compareToIgnoreCase(f2.getName());
			}
		});
		final Iterator<File> fileIterator = Arrays.asList(files).iterator();
		return new Iterator<CitModel>() {

			@Override
			public boolean hasNext() {
				return fileIterator.hasNext();
			}

			@Override
			public CitModel next() {
				File f = fileIterator.next();
				CitModel m = loadModel(f.getAbsolutePath());
				// check if the file and model have the same name (useful when
				// using the name of the model x the file)
				String fileName = f.getAbsoluteFile().getName();
				if (!fileName.equals(m.getName() + ".citl")) {
					System.err.println("WARNING " + fileName
							+ " has name different from the model name ("
							+ m.getName() + ")");
				}
				assert m != null;
				return m;
			}

			@Override
			public void remove() {
				fileIterator.remove();
			}
		};
	}

	private static Serializer SERIALIZER = null;

	/**
	 * 
	 * @param file
	 *            relative path where the file is
	 * @return
	 */
	private static CitModel loadModel(String file) {
		Injector injector = new CitLStandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource;
		// if (injector == null) {
		// // @BeforeClass
		// // public static void makeSerializer() {
		// injector = new CitLInjectorProvider().getInjector();
		// SERIALIZER = injector.getInstance(Serializer.class);
		// }
		// convert to absolute
		File f = new File(file);
		assertTrue(file + " does not exists ", f.exists());
		assertTrue(file + " is a directory ", !f.isDirectory());
		String fullPath = f.getAbsolutePath();
		assertNotNull("call inizializer first", injector);
		// new loader
		// resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,Boolean.TRUE);
		// create the URI
		// URI uri = URI.createFileURI(fullPath);
		// the URI Exists and is a file
		// assertTrue(uri.isFile() && new File(uri.toFileString()).exists());
		// load the example and return the model
		resource = resourceSet.getResource(URI.createFileURI(fullPath), true);
		// build the validator
		if (VALIDATE) {
			IResourceValidator validator = injector
					.getInstance(IResourceValidator.class);
			List<Issue> issues = validator.validate(resource, CheckMode.ALL,
					CancelIndicator.NullImpl);
			//
			if (!issues.isEmpty()){
				throw new RuntimeException(issues.toString());}
		}
		return (CitModel) resource.getContents().get(0);
	}

	public static String serialize(EObject obj) {
		return SERIALIZER.serialize(obj);
	}

}
