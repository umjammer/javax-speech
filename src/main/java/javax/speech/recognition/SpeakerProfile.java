package javax.speech.recognition;

public class SpeakerProfile {
   protected String id;
   protected String name;
   protected String variant;

   public SpeakerProfile() {
      this.id = null;
      this.name = null;
      this.variant = null;
   }

   public SpeakerProfile(String var1, String var2, String var3) {
      this.id = var1;
      this.name = var2;
      this.variant = var3;
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof SpeakerProfile) {
         SpeakerProfile var2 = (SpeakerProfile)var1;
         if (this.id == null) {
            if (var2.id != null) {
               return false;
            }
         } else if (!this.id.equals(var2.id)) {
            return false;
         }

         if (this.name == null) {
            if (var2.name != null) {
               return false;
            }
         } else if (!this.name.equals(var2.name)) {
            return false;
         }

         if (this.variant == null) {
            if (var2.variant != null) {
               return false;
            }
         } else if (!this.variant.equals(var2.variant)) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   public String getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getVariant() {
      return this.variant;
   }

   public boolean match(SpeakerProfile var1) {
      if (var1.id != null && !var1.id.equals(this.id)) {
         return false;
      } else if (var1.name != null && !var1.name.equals(this.name)) {
         return false;
      } else {
         return var1.variant == null || var1.variant.equals(this.variant);
      }
   }

   public void setId(String var1) throws IllegalArgumentException {
      this.id = this.id;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setVariant(String var1) {
      this.variant = var1;
   }
}
