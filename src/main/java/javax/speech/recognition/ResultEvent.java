package javax.speech.recognition;

import javax.speech.SpeechEvent;

public class ResultEvent extends SpeechEvent {
   public static final int RESULT_CREATED = 801;
   public static final int RESULT_UPDATED = 802;
   public static final int GRAMMAR_FINALIZED = 803;
   public static final int RESULT_ACCEPTED = 804;
   public static final int RESULT_REJECTED = 805;
   public static final int AUDIO_RELEASED = 806;
   public static final int TRAINING_INFO_RELEASED = 807;
   protected boolean tokenFinalized = false;
   protected boolean unfinalizedTokensChanged = false;

   public ResultEvent(Result var1, int var2) {
      super(var1, var2);
      this.tokenFinalized = false;
      this.unfinalizedTokensChanged = false;
   }

   public ResultEvent(Result var1, int var2, boolean var3, boolean var4) {
      super(var1, var2);
      this.tokenFinalized = var3;
      this.unfinalizedTokensChanged = var4;
   }

   public boolean isTokenFinalized() {
      return this.tokenFinalized;
   }

   public boolean isUnfinalizedTokensChanged() {
      return this.unfinalizedTokensChanged;
   }

   public String paramString() {
      StringBuffer var1 = new StringBuffer();
      switch (super.id) {
         case 801:
            var1.append("RESULT_CREATED");
            break;
         case 802:
            var1.append("RESULT_UPDATED");
            break;
         case 803:
            var1.append("GRAMMAR_FINALIZED");
            break;
         case 804:
            var1.append("RESULT_ACCEPTED");
            break;
         case 805:
            var1.append("RESULT_REJECTED");
            break;
         case 806:
            var1.append("AUDIO_RELEASED");
            break;
         case 807:
            var1.append("TRAINING_INFO_RELEASED");
            break;
         default:
            return super.paramString();
      }

      switch (super.id) {
         case 801:
         case 802:
         case 804:
         case 805:
            if (this.tokenFinalized) {
               var1.append(": token finalized");
            }

            if (this.unfinalizedTokensChanged) {
               var1.append(": unfinalized tokens changed");
            }
         case 803:
         default:
            return var1.toString();
      }
   }
}
