package javax.speech.recognition;

import java.util.StringTokenizer;

public class RuleName extends Rule {
   protected String fullRuleName;
   protected String packageName;
   protected String simpleGrammarName;
   protected String simpleRuleName;
   public static RuleName NULL = new RuleName("NULL");
   public static RuleName VOID = new RuleName("VOID");

   public RuleName() {
      this.setRuleName("NULL");
   }

   public RuleName(String var1) {
      this.setRuleName(var1);
   }

   public RuleName(String var1, String var2, String var3) throws IllegalArgumentException {
      this.setRuleName(var1, var2, var3);
   }

   public Rule copy() {
      return new RuleName(this.packageName, this.simpleGrammarName, this.simpleRuleName);
   }

   public String getFullGrammarName() {
      return this.packageName != null ? this.packageName + "." + this.simpleGrammarName : this.simpleGrammarName;
   }

   public String getPackageName() {
      return this.packageName;
   }

   public String getRuleName() {
      return this.fullRuleName;
   }

   public String getSimpleGrammarName() {
      return this.simpleGrammarName;
   }

   public String getSimpleRuleName() {
      return this.simpleRuleName;
   }

   public boolean isLegalRuleName() {
      return isLegalRuleName(this.fullRuleName);
   }

   public static boolean isLegalRuleName(String var0) {
      if (var0 == null) {
         return false;
      } else {
         var0 = stripRuleName(var0);
         if (var0.endsWith(".*")) {
            var0 = var0.substring(0, var0.length() - 2);
         }

         if (var0.length() == 0) {
            return false;
         } else if (!var0.startsWith(".") && !var0.endsWith(".") && var0.indexOf("..") < 0) {
            StringTokenizer var1 = new StringTokenizer(var0, ".");

            while(var1.hasMoreTokens()) {
               String var2 = var1.nextToken();
               int var3 = var2.length();
               if (var3 == 0) {
                  return false;
               }

               for(int var4 = 0; var4 < var3; ++var4) {
                  if (!isRuleNamePart(var2.charAt(var4))) {
                     return false;
                  }
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public static boolean isRuleNamePart(char var0) {
      if (Character.isJavaIdentifierPart(var0)) {
         return true;
      } else {
         return var0 == '!' || var0 == '#' || var0 == '%' || var0 == '&' || var0 == '(' || var0 == ')' || var0 == '+' || var0 == ',' || var0 == '-' || var0 == '/' || var0 == ':' || var0 == ';' || var0 == '=' || var0 == '@' || var0 == '[' || var0 == '\\' || var0 == ']' || var0 == '^' || var0 == '|' || var0 == '~';
      }
   }

   public void setRuleName(String var1) {
      String var2 = stripRuleName(var1);
      this.fullRuleName = var2;
      int var4 = var2.lastIndexOf(46);
      if (var4 < 0) {
         this.packageName = null;
         this.simpleGrammarName = null;
         this.simpleRuleName = var2;
      } else {
         int var3 = var2.lastIndexOf(46, var4 - 1);
         if (var3 < 0) {
            this.packageName = null;
            this.simpleGrammarName = var2.substring(0, var4);
            this.simpleRuleName = var2.substring(var4 + 1);
         } else {
            this.packageName = var2.substring(0, var3);
            this.simpleGrammarName = var2.substring(var3 + 1, var4);
            this.simpleRuleName = var2.substring(var4 + 1);
         }
      }

   }

   public void setRuleName(String var1, String var2, String var3) throws IllegalArgumentException {
      if (var2 == null && var1 != null) {
         throw new IllegalArgumentException("null simpleGrammarName with non-null packageName");
      } else {
         this.packageName = var1;
         this.simpleGrammarName = var2;
         this.simpleRuleName = stripRuleName(var3);
         StringBuffer var4 = new StringBuffer();
         if (var1 != null) {
            var4.append(var1 + '.');
         }

         if (var2 != null) {
            var4.append(var2 + '.');
         }

         var4.append(var3);
         this.fullRuleName = var4.toString();
      }
   }

   private static String stripRuleName(String var0) {
      return var0.startsWith("<") && var0.endsWith(">") ? var0.substring(1, var0.length() - 1) : var0;
   }

   public String toString() {
      return "<" + this.fullRuleName + ">";
   }
}
