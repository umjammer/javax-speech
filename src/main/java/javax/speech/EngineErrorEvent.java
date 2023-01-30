package javax.speech;

public class EngineErrorEvent extends EngineEvent {
   public static final int ENGINE_ERROR = 550;
   protected Throwable problem;

   public EngineErrorEvent(Engine var1, int var2, Throwable var3, long var4, long var6) {
      super(var1, var2, var4, var6);
   }

   public Throwable getEngineError() {
      return this.problem;
   }

   public String paramString() {
      switch (super.id) {
         case 550:
            return "ENGINE_ERROR: " + this.problem.getMessage();
         default:
            return super.paramString();
      }
   }
}
