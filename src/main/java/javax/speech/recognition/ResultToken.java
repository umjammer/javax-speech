package javax.speech.recognition;

public interface ResultToken {
   String NEW_PARAGRAPH = "\u2029";
   String NEW_LINE = "\n";
   int SEPARATE = 0;
   int ATTACH_PREVIOUS = 1;
   int ATTACH_FOLLOWING = 2;
   int ATTACH_GROUP = 4;
   int CAP_AS_IS = 10;
   int CAP_FIRST = 11;
   int UPPERCASE = 12;
   int LOWERCASE = 13;

   int getCapitalizationHint();

   long getEndTime();

   Result getResult();

   int getSpacingHint();

   String getSpokenText();

   long getStartTime();

   String getWrittenText();
}
