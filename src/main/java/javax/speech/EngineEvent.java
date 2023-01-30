package javax.speech;

public class EngineEvent extends SpeechEvent {
   public static final int ENGINE_ALLOCATED = 501;
   public static final int ENGINE_DEALLOCATED = 502;
   public static final int ENGINE_ALLOCATING_RESOURCES = 503;
   public static final int ENGINE_DEALLOCATING_RESOURCES = 504;
   public static final int ENGINE_PAUSED = 505;
   public static final int ENGINE_RESUMED = 506;
   protected long newEngineState;
   protected long oldEngineState;

   public EngineEvent(Engine var1, int var2, long var3, long var5) {
      super(var1, var2);
      this.oldEngineState = var3;
      this.newEngineState = var5;
   }

   public long getNewEngineState() {
      return this.newEngineState;
   }

   public long getOldEngineState() {
      return this.oldEngineState;
   }

   public String paramString() {
      switch (super.id) {
         case 501:
            return "ENGINE_ALLOCATED";
         case 502:
            return "ENGINE_DEALLOCATED";
         case 503:
            return "ENGINE_ALLOCATING_RESOURCES";
         case 504:
            return "ENGINE_DEALLOCATING_RESOURCES";
         case 505:
            return "ENGINE_PAUSED";
         case 506:
            return "ENGINE_RESUMED";
         default:
            return super.paramString();
      }
   }
}
