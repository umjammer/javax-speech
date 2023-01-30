package javax.speech;

import java.util.Vector;

public class EngineList extends Vector {
   public synchronized boolean anyMatch(EngineModeDesc var1) {
      for(int var2 = 0; var2 < this.size(); ++var2) {
         EngineModeDesc var3 = (EngineModeDesc)this.elementAt(var2);
         if (var3.match(var1)) {
            return true;
         }
      }

      return false;
   }

   public synchronized void orderByMatch(EngineModeDesc var1) {
      EngineList var2 = new EngineList();
      EngineList var3 = new EngineList();

      for(int var4 = 0; var4 < this.size(); ++var4) {
         EngineModeDesc var5 = (EngineModeDesc)this.elementAt(var4);
         if (var5.match(var1)) {
            var2.addElement(var5);
         } else {
            var3.addElement(var5);
         }
      }

      this.removeAllElements();

      for(int var7 = 0; var7 < var2.size(); ++var7) {
         this.addElement(var2.elementAt(var7));
      }

      for(int var6 = 0; var6 < var3.size(); ++var6) {
         this.addElement(var3.elementAt(var6));
      }

   }

   public synchronized void rejectMatch(EngineModeDesc var1) {
      for(int var2 = this.size() - 1; var2 >= 0; --var2) {
         EngineModeDesc var3 = (EngineModeDesc)this.elementAt(var2);
         if (var3.match(var1)) {
            this.removeElementAt(var2);
         }
      }

   }

   public synchronized void requireMatch(EngineModeDesc var1) {
      for(int var2 = this.size() - 1; var2 >= 0; --var2) {
         EngineModeDesc var3 = (EngineModeDesc)this.elementAt(var2);
         if (!var3.match(var1)) {
            this.removeElementAt(var2);
         }
      }

   }
}
