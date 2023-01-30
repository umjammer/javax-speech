package javax.speech;

public class Word {
   private long categories;
   private String writtenForm;
   private String spokenForm;
   private String[] pronunciations;
   public static final long UNKNOWN = 0L;
   public static final long DONT_CARE = 1L;
   public static final long OTHER = 2L;
   public static final long NOUN = 4L;
   public static final long PROPER_NOUN = 8L;
   public static final long PRONOUN = 16L;
   public static final long VERB = 32L;
   public static final long ADVERB = 64L;
   public static final long ADJECTIVE = 128L;
   public static final long PROPER_ADJECTIVE = 256L;
   public static final long AUXILIARY = 512L;
   public static final long DETERMINER = 1024L;
   public static final long CARDINAL = 2048L;
   public static final long CONJUNCTION = 4096L;
   public static final long PREPOSITION = 8192L;
   public static final long CONTRACTION = 16384L;
   public static final long ABBREVIATION = 32768L;

   public long getCategories() {
      return this.categories;
   }

   public String[] getPronunciations() {
      return this.pronunciations;
   }

   public String getSpokenForm() {
      return this.spokenForm;
   }

   public String getWrittenForm() {
      return this.writtenForm;
   }

   public void setCategories(long var1) {
      this.categories = var1;
   }

   public void setPronunciations(String[] var1) {
      this.pronunciations = var1;
   }

   public void setSpokenForm(String var1) {
      this.spokenForm = var1;
   }

   public void setWrittenForm(String var1) {
      this.writtenForm = var1;
   }
}
