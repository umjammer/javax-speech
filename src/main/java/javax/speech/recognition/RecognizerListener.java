package javax.speech.recognition;

import javax.speech.EngineListener;

public interface RecognizerListener extends EngineListener {
   void changesCommitted(RecognizerEvent var1);

   void focusGained(RecognizerEvent var1);

   void focusLost(RecognizerEvent var1);

   void recognizerProcessing(RecognizerEvent var1);

   void recognizerSuspended(RecognizerEvent var1);
}
