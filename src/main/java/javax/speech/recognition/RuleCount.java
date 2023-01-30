package javax.speech.recognition;

public class RuleCount extends Rule {
   protected Rule rule;
   protected int count;
   public static int OPTIONAL = 2;
   public static int ONCE_OR_MORE = 3;
   public static int ZERO_OR_MORE = 4;

   public RuleCount() {
      this.setRule((Rule)null);
      this.setCount(OPTIONAL);
   }

   public RuleCount(Rule var1, int var2) {
      this.setRule(var1);
      this.setCount(var2);
   }

   public Rule copy() {
      return new RuleCount(this.rule.copy(), this.count);
   }

   public int getCount() {
      return this.count;
   }

   public Rule getRule() {
      return this.rule;
   }

   public void setCount(int var1) {
      if (var1 == OPTIONAL || var1 == ZERO_OR_MORE || var1 == ONCE_OR_MORE) {
         this.count = var1;
      }
   }

   public void setRule(Rule var1) {
      this.rule = var1;
   }

   public String toString() {
      if (this.count == OPTIONAL) {
         return '[' + this.rule.toString() + ']';
      } else {
         String var1 = null;
         if (!(this.rule instanceof RuleToken) && !(this.rule instanceof RuleName)) {
            var1 = '(' + this.rule.toString() + ')';
         } else {
            var1 = this.rule.toString();
         }

         if (this.count == ZERO_OR_MORE) {
            return var1 + " *";
         } else {
            return this.count == ONCE_OR_MORE ? var1 + " +" : var1 + "???";
         }
      }
   }
}
