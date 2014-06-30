
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;



/**
	 * Event-Listener
	 * 
	 * Die Klasse Listener behandelt alle Events die durch Buttons ausgeloest
	 * werden
	 * 
	 */
	abstract class ButtonListener$$GUI implements ActionListener {
		Component parents;// = null;
		MainFrame frame;

		public ButtonListener$$GUI(Component parents) {
			this.parents = parents;
			frame = (MainFrame) parents;
		}

		
		public void actionPerformed(ActionEvent e) {
			
			/**
			 * Der startButton startet die Suche. Hierbei kann je nach
			 * Einstellung nach der angegebenen Query gesucht werden, wie auch
			 * nach den groesssten Dateien oder auch nach dem Zeitpunkt der
			 * letzten Aenderung.
			 */
			if (e.getSource().equals(frame.startButton)) {
				frame.searchResultContainer.removeAll();
				frame.searchResultContainer.repaint();
				
				// setzt die Groesse des Panels wieder zum Standard
				frame.searchResultContainer.setPreferredSize(new Dimension(0, 0));

				frame.scrollPane.repaint();

				if (frame.queryTextFieldJComboBox.getSelectedItem()!= null) {
					try {
						frame.mrPinkMain.searchInIndex(((String)frame.queryTextFieldJComboBox.getSelectedItem()), frame.optionStorage.getMaxResults(), frame.optionStorage.getSearchMode());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else{
					System.out.println("bitte Querry eingeben");
				}	
			}
		}
	}

public class ButtonListener extends  ButtonListener$$GUI  {

	public void actionPerformed(ActionEvent e) {
		/**
		 * Wenn der changeButton betoetigt wird, wird ein FileChooser
		 * geoeffnet, in dem dann ein Pfad, der indiziert werden soll,
		 * selektiert werden kann.
		 */
		if (e.getSource().equals(frame.changeButton)) {
			addingPath();
			frame.enableSearchGroupBox(false);
			frame.showIndexCreateMessageDialog();
		}
		/**
		 * Wenn der refreshButton benoetigt wird, wird der selektierte Pfad
		 * neu indiziert.
		 */
		if (e.getSource().equals(frame.refreshButton)) {
			frame.showIndexCreateMessageDialog();
		}
		super.actionPerformed(e);	
			
	}
	
	public void addingPath(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(parents)) {
			String path = fileChooser.getSelectedFile().getPath();
			addPathToGui(path);
			pathAdded(path);
		}		
	}
	
	public void pathAdded(String path){
	
	}
	
	public void addPathToGui(String path){
		frame.indexPath.setText(path);
	}
      // inherited constructors



		public ButtonListener ( Component parents ) { super(parents); }
}