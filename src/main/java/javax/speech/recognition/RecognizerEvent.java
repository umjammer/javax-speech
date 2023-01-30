package javax.speech.recognition;

import javax.speech.EngineEvent;

public class RecognizerEvent extends EngineEvent {
   public static final int RECOGNIZER_PROCESSING = 1200;
   public static final int RECOGNIZER_SUSPENDED = 1202;
   public static final int CHANGES_COMMITTED = 1203;
   public static final int FOCUS_GAINED = 1204;
   public static final int FOCUS_LOST = 1205;
   protected GrammarException grammarException;

   public RecognizerEvent(Recognizer var1, int var2, long var3, long var5, GrammarException var7) {
      super(var1, var2, var3, var5);
      this.grammarException = var7;
   }

   public GrammarException getGrammarException() {
      return this.grammarException;
   }

   public String paramString() {
      switch (super.id) {
         case 1200:
            return "RECOGNIZER_PROCESSING";
         case 1201:
         default:
            return super.paramString();
         case 1202:
            return "RECOGNIZER_SUSPENDED";
         case 1203:
            if (this.grammarException != null) {
               return "CHANGES_COMMITTED: " + this.grammarException.getMessage();
            }

            return "CHANGES_COMMITTED";
         case 1204:
            return "FOCUS_GAINED";
         case 1205:
            return "FOCUS_LOST";
      }
   }
}
