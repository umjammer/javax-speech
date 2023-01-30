package javax.speech.recognition;

import java.util.EventListener;

public interface GrammarListener extends EventListener {
   void grammarActivated(GrammarEvent var1);

   void grammarChangesCommitted(GrammarEvent var1);

   void grammarDeactivated(GrammarEvent var1);
}
