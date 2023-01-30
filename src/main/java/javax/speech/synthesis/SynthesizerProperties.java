package javax.speech.synthesis;

import java.beans.PropertyVetoException;
import javax.speech.EngineProperties;

public interface SynthesizerProperties extends EngineProperties {
   float getPitch();

   float getPitchRange();

   float getSpeakingRate();

   Voice getVoice();

   float getVolume();

   void setPitch(float var1) throws PropertyVetoException;

   void setPitchRange(float var1) throws PropertyVetoException;

   void setSpeakingRate(float var1) throws PropertyVetoException;

   void setVoice(Voice var1) throws PropertyVetoException;

   void setVolume(float var1) throws PropertyVetoException;
}
