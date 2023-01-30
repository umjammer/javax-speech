package javax.speech.recognition;

import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.speech.VendorDataException;

public interface SpeakerManager {
   void deleteSpeaker(SpeakerProfile var1) throws IllegalArgumentException;

   Component getControlComponent();

   SpeakerProfile getCurrentSpeaker();

   SpeakerProfile[] listKnownSpeakers();

   SpeakerProfile newSpeakerProfile(SpeakerProfile var1) throws IllegalArgumentException;

   SpeakerProfile readVendorSpeakerProfile(InputStream var1) throws IOException, VendorDataException;

   void revertCurrentSpeaker();

   void saveCurrentSpeakerProfile();

   void setCurrentSpeaker(SpeakerProfile var1) throws IllegalArgumentException;

   void writeVendorSpeakerProfile(OutputStream var1, SpeakerProfile var2) throws IOException;
}
