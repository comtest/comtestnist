
import org.apache.lucene.search.ScoreDoc;



public interface UI {

	public void printSearch_SearchPanel(ScoreDoc[] hits, Indexer index, String query);

	public void printErrorMessage(String message);


}