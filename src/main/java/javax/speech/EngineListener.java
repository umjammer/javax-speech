package javax.speech;

import java.util.EventListener;

public interface EngineListener extends EventListener {
   void engineAllocated(EngineEvent var1);

   void engineAllocatingResources(EngineEvent var1);

   void engineDeallocated(EngineEvent var1);

   void engineDeallocatingResources(EngineEvent var1);

   void engineError(EngineErrorEvent var1);

   void enginePaused(EngineEvent var1);

   void engineResumed(EngineEvent var1);
}
