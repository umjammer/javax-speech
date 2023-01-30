package javax.speech;

import java.util.EventObject;

public class SpeechEvent extends EventObject {
   protected int id;

   protected SpeechEvent(Object var1) {
      super(var1);
   }

   protected SpeechEvent(Object var1, int var2) {
      super(var1);
      this.id = var2;
   }

   public int getId() {
      return this.id;
   }

   public String paramString() {
      return "unknown type";
   }

   public String toString() {
      return this.getClass().getName() + "[" + this.paramString() + "] on " + super.source;
   }
}
