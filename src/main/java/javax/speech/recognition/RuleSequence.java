package javax.speech.recognition;

public class RuleSequence extends Rule {
   protected Rule[] rules;

   public RuleSequence() {
      this.setRules((Rule[])null);
   }

   public RuleSequence(Rule var1) {
      Rule[] var2 = new Rule[]{var1};
      this.setRules(var2);
   }

   public RuleSequence(String[] var1) {
      if (var1 == null) {
         var1 = new String[0];
      }

      this.rules = new Rule[var1.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.rules[var2] = new RuleToken(var1[var2]);
      }

   }

   public RuleSequence(Rule[] var1) {
      this.setRules(var1);
   }

   public void append(Rule var1) {
      if (var1 == null) {
         throw new NullPointerException("null rule to append");
      } else {
         int var2 = this.rules.length;
         Rule[] var3 = new Rule[var2 + 1];
         System.arraycopy(this.rules, 0, var3, 0, var2);
         var3[var2] = var1;
         this.rules = var3;
      }
   }

   public Rule copy() {
      Rule[] var1 = null;
      if (this.rules != null) {
         var1 = new Rule[this.rules.length];

         for(int var2 = 0; var2 < this.rules.length; ++var2) {
            var1[var2] = this.rules[var2].copy();
         }
      }

      return new RuleSequence(var1);
   }

   public Rule[] getRules() {
      return this.rules;
   }

   public void setRules(Rule[] var1) {
      if (var1 == null) {
         var1 = new Rule[0];
      }

      this.rules = var1;
   }

   public String toString() {
      if (this.rules.length == 0) {
         return "<NULL>";
      } else {
         StringBuffer var1 = new StringBuffer();

         for(int var2 = 0; var2 < this.rules.length; ++var2) {
            if (var2 > 0) {
               var1.append(' ');
            }

            if (!(this.rules[var2] instanceof RuleAlternatives) && !(this.rules[var2] instanceof RuleSequence)) {
               var1.append(this.rules[var2].toString());
            } else {
               var1.append("( " + this.rules[var2].toString() + " )");
            }
         }

         return var1.toString();
      }
   }
}
