package javax.speech.recognition;

import java.io.Serializable;

public abstract class Rule implements Serializable {
   public abstract Rule copy();

   public abstract String toString();
}
