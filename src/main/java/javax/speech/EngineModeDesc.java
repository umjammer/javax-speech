package javax.speech;

import java.util.Locale;

public class EngineModeDesc {
   private String engineName;
   private String modeName;
   private Locale locale;
   private Boolean running;

   public EngineModeDesc() {
      this.engineName = null;
      this.modeName = null;
      this.locale = null;
      this.running = null;
   }

   public EngineModeDesc(String var1, String var2, Locale var3, Boolean var4) {
      this.engineName = var1;
      this.modeName = var2;
      this.locale = var3;
      this.running = var4;
   }

   public EngineModeDesc(Locale var1) {
      this.engineName = null;
      this.modeName = null;
      this.locale = var1;
      this.running = null;
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof EngineModeDesc) {
         EngineModeDesc var2 = (EngineModeDesc)var1;
         if (this.engineName == null) {
            if (var2.engineName != null) {
               return false;
            }
         } else if (!this.engineName.equals(var2.engineName)) {
            return false;
         }

         if (this.modeName == null) {
            if (var2.modeName != null) {
               return false;
            }
         } else if (!this.modeName.equals(var2.modeName)) {
            return false;
         }

         if (this.locale == null) {
            if (var2.locale != null) {
               return false;
            }
         } else if (!this.locale.equals(var2.locale)) {
            return false;
         }

         if (this.running == null != (var2.running == null)) {
            return false;
         } else {
            return this.running == null || this.running.equals(var2.running);
         }
      } else {
         return false;
      }
   }

   public String getEngineName() {
      return this.engineName;
   }

   public Locale getLocale() {
      return this.locale;
   }

   public String getModeName() {
      return this.modeName;
   }

   public Boolean getRunning() {
      return this.running;
   }

   public boolean match(EngineModeDesc var1) {
      if (var1.locale != null) {
         if (this.locale == null) {
            return false;
         }

         if (var1.locale.getLanguage() != null && !var1.locale.getLanguage().equals("") && !var1.locale.getLanguage().equals(this.locale.getLanguage())) {
            return false;
         }

         if (var1.locale.getCountry() != null && !var1.locale.getCountry().equals("") && !var1.locale.getCountry().equals(this.locale.getCountry())) {
            return false;
         }
      }

      if (var1.modeName != null && !var1.modeName.equals("")) {
         if (this.modeName == null) {
            return false;
         }

         if (!this.modeName.equals(var1.modeName)) {
            return false;
         }
      }

      if (var1.engineName != null && !var1.engineName.equals("")) {
         if (this.engineName == null) {
            return false;
         }

         if (!this.engineName.equals(var1.engineName)) {
            return false;
         }
      }

      return var1.running == null || var1.running.equals(this.running);
   }

   public void setEngineName(String var1) {
      this.engineName = var1;
   }

   public void setLocale(Locale var1) {
      this.locale = var1;
   }

   public void setModeName(String var1) {
      this.modeName = var1;
   }

   public void setRunning(Boolean var1) {
      this.running = var1;
   }
}
