package javax.speech.recognition;

public interface DictationGrammar extends Grammar {
   void addWord(String var1);

   String[] listAddedWords();

   String[] listRemovedWords();

   void removeWord(String var1);

   void setContext(String var1, String var2);

   void setContext(String[] var1, String[] var2);
}
