package javax.speech;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.RecognizerModeDesc;
import javax.speech.recognition.SpeakerProfile;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

public class Central {
   private static boolean loadedProperties = false;
   private static Hashtable centralList = new Hashtable();
   private static Recognizer lastRecognizer = null;
   private static Synthesizer lastSynthesizer = null;

   public static final synchronized EngineList availableRecognizers(EngineModeDesc var0) throws SecurityException {
      if (var0 == null) {
         var0 = new RecognizerModeDesc();
      } else if (!(var0 instanceof RecognizerModeDesc)) {
         var0 = new RecognizerModeDesc(((EngineModeDesc)var0).getEngineName(), ((EngineModeDesc)var0).getModeName(), ((EngineModeDesc)var0).getLocale(), ((EngineModeDesc)var0).getRunning(), (Boolean)null, (SpeakerProfile[])null);
      }

      loadProps();
      EngineList var1 = new EngineList();
      Enumeration var2 = centralList.elements();

      while(true) {
         EngineList var4;
         do {
            if (!var2.hasMoreElements()) {
               return var1;
            }

            EngineCentral var3 = (EngineCentral)var2.nextElement();
            var4 = var3.createEngineList((EngineModeDesc)var0);
         } while(var4 == null);

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            if (var4.elementAt(var5) instanceof RecognizerModeDesc && var4.elementAt(var5) instanceof EngineCreate) {
               var1.addElement(var4.elementAt(var5));
            }
         }
      }
   }

   public static final synchronized EngineList availableSynthesizers(EngineModeDesc var0) throws SecurityException {
      if (var0 == null) {
         var0 = new SynthesizerModeDesc();
      } else if (!(var0 instanceof SynthesizerModeDesc)) {
         var0 = new SynthesizerModeDesc(((EngineModeDesc)var0).getEngineName(), ((EngineModeDesc)var0).getModeName(), ((EngineModeDesc)var0).getLocale(), ((EngineModeDesc)var0).getRunning(), (Voice[])null);
      }

      loadProps();
      EngineList var1 = new EngineList();
      Enumeration var2 = centralList.elements();

      while(true) {
         EngineList var4;
         do {
            if (!var2.hasMoreElements()) {
               return var1;
            }

            EngineCentral var3 = (EngineCentral)var2.nextElement();
            var4 = var3.createEngineList((EngineModeDesc)var0);
         } while(var4 == null);

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            if (var4.elementAt(var5) instanceof SynthesizerModeDesc && var4.elementAt(var5) instanceof EngineCreate) {
               var1.addElement(var4.elementAt(var5));
            }
         }
      }
   }

   public static final synchronized Recognizer createRecognizer(EngineModeDesc var0) throws IllegalArgumentException, EngineException, SecurityException {
      if (var0 == null) {
         var0 = new RecognizerModeDesc();
      }

      if (var0 instanceof EngineCreate) {
         EngineCreate var10 = (EngineCreate)var0;
         return (Recognizer)var10.createEngine();
      } else {
         boolean var1 = false;
         String var2 = Locale.getDefault().getLanguage();
         String var3 = Locale.getDefault().getCountry();
         if (((EngineModeDesc)var0).getLocale() == null) {
            ((EngineModeDesc)var0).setLocale(new Locale(var2, ""));
            var1 = true;
         }

         if (lastRecognizer != null && lastRecognizer.getEngineModeDesc().match((EngineModeDesc)var0)) {
            if (var1) {
               ((EngineModeDesc)var0).setLocale((Locale)null);
            }

            return lastRecognizer;
         } else {
            EngineList var4 = availableRecognizers((EngineModeDesc)var0);
            if (var4.isEmpty()) {
               return null;
            } else {
               if (var1) {
                  ((EngineModeDesc)var0).setLocale((Locale)null);
               }

               if (var1) {
                  var4.orderByMatch(new EngineModeDesc(new Locale(var2, var3)));
               }

               if (((EngineModeDesc)var0).getRunning() == null) {
                  EngineModeDesc var5 = new EngineModeDesc();
                  var5.setRunning(Boolean.TRUE);
                  var4.orderByMatch(var5);
               }

               for(int var11 = 0; var11 < var4.size(); ++var11) {
                  try {
                     EngineCreate var6 = (EngineCreate)var4.elementAt(var11);
                     Recognizer var7 = (Recognizer)var6.createEngine();
                     lastRecognizer = var7;
                     return var7;
                  } catch (IllegalArgumentException var8) {
                  } catch (EngineException var9) {
                  }
               }

               return null;
            }
         }
      }
   }

   public static final synchronized Synthesizer createSynthesizer(EngineModeDesc var0) throws IllegalArgumentException, EngineException {
      if (var0 == null) {
         var0 = new SynthesizerModeDesc();
      }

      if (var0 instanceof EngineCreate) {
         EngineCreate var10 = (EngineCreate)var0;
         return (Synthesizer)var10.createEngine();
      } else {
         boolean var1 = false;
         String var2 = Locale.getDefault().getLanguage();
         String var3 = Locale.getDefault().getCountry();
         if (((EngineModeDesc)var0).getLocale() == null) {
            ((EngineModeDesc)var0).setLocale(new Locale(var2, ""));
            var1 = true;
         }

         if (lastSynthesizer != null && lastSynthesizer.getEngineModeDesc().match((EngineModeDesc)var0)) {
            if (var1) {
               ((EngineModeDesc)var0).setLocale((Locale)null);
            }

            return lastSynthesizer;
         } else {
            EngineList var4 = availableSynthesizers((EngineModeDesc)var0);
            if (var4.isEmpty()) {
               return null;
            } else {
               if (var1) {
                  ((EngineModeDesc)var0).setLocale((Locale)null);
               }

               if (var1) {
                  var4.orderByMatch(new EngineModeDesc(new Locale(var2, var3)));
               }

               if (((EngineModeDesc)var0).getRunning() == null) {
                  EngineModeDesc var5 = new EngineModeDesc();
                  var5.setRunning(Boolean.TRUE);
                  var4.orderByMatch(var5);
               }

               for(int var11 = 0; var11 < var4.size(); ++var11) {
                  try {
                     EngineCreate var6 = (EngineCreate)var4.elementAt(var11);
                     Synthesizer var7 = (Synthesizer)var6.createEngine();
                     lastSynthesizer = var7;
                     return var7;
                  } catch (IllegalArgumentException var8) {
                  } catch (EngineException var9) {
                  }
               }

               return null;
            }
         }
      }
   }

   private static final synchronized void loadProps() {
      if (!loadedProperties) {
         loadedProperties = true;
         String var0 = File.separator;
         String[] var1 = new String[]{System.getProperty("user.home") + var0 + "speech.properties", System.getProperty("java.home") + var0 + "lib" + var0 + "speech.properties"};

         for(int var2 = 0; var2 < var1.length; ++var2) {
            String var3 = var1[var2];
            Properties var4 = new Properties();
            File var5 = new File(var3);

            try {
               FileInputStream var6 = new FileInputStream(var5);
               var4.load(new BufferedInputStream(var6));
               var6.close();
            } catch (FileNotFoundException var10) {
            } catch (IOException var11) {
            }

            Enumeration var12 = var4.propertyNames();

            while(var12.hasMoreElements()) {
               String var7 = (String)var12.nextElement();
               if (var7.endsWith("EngineCentral")) {
                  String var8 = var4.getProperty(var7);

                  try {
                     registerEngineCentral(var8);
                  } catch (EngineException var9) {
                  }
               }
            }
         }

      }
   }

   public static final synchronized void registerEngineCentral(String var0) throws EngineException {
      if (!centralList.containsKey(var0)) {
         Class var1;
         try {
            var1 = Class.forName(var0);
         } catch (ClassNotFoundException var4) {
            throw new EngineException("javax.speech.Central: no class found for " + var0);
         }

         try {
            EngineCentral var2 = (EngineCentral)var1.newInstance();
            centralList.put(var0, var2);
         } catch (Exception var3) {
            throw new EngineException("javax.speech.Central: error creating EngineCentral from " + var0);
         }
      }
   }
}
