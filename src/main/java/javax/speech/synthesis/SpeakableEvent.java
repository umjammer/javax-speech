package javax.speech.synthesis;

import javax.speech.SpeechEvent;

public class SpeakableEvent extends SpeechEvent {
   public static final int TOP_OF_QUEUE = 601;
   public static final int SPEAKABLE_STARTED = 602;
   public static final int SPEAKABLE_ENDED = 603;
   public static final int SPEAKABLE_PAUSED = 604;
   public static final int SPEAKABLE_RESUMED = 605;
   public static final int SPEAKABLE_CANCELLED = 606;
   public static final int WORD_STARTED = 607;
   public static final int MARKER_REACHED = 608;
   public static final int ELEMENT_OPEN = 620;
   public static final int ELEMENT_CLOSE = 621;
   public static final int ELEMENT_EMPTY = 622;
   protected String text;
   protected int markerType;
   protected int wordStart;
   protected int wordEnd;

   public SpeakableEvent(Object var1, int var2) {
      super(var1, var2);
      this.text = null;
      this.markerType = -1;
      this.wordStart = -1;
      this.wordEnd = -1;
   }

   public SpeakableEvent(Object var1, int var2, String var3, int var4) {
      super(var1, var2);
      this.text = var3;
      this.markerType = var4;
      this.wordStart = -1;
      this.wordEnd = -1;
   }

   public SpeakableEvent(Object var1, int var2, String var3, int var4, int var5) {
      super(var1, var2);
      this.text = var3;
      this.markerType = -1;
      this.wordStart = var4;
      this.wordEnd = var5;
   }

   public int getMarkerType() {
      return this.markerType;
   }

   public String getText() {
      return this.text;
   }

   public int getWordEnd() {
      return this.wordEnd;
   }

   public int getWordStart() {
      return this.wordStart;
   }

   public String paramString() {
      switch (super.id) {
         case 601:
            return "TOP_OF_QUEUE";
         case 602:
            return "SPEAKABLE_STARTED";
         case 603:
            return "SPEAKABLE_ENDED";
         case 604:
            return "SPEAKABLE_PAUSED";
         case 605:
            return "SPEAKABLE_RESUMED";
         case 606:
            return "SPEAKABLE_CANCELLED";
         case 607:
            return "WORD_STARTED \"" + this.text + "\" from: " + this.wordStart + " to: " + this.wordEnd;
         case 608:
            StringBuffer var1 = new StringBuffer("MARKER_REACHED: ");
            var1.append("\"" + this.text + "\" at ");
            switch (this.markerType) {
               case 620:
                  var1.append("ELEMENT_OPEN");
                  break;
               case 621:
                  var1.append("ELEMENT_CLOSE");
                  break;
               case 622:
                  var1.append("ELEMENT_EMPTY");
                  break;
               default:
                  var1.append("unknown type");
            }

            return var1.toString();
         default:
            return super.paramString();
      }
   }
}
