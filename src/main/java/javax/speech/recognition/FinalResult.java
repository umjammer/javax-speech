package javax.speech.recognition;

import java.applet.AudioClip;

public interface FinalResult extends Result {
   int MISRECOGNITION = 400;
   int USER_CHANGE = 401;
   int DONT_KNOW = 402;

   AudioClip getAudio() throws ResultStateError;

   AudioClip getAudio(ResultToken var1, ResultToken var2) throws IllegalArgumentException, ResultStateError;

   boolean isAudioAvailable() throws ResultStateError;

   boolean isTrainingInfoAvailable() throws ResultStateError;

   void releaseAudio() throws ResultStateError;

   void releaseTrainingInfo() throws ResultStateError;

   void tokenCorrection(String[] var1, ResultToken var2, ResultToken var3, int var4) throws ResultStateError, IllegalArgumentException;
}
