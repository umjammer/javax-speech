package javax.speech.synthesis;

import javax.speech.EngineListener;

public interface SynthesizerListener extends EngineListener {
   void queueEmptied(SynthesizerEvent var1);

   void queueUpdated(SynthesizerEvent var1);
}
