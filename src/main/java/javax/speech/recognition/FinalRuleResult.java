package javax.speech.recognition;

public interface FinalRuleResult extends FinalResult {
   ResultToken[] getAlternativeTokens(int var1) throws ResultStateError;

   int getNumberGuesses() throws ResultStateError;

   RuleGrammar getRuleGrammar(int var1) throws ResultStateError;

   String getRuleName(int var1) throws ResultStateError;

   String[] getTags() throws ResultStateError;
}
