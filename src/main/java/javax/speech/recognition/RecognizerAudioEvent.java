package javax.speech.recognition;

import javax.speech.AudioEvent;

public class RecognizerAudioEvent extends AudioEvent {
   public static final int SPEECH_STARTED = 1100;
   public static final int SPEECH_STOPPED = 1101;
   public static final int AUDIO_LEVEL = 1102;
   protected float audioLevel = 0.0F;

   public RecognizerAudioEvent(Recognizer var1, int var2) {
      super(var1, var2);
      this.audioLevel = 0.0F;
   }

   public RecognizerAudioEvent(Recognizer var1, int var2, float var3) {
      super(var1, var2);
      this.audioLevel = var3;
   }

   public float getAudioLevel() {
      return this.audioLevel;
   }

   public String paramString() {
      switch (super.id) {
         case 1100:
            return "SPEECH_STARTED";
         case 1101:
            return "SPEECH_STOPPED";
         case 1102:
            return "AUDIO_LEVEL: " + this.audioLevel;
         default:
            return super.paramString();
      }
   }
}
