package javax.speech.recognition;

public interface RuleGrammar extends Grammar {
   void addImport(RuleName var1);

   void deleteRule(String var1) throws IllegalArgumentException;

   Rule getRule(String var1);

   Rule getRuleInternal(String var1);

   boolean isEnabled();

   boolean isEnabled(String var1) throws IllegalArgumentException;

   boolean isRulePublic(String var1) throws IllegalArgumentException;

   RuleName[] listImports();

   String[] listRuleNames();

   RuleParse parse(String var1, String var2) throws GrammarException;

   RuleParse parse(FinalRuleResult var1, int var2, String var3) throws GrammarException;

   RuleParse parse(String[] var1, String var2) throws GrammarException;

   void removeImport(RuleName var1) throws IllegalArgumentException;

   RuleName resolve(RuleName var1) throws GrammarException;

   Rule ruleForJSGF(String var1) throws GrammarException;

   void setEnabled(String var1, boolean var2) throws IllegalArgumentException;

   void setEnabled(boolean var1);

   void setEnabled(String[] var1, boolean var2) throws IllegalArgumentException;

   void setRule(String var1, Rule var2, boolean var3) throws NullPointerException, IllegalArgumentException;

   String toString();
}
