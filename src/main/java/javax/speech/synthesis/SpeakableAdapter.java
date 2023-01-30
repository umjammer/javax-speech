package javax.speech.synthesis;

/**
 * Adapter that receives events associated with spoken output of a
 * Speakable object.  The methods in this class are empty;
 * this class is provided as a convenience for easily creating listeners
 * by extending this class and overriding only the methods of interest.
 */
public class SpeakableAdapter implements SpeakableListener {

    /**
     * A MARKER_REACHED event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#MARKER_REACHED
     */
    public void markerReached(SpeakableEvent e) {
    }

    /**
     * A SPEAKABLE_CANCELLED event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#SPEAKABLE_CANCELLED
     */
    public void speakableCancelled(SpeakableEvent e) {
    }

    /**
     * A SPEAKABLE_ENDED event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#SPEAKABLE_ENDED
     */
    public void speakableEnded(SpeakableEvent e) {
    }

    /**
     * A SPEAKABLE_PAUSED event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#SPEAKABLE_PAUSED
     */
    public void speakablePaused(SpeakableEvent e) {
    }

    /**
     * A SPEAKABLE_RESUMED event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#SPEAKABLE_RESUMED
     */
    public void speakableResumed(SpeakableEvent e) {
    }

    /**
     * A SPEAKABLE_STARTED event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#SPEAKABLE_STARTED
     */
    public void speakableStarted(SpeakableEvent e) {
    }

    /**
     * A TOP_OF_QUEUE event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#TOP_OF_QUEUE
     */
    public void topOfQueue(SpeakableEvent e) {
    }

    /**
     * A WORD_STARTED event has occurred.
     *
     * @see javax.speech.synthesis.SpeakableEvent#WORD_STARTED
     */
    public void wordStarted(SpeakableEvent e) {
    }
}
