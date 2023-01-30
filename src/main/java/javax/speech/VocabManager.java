package javax.speech;

public interface VocabManager {
   void addWord(Word var1);

   void addWords(Word[] var1);

   Word[] getWords(String var1);

   Word[] listProblemWords();

   void removeWord(Word var1) throws IllegalArgumentException;

   void removeWords(Word[] var1) throws IllegalArgumentException;
}
