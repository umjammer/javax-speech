package javax.speech.synthesis;

public class SynthesizerQueueItem {
   protected Object source;
   protected String text;
   protected boolean plainText;
   protected SpeakableListener listener;

   public SynthesizerQueueItem(Object var1, String var2, boolean var3, SpeakableListener var4) {
      this.source = var1;
      this.text = var2;
      this.plainText = var3;
      this.listener = var4;
   }

   public Object getSource() {
      return this.source;
   }

   public SpeakableListener getSpeakableListener() {
      return this.listener;
   }

   public String getText() {
      return this.text;
   }

   public boolean isPlainText() {
      return this.plainText;
   }
}
