package javax.speech.synthesis;

public class Voice implements Cloneable {
   public static final int GENDER_DONT_CARE = 65535;
   public static final int GENDER_FEMALE = 1;
   public static final int GENDER_MALE = 2;
   public static final int GENDER_NEUTRAL = 4;
   public static final int AGE_DONT_CARE = 65535;
   public static final int AGE_CHILD = 1;
   public static final int AGE_TEENAGER = 2;
   public static final int AGE_YOUNGER_ADULT = 4;
   public static final int AGE_MIDDLE_ADULT = 8;
   public static final int AGE_OLDER_ADULT = 16;
   public static final int AGE_NEUTRAL = 32;
   private String name;
   private int gender;
   private int age;
   private String style;

   public Voice() {
      this.name = null;
      this.gender = 65535;
      this.age = 65535;
      this.style = null;
   }

   public Voice(String var1, int var2, int var3, String var4) {
      this.name = var1;
      this.gender = var2;
      this.age = var3;
      this.style = var4;
   }

   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException var1) {
         throw new InternalError();
      }
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof Voice) {
         Voice var2 = (Voice)var1;
         if (this.name == null) {
            if (var2.name != null) {
               return false;
            }
         } else if (!this.name.equals(var2.name)) {
            return false;
         }

         if (this.style == null) {
            if (var2.style != null) {
               return false;
            }
         } else if (!this.style.equals(var2.style)) {
            return false;
         }

         return this.gender == var2.gender && this.age == var2.age;
      } else {
         return false;
      }
   }

   public int getAge() {
      return this.age;
   }

   public int getGender() {
      return this.gender;
   }

   public String getName() {
      return this.name;
   }

   public String getStyle() {
      return this.style;
   }

   public boolean match(Voice var1) {
      if (var1.name != null && !var1.name.equals("")) {
         if (this.name == null) {
            return false;
         }

         if (!this.name.equals(var1.name)) {
            return false;
         }
      }

      if (var1.style != null && !var1.style.equals("")) {
         if (this.style == null) {
            return false;
         }

         if (!this.style.equals(var1.style)) {
            return false;
         }
      }

      if ((var1.gender & this.gender) == 0) {
         return false;
      } else {
         return (var1.age & this.age) != 0;
      }
   }

   public void setAge(int var1) {
      this.age = var1;
   }

   public void setGender(int var1) {
      this.gender = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setStyle(String var1) {
      this.style = var1;
   }
}
