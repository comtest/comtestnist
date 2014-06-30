/**
 * Abstrakte ExamDataBase Klasse. Speichert Benotungsparameter, Teilnehmerdaten
 * und erm&ouml;glicht Abfragen der Datenbasis.
 */
public abstract class ExamDataBase {

    /** 
     * Gibt die Anzahl der (nicht wieder abgemeldeten) Klausurteilnehmer zur&uuml;ck.
     * @return die Anzahl der (nicht wieder abgemeldeten) Klausurteilnehmer.
     */    
    /*@ public normal_behavior
      @  ensures \result==(\num_of int i; 
      @                        0<=i && i<students.length; validStudent(students[i]));
      @*/
    public abstract /*@pure@*/ int getNumParticipants();
    
    /** 
     * Gibt die Anzahl der Klausurteilnehmer mit Note <code>grade</code> zur&uuml;ck,
     * falls die Datenbasis konsistent ist (<code>consistent()==true</code>). Andernfalls
     * wird eine <code>ExamDataBaseException</code> geworfen.
     * @return die Anzahl der (nicht wieder abgemeldeten) Klausurteilnehmer mit Note 
     * <code>grade</code>.
     * @throws ExamDataBaseException falls die Datenbasis inkonsistent ist
     * (<code>consistent()==false</code>).
     */ 
    /*@ public normal_behavior
      @  requires consistent();
      @  assignable \nothing;
      @  ensures \result==(\num_of int i; 
      @                       0<=i && i<students.length; validStudent(students[i])
      @                       && pointsToGrade(students[i].points,
      @                                        students[i].getBonusPoints())==grade);
      @ also public exceptional_behavior
      @  requires !consistent();
      
      @  signals_only ExamDataBaseException;
      @*/
    public abstract int getNumWithGrade(int grade) 
						throws ExamDataBaseException;

    /** 
     * Gibt den Notendurchschnitt zur&uuml;ck,
     * falls die Datenbasis konsistent ist (<code>consistent()==true</code>). Andernfalls
     * wird eine <code>ExamDataBaseException</code> geworfen.
     * @return der Notendurchschnitt.
     * @throws ExamDataBaseException falls die Datenbasis inkonsistent ist
     * (<code>consistent()==false</code>).
     */ 
    /*@ public normal_behavior
      @  requires consistent();
      @  assignable \nothing;
      @  ensures \result==(getNumParticipants()==0
      @                    ? -1
      @                    : ((\sum int i; 
      @                           0<=i && i<students.length; 
      @                           validStudent(students[i])?
      @                               pointsToGrade(students[i].points, 
      @                                             students[i].getBonusPoints()):0)
      @                      /getNumParticipants()));
      @ also public exceptional_behavior
      @  requires !consistent();
  
      @  signals_only ExamDataBaseException;
      @*/
    public abstract int getAverage() throws ExamDataBaseException;

    /** 
     * Gibt den Notendurchschnitt der bestandenen Klausuren zur&uuml;ck,
     * falls die Datenbasis konsistent ist (<code>consistent()==true</code>). Andernfalls
     * wird eine <code>ExamDataBaseException</code> geworfen.
     * @return der Notendurchschnitt der bestandenen Klausuren.
     * @throws ExamDataBaseException falls die Datenbasis inkonsistent ist
     * (<code>consistent()==false</code>).
     */
    /*@ public normal_behavior
      @  requires consistent();
      @  assignable \nothing;
      @  ensures \result==(getNumParticipants()-getNumWithGrade(500)==0
      @                    ? -1
      @                    : ((\sum int i; 
      @                           0<=i && i<students.length; validStudent(students[i])
      @                           && pointsToGrade(students[i].points,
      @                                            students[i].getBonusPoints())<500?
      @                               pointsToGrade(students[i].points, 
      @                                             students[i].getBonusPoints()):0)
      @                      /(getNumParticipants()-getNumWithGrade(500))));
      @ also public exceptional_behavior
      @  requires !consistent();

      @  signals_only ExamDataBaseException;
      @*/
    public abstract int getPassedAverage() throws ExamDataBaseException;

}
