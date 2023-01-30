package javax.speech.recognition;

public interface FinalDictationResult extends FinalResult {
   ResultToken[][] getAlternativeTokens(ResultToken var1, ResultToken var2, int var3) throws ResultStateError, IllegalArgumentException;
}
