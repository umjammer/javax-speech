package javax.speech.synthesis;

import java.util.Locale;
import javax.speech.EngineModeDesc;

public class SynthesizerModeDesc extends EngineModeDesc {
   private Voice[] voices;

   public SynthesizerModeDesc() {
      this.voices = null;
   }

   public SynthesizerModeDesc(String var1, String var2, Locale var3, Boolean var4, Voice[] var5) {
      super(var1, var2, var3, var4);
      this.voices = var5;
   }

   public SynthesizerModeDesc(Locale var1) {
      super(var1);
      this.voices = null;
   }

   public void addVoice(Voice var1) {
      int var2 = 0;
      if (this.voices != null) {
         var2 = this.voices.length;
      }

      Voice[] var3 = new Voice[var2 + 1];
      if (var2 > 0) {
         System.arraycopy(this.voices, 0, var3, 0, var2);
      }

      var3[var2] = var1;
      this.voices = var3;
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof SynthesizerModeDesc) {
         SynthesizerModeDesc var2 = (SynthesizerModeDesc)var1;
         if (!super.equals(var1)) {
            return false;
         } else if (this.voices == null != (var2.voices == null)) {
            return false;
         } else {
            if (this.voices != null) {
               if (this.voices.length != var2.voices.length) {
                  return false;
               }

               for(int var3 = 0; var3 < this.voices.length; ++var3) {
                  if (this.voices[var3] == null) {
                     if (var2.voices[var3] != null) {
                        return false;
                     }
                  } else if (!this.voices[var3].equals(var2.voices[var3])) {
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

   public Voice[] getVoices() {
      return this.voices;
   }

   public boolean match(EngineModeDesc var1) {
      if (!super.match(var1)) {
         return false;
      } else if (!(var1 instanceof SynthesizerModeDesc)) {
         return true;
      } else {
         SynthesizerModeDesc var2 = (SynthesizerModeDesc)var1;
         if (!super.match(var2)) {
            return false;
         } else {
            if (var2.voices != null) {
               if (this.voices == null) {
                  return false;
               }

               for(int var3 = 0; var3 < var2.voices.length; ++var3) {
                  boolean var4 = false;
                  if (var2.voices[var3] != null) {
                     for(int var5 = 0; !var4 && var5 < this.voices.length; ++var5) {
                        if (this.voices[var5].match(var2.voices[var3])) {
                           var4 = true;
                        }
                     }

                     if (!var4) {
                        return false;
                     }
                  }
               }
            }

            return true;
         }
      }
   }

   public void setVoices(Voice[] var1) {
      this.voices = var1;
   }
}
