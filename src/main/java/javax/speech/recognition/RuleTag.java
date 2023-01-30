package javax.speech.recognition;

public class RuleTag extends Rule {
   protected Rule rule;
   protected String tag;

   public RuleTag() {
      this.setRule((Rule)null);
      this.setTag((String)null);
   }

   public RuleTag(Rule var1, String var2) {
      this.setRule(var1);
      this.setTag(var2);
   }

   public Rule copy() {
      return new RuleTag(this.rule.copy(), this.tag);
   }

   private String escapeTag(String var1) {
      StringBuffer var2 = new StringBuffer(var1);
      if (var1.indexOf(125) >= 0 || var1.indexOf(92) >= 0) {
         for(int var3 = var2.length() - 1; var3 >= 0; --var3) {
            char var4 = var2.charAt(var3);
            if (var4 == '}' || var4 == '\\') {
               var2.insert(var3, '\\');
            }
         }
      }

      return var2.toString();
   }

   public Rule getRule() {
      return this.rule;
   }

   public String getTag() {
      return this.tag;
   }

   public void setRule(Rule var1) {
      this.rule = var1;
   }

   public void setTag(String var1) {
      if (var1 == null) {
         this.tag = "";
      } else {
         this.tag = var1;
      }

   }

   public String toString() {
      String var1 = " {" + this.escapeTag(this.tag) + "}";
      return !(this.rule instanceof RuleToken) && !(this.rule instanceof RuleName) ? "(" + this.rule.toString() + ")" + var1 : this.rule.toString() + var1;
   }
}
