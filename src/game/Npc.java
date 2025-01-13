// Source code is decompiled from a .class file using FernFlower decompiler.
package game;

public class Npc {
   private String name;
   private int fp;

   public Npc() {
      this.name = "Slime";
      this.fp = 0;
   }

   public Npc(String var1, int var2) {
      String var10001 = var1.substring(0, 1).toUpperCase();
      this.name = var10001 + var1.substring(1, var1.length()).toLowerCase();
      this.fp = var2;
   }

   public Npc(String var1) {
      String var10001 = var1.substring(0, 1).toUpperCase();
      this.name = var10001 + var1.substring(1, var1.length()).toLowerCase();
      this.fp = 0;
   }

   public void setName(String var1) {
      String var10001 = var1.substring(0, 1).toUpperCase();
      this.name = var10001 + var1.substring(1, var1.length()).toLowerCase();
   }

   public void setFp(int var1) {
      this.fp = var1;
   }

   public void addFp() {
      ++this.fp;
   }

   public void minusFp() {
      --this.fp;
   }

   public String getName() {
      return this.name;
   }

   public int getFp() {
      return this.fp;
   }
}
