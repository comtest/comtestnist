
import java.io.*;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;

import org.apache.lucene.index.IndexWriter;



/**
 * Basisklasse fuer ContentHandler.
 * 
 * Diese Klasse dient als gemeinsame Basis aller ContentHandler und
 * definiert ein paar Hilfsfunktionen, die fuer alle CH nuetzlich
 * sein koennten.
 * 
 * @author Mr. Pink
 */
public abstract class ContentHandler {
	
	/**
	 * Diese Methode liest den kompletten Inhalt der Datei ein.
	 * 
	 * @see    <a href="http://www.ehow.com/how_4871177_read-text-file-java.html">www.ehow.com</a>
	 * @throws IOException  falls ein Fehler beim Lesen auftrat
	 * @param  filename     die einzulesende Datei
	 */
	public static String getFileContents(String filename) throws IOException {
		char[] buffer = new char[4096];
		StringBuilder builder = new StringBuilder();
		Reader in = new InputStreamReader(new FileInputStream(filename), "UTF-8");
		try {
			int len = 0;
			while ((len = in.read(buffer, 0, buffer.length)) != -1) {
				builder.append(buffer, 0, len);
			}
		} finally {
			in.close();
		}
		
		return builder.toString().trim();
	}
	
	/**
	 * Standardfelder zum Dokument hinzufuegen.
	 * 
	 * In dieser Methode werden zu dem uebergebenen Dokument die Standardattribute hinzugefuegt.<br>
	 * Die Standardattribute sind: path, lastModify und size.
	 * 
	 * @param doc       Dokument zu dem die Attribute hinzugefuegt werden sollen
	 * @param filename  Datei aus der die Werte ausgelesen werden
	 */
	protected static void addDefaultFields(Document doc, String filename) {
		File file = new File(filename);
		
		// Absoluter Dateipfad
		
		doc.add(new Field("path", file.getAbsolutePath(), Field.Store.YES, Field.Index.ANALYZED));
		
		// Datum der letzten Aenderung
		
		NumericField lastModifyField = new NumericField("lastModify", 4, Field.Store.YES, true);
		lastModifyField.setLongValue(file.lastModified());
		doc.add(lastModifyField);
		
		// Dateigroesse
		
		NumericField sizeField = new NumericField("size", 4, Field.Store.YES, true);
		sizeField.setLongValue(file.length());
		doc.add(sizeField);
	}
	
	public abstract boolean handles(String filename); 
	
	public abstract boolean index(String filename, IndexWriter writer);
	
	public abstract String[] getIndexedFields();
}