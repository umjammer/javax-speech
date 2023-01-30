package javax.speech.recognition;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import javax.speech.Engine;
import javax.speech.EngineStateError;
import javax.speech.VendorDataException;

public interface Recognizer extends Engine {
   long LISTENING = 4294967296L;
   long PROCESSING = 8589934592L;
   long SUSPENDED = 17179869184L;
   long FOCUS_ON = 281474976710656L;
   long FOCUS_OFF = 562949953421312L;

   void addResultListener(ResultListener var1);

   void commitChanges() throws GrammarException, EngineStateError;

   void deleteRuleGrammar(RuleGrammar var1) throws IllegalArgumentException, EngineStateError;

   void forceFinalize(boolean var1) throws EngineStateError;

   DictationGrammar getDictationGrammar(String var1) throws EngineStateError;

   RecognizerProperties getRecognizerProperties();

   RuleGrammar getRuleGrammar(String var1) throws EngineStateError;

   SpeakerManager getSpeakerManager() throws SecurityException;

   RuleGrammar[] listRuleGrammars() throws EngineStateError;

   RuleGrammar loadJSGF(Reader var1) throws GrammarException, IOException, EngineStateError;

   RuleGrammar loadJSGF(URL var1, String var2) throws GrammarException, MalformedURLException, IOException, EngineStateError;

   RuleGrammar loadJSGF(URL var1, String var2, boolean var3, boolean var4, Vector var5) throws GrammarException, MalformedURLException, IOException, EngineStateError;

   RuleGrammar newRuleGrammar(String var1) throws IllegalArgumentException, EngineStateError;

   Grammar readVendorGrammar(InputStream var1) throws VendorDataException, IOException, EngineStateError;

   Result readVendorResult(InputStream var1) throws VendorDataException, IOException, EngineStateError;

   void releaseFocus() throws EngineStateError;

   void removeResultListener(ResultListener var1);

   void requestFocus() throws EngineStateError;

   void suspend() throws EngineStateError;

   void writeVendorGrammar(OutputStream var1, Grammar var2) throws IOException, EngineStateError;

   void writeVendorResult(OutputStream var1, Result var2) throws IOException, ResultStateError, EngineStateError;
}
