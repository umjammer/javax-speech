package javax.speech.recognition;

import java.util.EventListener;

public interface ResultListener extends EventListener {
   void audioReleased(ResultEvent var1);

   void grammarFinalized(ResultEvent var1);

   void resultAccepted(ResultEvent var1);

   void resultCreated(ResultEvent var1);

   void resultRejected(ResultEvent var1);

   void resultUpdated(ResultEvent var1);

   void trainingInfoReleased(ResultEvent var1);
}
