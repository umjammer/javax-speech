package javax.speech.synthesis;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import javax.speech.Engine;
import javax.speech.EngineStateError;

public interface Synthesizer extends Engine {
   long QUEUE_EMPTY = 65536L;
   long QUEUE_NOT_EMPTY = 131072L;

   void addSpeakableListener(SpeakableListener var1);

   void cancel() throws EngineStateError;

   void cancel(Object var1) throws IllegalArgumentException, EngineStateError;

   void cancelAll() throws EngineStateError;

   Enumeration enumerateQueue() throws EngineStateError;

   SynthesizerProperties getSynthesizerProperties();

   String phoneme(String var1) throws EngineStateError;

   void removeSpeakableListener(SpeakableListener var1);

   void speak(String var1, SpeakableListener var2) throws JSMLException, EngineStateError;

   void speak(URL var1, SpeakableListener var2) throws JSMLException, MalformedURLException, IOException, EngineStateError;

   void speak(Speakable var1, SpeakableListener var2) throws JSMLException, EngineStateError;

   void speakPlainText(String var1, SpeakableListener var2) throws EngineStateError;
}
