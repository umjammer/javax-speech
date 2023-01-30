package javax.speech;

public interface EngineCreate {
   Engine createEngine() throws IllegalArgumentException, EngineException, SecurityException;
}
