package javax.speech;

public class AudioEvent extends SpeechEvent {
   public AudioEvent(Engine var1, int var2) {
      super(var1, var2);
   }

   public String paramString() {
      switch (super.id) {
         default:
            return super.paramString();
      }
   }
}
