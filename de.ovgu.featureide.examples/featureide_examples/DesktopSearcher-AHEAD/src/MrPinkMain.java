
import java.sql.Timestamp;
import java.util.Date;


import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;




/**
 * Hauptklasse.
 * 
 * Diese Klasse enthaelt das eigentliche Programm.
 * <p>
 * Das Programm beendet sich mit Code 0x0, falls alles OK verlief.
 * Wenn ein Fehler aufgetreten ist (Index nicht gefunden o.ae.), wird
 * 0x1 zurueckgegeben.
 * 
 * @author Mr. Pink
 */
abstract class MrPinkMain$$Base {
	Indexer       index = null;
	
	
	/**
	 * Konstruktor.
	 * 
	 * Erzeugt einen neuen MainFrame und uebergibt sich selbst als Parent.
	 * 
	 */
	public MrPinkMain$$Base(){
		
		init();
	
	}
	
	protected void init(){

	}
	
	/**
	 * Einstiegspunkt.
	 * 
	 * @param args  die uebergebenen Programmargumente
	 */
	public static void main(String[] args) {
		new MrPinkMain();
	}
	
	
	/**
	 * Fuehrt eine Suchanfrage durch.
	 * 
	 * @param query               Suchanfrage
	 * @param maxResults          Anzahl der maximalen Resultate
	 * @param searchMode          Modus nach dem gesucht werden soll (Konstanten aus OptionStorage)
	 * @throws IndexerException   falls kein bekannter Suchmodus uebergeben wurde
	 */
	public void searchInIndex(String query,int maxResults,int searchMode) throws Exception{
			
			
	}
	
	/**
	 * Komplette Ausgabe der Ergebnisse.
	 * 
	 * Diese Methode gibt die einzelnen gefundenen Dokumente aus.
	 * Dabei werden neben dem Titel und dem Pfad auch noch
	 * die Dateigroesse oder der Zeitpunkt der letzten Aenderung
	 * ausgegeben, falls der letzte Parameter entsprechend
	 * gesetzt wird.
	 * 
	 * @param hits              die IDs der Trefferdokumente
	 * @param index             Indexer auf dem gearbeitet wird
	 * @param interestingField  Field nach dem gesucht wurde. Der Parameter ist nur bei Anfragen, die nach 
	 *                          "largest" oder "mostRecent" gestellt wurden, relevant.
	 */
	protected static void printHits(ScoreDoc[] hits, Indexer index, String interestingField) {
		try {
			System.out.println(interestingField);
			//for (ScoreDoc doc : hits) {
			for(int i=0;i<hits.length;i++){
				ScoreDoc doc = hits[i];
					
				int              documentID = doc.doc;
				Object[]         ret        = index.getDocument(documentID);
				Document         document   = (Document) ret[0];
				
				String           value      = document.getField(interestingField).stringValue();
				
				if (interestingField.equals("lastModify")) {
					Timestamp ts = new Timestamp(new Long(value));
					Date      d  = new Date(ts.getTime());
					
					value = d.toString();
				} else if (interestingField.equals("size")) {
					value += " Byte";
				} 
				
				System.out.println("  -> doc #" + documentID + " ("+value+")");
				System.out.println("  -> title "+ document.getField("title").stringValue());
				System.out.println("  -> path " + document.getField("path").stringValue() );
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}

abstract class MrPinkMain$$User_Interface extends  MrPinkMain$$Base  {

	UI userInterface;


	public void searchInIndex(String query,int maxResults,int searchMode) throws Exception{
		if(index == null){
			userInterface.printErrorMessage("Bisher wurde noch kein Pfad indexiert");
			return;
		}
			
		TopDocs hits = null;
		if (searchMode == OptionStorage.SEARCHLASTMODIFIED) {
			// Suche nach den X juengsten Dokumenten
			
			System.out.print("Getting the " + maxResults + " newest documents...");
			hits = index.getMostRecentDocuments(maxResults);

			if (hits != null) {
				System.out.println(" found " + hits.totalHits + " documents.");
//				MrPinkMain.printHits(hits.scoreDocs, index, "lastModify");
				userInterface.printSearch_SearchPanel(hits.scoreDocs, index, null);
			} else {
				System.out.println(" no documents found.");
			}
		} else if (searchMode == OptionStorage.SEARCHLARGEST) {
			// Suche nach den X groessten Dokumente
			
			System.out.print("Getting the " + maxResults + " largest documents...");
			hits = index.getLargestDocuments(maxResults);

			if (hits != null) {
				System.out.println(" found " + hits.totalHits + " documents.");
				userInterface.printSearch_SearchPanel(hits.scoreDocs, index, null);
			} else {
				System.out.println(" no documents found.");
			}
		} else if(searchMode == OptionStorage.SEARCHNORMAL) {
			// Suche nach Suchbegriff
			
			System.out.print("Searching for '" + query + "'...");
			hits = index.search(query, maxResults);
			
			if (hits != null) {
				System.out.println(" found " + hits.totalHits + " matching documents.");
				userInterface.printSearch_SearchPanel(hits.scoreDocs, index, query);
			} else {
				System.out.println(" no matching documents found.");
			}
		} else {
			throw new IndexerException("Unknown search mode.");
		}
	}
      // inherited constructors


	
	
	/**
	 * Konstruktor.
	 * 
	 * Erzeugt einen neuen MainFrame und uebergibt sich selbst als Parent.
	 * 
	 */
	public MrPinkMain$$User_Interface (  ) { super(); }

}

abstract class MrPinkMain$$GUI extends  MrPinkMain$$User_Interface  {
	
	//MainFrame mainFrame = null;

	protected void init(){
		userInterface = new MainFrame(((MrPinkMain) this));	
		super.init();
	}
      // inherited constructors


	
	
	/**
	 * Konstruktor.
	 * 
	 * Erzeugt einen neuen MainFrame und uebergibt sich selbst als Parent.
	 * 
	 */
	public MrPinkMain$$GUI (  ) { super(); }


}

public class MrPinkMain extends  MrPinkMain$$GUI  {

	public void createIndex(String dataDir){
		try {
			index = new Indexer("./index");
			index.createIndex(dataDir);
		} catch (Exception e) {
			System.out.println(" failed.");
			System.err.println(e.getMessage());
			System.err.println("Aborting.");
			System.exit(1);
		}
	}
      // inherited constructors


	
	
	/**
	 * Konstruktor.
	 * 
	 * Erzeugt einen neuen MainFrame und uebergibt sich selbst als Parent.
	 * 
	 */
	public MrPinkMain (  ) { super(); }
	
}