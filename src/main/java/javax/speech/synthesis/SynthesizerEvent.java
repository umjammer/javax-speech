package javax.speech.synthesis;

import javax.speech.EngineEvent;

public class SynthesizerEvent extends EngineEvent {
   public static final int QUEUE_EMPTIED = 700;
   public static final int QUEUE_UPDATED = 701;
   protected boolean topOfQueueChanged = false;

   public SynthesizerEvent(Synthesizer var1, int var2, boolean var3, long var4, long var6) {
      super(var1, var2, var4, var6);
      this.topOfQueueChanged = var3;
   }

   public boolean getTopOfQueueChanged() {
      return this.topOfQueueChanged;
   }

   public String paramString() {
      switch (super.id) {
         case 700:
            return "QUEUE_EMPTIED";
         case 701:
            if (this.topOfQueueChanged) {
               return "QUEUE_UPDATED (topOfQueue changed)";
            }

            return "QUEUE_UPDATED";
         default:
            return super.paramString();
      }
   }
}
