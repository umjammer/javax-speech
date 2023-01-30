package javax.speech.recognition;

import java.beans.PropertyVetoException;
import javax.speech.EngineProperties;

public interface RecognizerProperties extends EngineProperties {
   float getCompleteTimeout();

   float getConfidenceLevel();

   float getIncompleteTimeout();

   int getNumResultAlternatives();

   float getSensitivity();

   float getSpeedVsAccuracy();

   boolean isResultAudioProvided();

   boolean isTrainingProvided();

   void setCompleteTimeout(float var1) throws PropertyVetoException;

   void setConfidenceLevel(float var1) throws PropertyVetoException;

   void setIncompleteTimeout(float var1) throws PropertyVetoException;

   void setNumResultAlternatives(int var1) throws PropertyVetoException;

   void setResultAudioProvided(boolean var1) throws PropertyVetoException;

   void setSensitivity(float var1) throws PropertyVetoException;

   void setSpeedVsAccuracy(float var1) throws PropertyVetoException;

   void setTrainingProvided(boolean var1) throws PropertyVetoException;
}
