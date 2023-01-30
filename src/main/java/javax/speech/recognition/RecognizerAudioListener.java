package javax.speech.recognition;

import javax.speech.AudioListener;

public interface RecognizerAudioListener extends AudioListener {
   void audioLevel(RecognizerAudioEvent var1);

   void speechStarted(RecognizerAudioEvent var1);

   void speechStopped(RecognizerAudioEvent var1);
}
