package javax.speech.recognition;

import java.util.Vector;

public class RuleParse extends Rule {
   protected RuleName ruleName;
   protected Rule rule;

   public RuleParse() {
      this.setRuleName((RuleName)null);
      this.setRule((Rule)null);
   }

   public RuleParse(RuleName var1, Rule var2) {
      this.setRuleName(var1);
      this.setRule(var2);
   }

   public Rule copy() {
      RuleName var1 = null;
      if (this.ruleName != null) {
         var1 = (RuleName)this.ruleName.copy();
      }

      return new RuleParse(var1, this.rule.copy());
   }

   public Rule getRule() {
      return this.rule;
   }

   public RuleName getRuleName() {
      return this.ruleName;
   }

   public String[] getTags() {
      Vector var1 = new Vector();
      this.getTags(this.rule, var1);
      return this.vectorToStringArray(var1);
   }

   private void getTags(Rule var1, Vector var2) {
      if (!(var1 instanceof RuleToken)) {
         if (var1 instanceof RuleParse) {
            this.getTags(((RuleParse)var1).getRule(), var2);
         } else if (var1 instanceof RuleTag) {
            RuleTag var6 = (RuleTag)var1;
            this.getTags(var6.getRule(), var2);
            var2.addElement(var6.tag);
         } else {
            int var4;
            if (var1 instanceof RuleSequence) {
               RuleSequence var5 = (RuleSequence)var1;

               for(var4 = 0; var4 < var5.rules.length; ++var4) {
                  this.getTags(var5.rules[var4], var2);
               }

            } else if (!(var1 instanceof RuleAlternatives)) {
               if (!(var1 instanceof RuleName)) {
                  throw new IllegalArgumentException(var1.getClass().getName() + " is not a legal object in a RuleParse");
               }
            } else {
               RuleAlternatives var3 = (RuleAlternatives)var1;

               for(var4 = 0; var4 < var3.rules.length; ++var4) {
                  this.getTags(var3.rules[var4], var2);
               }

            }
         }
      }
   }

   public void setRule(Rule var1) {
      this.rule = var1;
   }

   public void setRuleName(RuleName var1) {
      this.ruleName = var1;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer("(");
      if (this.ruleName == null) {
         var1.append("<???>");
      } else {
         var1.append(this.ruleName.toString());
      }

      var1.append(" = " + this.rule.toString() + ')');
      return var1.toString();
   }

   private String[] vectorToStringArray(Vector var1) {
      if (var1 != null && var1.size() != 0) {
         String[] var2 = new String[var1.size()];

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            var2[var3] = (String)var1.elementAt(var3);
         }

         return var2;
      } else {
         return null;
      }
   }
}
