package javax.speech;

import java.awt.Component;
import java.beans.PropertyChangeListener;

public interface EngineProperties {
   void addPropertyChangeListener(PropertyChangeListener var1);

   Component getControlComponent();

   void removePropertyChangeListener(PropertyChangeListener var1);

   void reset();
}
