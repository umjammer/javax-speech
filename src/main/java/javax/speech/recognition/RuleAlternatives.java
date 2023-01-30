package javax.speech.recognition;

public class RuleAlternatives extends Rule {
   protected Rule[] rules;
   protected float[] weights;

   public RuleAlternatives() {
      this.setRules((Rule[])null);
      this.weights = null;
   }

   public RuleAlternatives(Rule var1) {
      Rule[] var2 = new Rule[]{var1};
      this.setRules(var2);
      this.weights = null;
   }

   public RuleAlternatives(String[] var1) {
      if (var1 == null) {
         var1 = new String[0];
         this.weights = null;
      } else {
         this.rules = new Rule[var1.length];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            this.rules[var2] = new RuleToken(var1[var2]);
         }

         this.weights = null;
      }
   }

   public RuleAlternatives(Rule[] var1) {
      this.setRules(var1);
      this.weights = null;
   }

   public RuleAlternatives(Rule[] var1, float[] var2) throws IllegalArgumentException {
      this.setRules(var1);
      this.setWeights(var2);
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
         this.weights = null;
      }
   }

   public Rule copy() {
      float[] var1 = null;
      if (this.weights != null) {
         var1 = new float[this.weights.length];
         System.arraycopy(this.weights, 0, var1, 0, this.weights.length);
      }

      Rule[] var2 = null;
      if (this.rules != null) {
         var2 = new Rule[this.rules.length];

         for(int var3 = 0; var3 < this.rules.length; ++var3) {
            var2[var3] = this.rules[var3].copy();
         }
      }

      return new RuleAlternatives(var2, var1);
   }

   public Rule[] getRules() {
      return this.rules;
   }

   public float[] getWeights() {
      return this.weights;
   }

   public void setRules(Rule[] var1) {
      if (var1 == null) {
         var1 = new Rule[0];
      }

      if (this.weights != null && var1.length != this.weights.length) {
         this.weights = null;
      }

      this.rules = var1;
   }

   public void setWeights(float[] var1) throws IllegalArgumentException {
      if (var1 != null && var1.length != 0) {
         if (var1.length != this.rules.length) {
            throw new IllegalArgumentException("weights/rules array length mismatch");
         } else {
            float var2 = 0.0F;

            for(int var3 = 0; var3 < var1.length; ++var3) {
               if (Float.isNaN(var1[var3])) {
                  throw new IllegalArgumentException("illegal weight value: NaN");
               }

               if (Float.isInfinite(var1[var3])) {
                  throw new IllegalArgumentException("illegal weight value: infinite");
               }

               if ((double)var1[var3] < 0.0) {
                  throw new IllegalArgumentException("illegal weight value: negative");
               }

               var2 += var1[var3];
            }

            if ((double)var2 <= 0.0) {
               throw new IllegalArgumentException("illegal weight values: all zero");
            } else {
               this.weights = var1;
            }
         }
      } else {
         this.weights = null;
      }
   }

   public String toString() {
      if (this.rules != null && this.rules.length != 0) {
         StringBuffer var1 = new StringBuffer();

         for(int var2 = 0; var2 < this.rules.length; ++var2) {
            if (var2 > 0) {
               var1.append(" | ");
            }

            if (this.weights != null) {
               var1.append("/" + this.weights[var2] + "/ ");
            }

            if (this.rules[var2] instanceof RuleAlternatives) {
               var1.append("( " + this.rules[var2].toString() + " )");
            } else {
               var1.append(this.rules[var2].toString());
            }
         }

         return var1.toString();
      } else {
         return "<VOID>";
      }
   }
}
