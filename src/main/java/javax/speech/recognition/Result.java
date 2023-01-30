package javax.speech.recognition;

public interface Result {
   int UNFINALIZED = 300;
   int ACCEPTED = 301;
   int REJECTED = 302;

   void addResultListener(ResultListener var1);

   ResultToken getBestToken(int var1) throws IllegalArgumentException;

   ResultToken[] getBestTokens();

   Grammar getGrammar();

   int getResultState();

   ResultToken[] getUnfinalizedTokens();

   int numTokens();

   void removeResultListener(ResultListener var1);
}
