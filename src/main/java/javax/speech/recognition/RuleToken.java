package javax.speech.recognition;

public class RuleToken extends Rule {
   protected String text;

   public RuleToken() {
      this.setText((String)null);
   }

   public RuleToken(String var1) {
      this.setText(var1);
   }

   private boolean containsWhiteSpace(String var1) {
      for(int var2 = 0; var2 < var1.length(); ++var2) {
         if (Character.isWhitespace(var1.charAt(var2))) {
            return true;
         }
      }

      return false;
   }

   public Rule copy() {
      return new RuleToken(this.text);
   }

   public String getText() {
      return this.text;
   }

   public void setText(String var1) {
      this.text = var1;
   }

   public String toString() {
      if (!this.containsWhiteSpace(this.text) && this.text.indexOf(92) < 0 && this.text.indexOf(34) < 0) {
         return this.text;
      } else {
         StringBuffer var1 = new StringBuffer(this.text);

         for(int var3 = var1.length() - 1; var3 >= 0; --var3) {
            char var2;
            if ((var2 = var1.charAt(var3)) == '"' || var2 == '\\') {
               var1.insert(var3, '\\');
            }
         }

         var1.insert(0, '"');
         var1.append('"');
         return var1.toString();
      }
   }
}
