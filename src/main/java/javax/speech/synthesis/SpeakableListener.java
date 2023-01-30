package javax.speech.synthesis;

import java.util.EventListener;

public interface SpeakableListener extends EventListener {
   void markerReached(SpeakableEvent var1);

   void speakableCancelled(SpeakableEvent var1);

   void speakableEnded(SpeakableEvent var1);

   void speakablePaused(SpeakableEvent var1);

   void speakableResumed(SpeakableEvent var1);

   void speakableStarted(SpeakableEvent var1);

   void topOfQueue(SpeakableEvent var1);

   void wordStarted(SpeakableEvent var1);
}
