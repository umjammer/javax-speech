package javax.speech.recognition;

import java.net.URL;

public class GrammarSyntaxDetail {
   public String grammarName = null;
   public URL grammarLocation = null;
   public String ruleName = null;
   public RuleName importName = null;
   public int lineNumber = -1;
   public int charNumber = -1;
   public String message = null;

   public GrammarSyntaxDetail() {
   }

   public GrammarSyntaxDetail(String var1, URL var2, String var3, RuleName var4, int var5, int var6, String var7) {
      this.grammarName = var1;
      this.grammarLocation = var2;
      this.ruleName = var3;
      this.importName = var4;
      this.lineNumber = var5;
      this.charNumber = var6;
      this.message = var7;
   }
}
