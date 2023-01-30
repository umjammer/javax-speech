package javax.speech.recognition;

import javax.speech.SpeechEvent;

public class GrammarEvent extends SpeechEvent {
   public static final int GRAMMAR_CHANGES_COMMITTED = 200;
   public static final int GRAMMAR_ACTIVATED = 201;
   public static final int GRAMMAR_DEACTIVATED = 202;
   protected boolean enabledChanged;
   protected boolean definitionChanged;
   protected GrammarException grammarException;

   public GrammarEvent(Grammar var1, int var2) {
      super(var1, var2);
      this.enabledChanged = false;
      this.definitionChanged = false;
      this.grammarException = null;
   }

   public GrammarEvent(Grammar var1, int var2, boolean var3, boolean var4, GrammarException var5) {
      super(var1, var2);
      this.enabledChanged = var3;
      this.definitionChanged = var4;
      this.grammarException = var5;
   }

   public boolean getDefinitionChanged() {
      return this.definitionChanged;
   }

   public boolean getEnabledChanged() {
      return this.enabledChanged;
   }

   public GrammarException getGrammarException() {
      return this.grammarException;
   }

   public String paramString() {
      switch (super.id) {
         case 200:
            StringBuffer var1 = new StringBuffer();
            var1.append("GRAMMAR_CHANGES_COMMITTED");
            if (this.enabledChanged) {
               var1.append(": enabledChanged");
            }

            if (this.definitionChanged) {
               var1.append(": definitionChanged");
            }

            if (this.grammarException != null) {
               var1.append(": " + this.grammarException.getMessage());
            }

            return var1.toString();
         case 201:
            return "GRAMMAR_ACTIVATED";
         case 202:
            return "GRAMMAR_DEACTIVATED";
         default:
            return super.paramString();
      }
   }
}
