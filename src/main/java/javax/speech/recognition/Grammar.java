package javax.speech.recognition;

public interface Grammar {
   int RECOGNIZER_FOCUS = 900;
   int RECOGNIZER_MODAL = 901;
   int GLOBAL = 902;

   void addGrammarListener(GrammarListener var1);

   void addResultListener(ResultListener var1);

   int getActivationMode();

   String getName();

   Recognizer getRecognizer();

   boolean isActive();

   boolean isEnabled();

   void removeGrammarListener(GrammarListener var1);

   void removeResultListener(ResultListener var1);

   void setActivationMode(int var1) throws IllegalArgumentException;

   void setEnabled(boolean var1);
}
