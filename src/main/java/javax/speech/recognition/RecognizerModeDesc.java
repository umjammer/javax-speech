package javax.speech.recognition;

import java.util.Locale;
import javax.speech.EngineModeDesc;

public class RecognizerModeDesc extends EngineModeDesc {
   private Boolean dictationGrammarSupported;
   private SpeakerProfile[] profiles;

   public RecognizerModeDesc() {
      this.dictationGrammarSupported = null;
      this.profiles = null;
   }

   public RecognizerModeDesc(String var1, String var2, Locale var3, Boolean var4, Boolean var5, SpeakerProfile[] var6) {
      super(var1, var2, var3, var4);
      this.dictationGrammarSupported = var5;
      this.profiles = var6;
   }

   public RecognizerModeDesc(Locale var1, Boolean var2) {
      super(var1);
      this.dictationGrammarSupported = var2;
      this.profiles = null;
   }

   public synchronized void addSpeakerProfile(SpeakerProfile var1) {
      if (this.profiles == null) {
         this.profiles = new SpeakerProfile[1];
         this.profiles[0] = var1;
      } else {
         SpeakerProfile[] var2 = new SpeakerProfile[this.profiles.length + 1];
         System.arraycopy(this.profiles, 0, var2, 0, this.profiles.length);
         var2[var2.length - 1] = var1;
         this.profiles = var2;
      }
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof RecognizerModeDesc) {
         RecognizerModeDesc var2 = (RecognizerModeDesc)var1;
         if (!super.equals(var1)) {
            return false;
         } else if (this.dictationGrammarSupported == null != (var2.dictationGrammarSupported == null)) {
            return false;
         } else if (this.dictationGrammarSupported != null && !this.dictationGrammarSupported.equals(var2.dictationGrammarSupported)) {
            return false;
         } else if (this.profiles == null != (var2.profiles == null)) {
            return false;
         } else {
            if (this.profiles != null) {
               if (this.profiles.length != var2.profiles.length) {
                  return false;
               }

               for(int var3 = 0; var3 < this.profiles.length; ++var3) {
                  if (this.profiles[var3] == null) {
                     if (var2.profiles[var3] != null) {
                        return false;
                     }
                  } else if (!this.profiles[var3].equals(var2.profiles[var3])) {
                     return false;
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public final SpeakerProfile[] getSpeakerProfiles() throws SecurityException {
      return this.getSpeakerProfilesImpl();
   }

   protected SpeakerProfile[] getSpeakerProfilesImpl() {
      return this.profiles;
   }

   public Boolean isDictationGrammarSupported() {
      return this.dictationGrammarSupported;
   }

   public boolean match(EngineModeDesc var1) {
      if (!super.match(var1)) {
         return false;
      } else if (!(var1 instanceof RecognizerModeDesc)) {
         return true;
      } else {
         RecognizerModeDesc var2 = (RecognizerModeDesc)var1;
         if (var2.dictationGrammarSupported != null && !var2.dictationGrammarSupported.equals(this.dictationGrammarSupported)) {
            return false;
         } else {
            if (var2.profiles != null && var2.profiles.length > 0) {
               if (this.profiles == null) {
                  return false;
               }

               for(int var3 = 0; var3 < var2.profiles.length; ++var3) {
                  boolean var4 = false;

                  for(int var5 = 0; !var4 && var5 < this.profiles.length; ++var5) {
                     if (this.profiles[var5].match(var2.profiles[var3])) {
                        var4 = true;
                     }
                  }

                  if (!var4) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }

   public void setDictationGrammarSupported(Boolean var1) {
      this.dictationGrammarSupported = var1;
   }

   public void setSpeakerProfiles(SpeakerProfile[] var1) {
      this.profiles = this.profiles;
   }
}
