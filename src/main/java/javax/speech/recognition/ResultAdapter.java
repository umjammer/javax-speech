package javax.speech.recognition;

/**
 * The adapter which receives events for a Result object.
 * The methods in this class are empty;  this class is provided as a
 * convenience for easily creating listeners by extending this class
 * and overriding only the methods of interest.
 */
public class ResultAdapter implements ResultListener {

    /**
     * A AUDIO_RELEASED event has occured.
     *
     * @see javax.speech.recognition.ResultEvent#AUDIO_RELEASED
     */
   public void audioReleased(ResultEvent var1) {
   }

    /**
     * A GRAMMAR_FINALIZED event has occured.
     *
     * @see javax.speech.recognition.ResultEvent#GRAMMAR_FINALIZED
     */
   public void grammarFinalized(ResultEvent var1) {
   }

    /**
     * A RESULT_ACCEPTED event has occured.
     *
     * @see javax.speech.recognition.ResultEvent#RESULT_ACCEPTED
     */
   public void resultAccepted(ResultEvent var1) {
   }

    /**
     * A RESULT_CREATED event has occured.
     *
     * @see javax.speech.recognition.ResultEvent#RESULT_CREATED
     */
   public void resultCreated(ResultEvent var1) {
   }

    /**
     * A RESULT_REJECTED event has occured.
     *
     * @see javax.speech.recognition.ResultEvent#RESULT_REJECTED
     */
   public void resultRejected(ResultEvent var1) {
   }

    /**
     * A RESULT_UPDATED event has occured.
     *
     * @see javax.speech.recognition.ResultEvent#RESULT_UPDATED
     */
   public void resultUpdated(ResultEvent var1) {
   }

    /**
     * A TRAINING_INFO_RELEASED event has occured.
     *
     * @see javax.speech.recognition.ResultEvent#TRAINING_INFO_RELEASED
     */
   public void trainingInfoReleased(ResultEvent var1) {
   }
}
