package javax.speech.recognition;

import javax.speech.SpeechException;

public class GrammarException extends SpeechException {
   private GrammarSyntaxDetail[] details;

   public GrammarException() {
      this.details = null;
   }

   public GrammarException(String var1) {
      super(var1);
      this.details = null;
   }

   public GrammarException(String var1, GrammarSyntaxDetail[] var2) {
      super(var1);
      this.details = var2;
   }

   public void addDetail(GrammarSyntaxDetail var1) {
      GrammarSyntaxDetail[] var2 = this.details;
      if (var2 == null) {
         var2 = new GrammarSyntaxDetail[0];
      }

      this.details = new GrammarSyntaxDetail[var2.length + 1];
      System.arraycopy(var2, 0, this.details, 0, var2.length);
      this.details[var2.length] = var1;
   }

   public GrammarSyntaxDetail[] getDetails() {
      return this.details;
   }

   public void setDetails(GrammarSyntaxDetail[] var1) {
      this.details = var1;
   }
}
