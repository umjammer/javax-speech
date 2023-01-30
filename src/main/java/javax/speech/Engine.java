package javax.speech;

public interface Engine {
   long DEALLOCATED = 1L;
   long ALLOCATING_RESOURCES = 2L;
   long ALLOCATED = 4L;
   long DEALLOCATING_RESOURCES = 8L;
   long PAUSED = 256L;
   long RESUMED = 512L;

   void addEngineListener(EngineListener var1);

   void allocate() throws EngineException, EngineStateError;

   void deallocate() throws EngineException, EngineStateError;

   AudioManager getAudioManager();

   EngineModeDesc getEngineModeDesc() throws SecurityException;

   EngineProperties getEngineProperties();

   long getEngineState();

   VocabManager getVocabManager() throws EngineStateError;

   void pause() throws EngineStateError;

   void removeEngineListener(EngineListener var1);

   void resume() throws AudioException, EngineStateError;

   boolean testEngineState(long var1) throws IllegalArgumentException;

   void waitEngineState(long var1) throws InterruptedException, IllegalArgumentException;
}
