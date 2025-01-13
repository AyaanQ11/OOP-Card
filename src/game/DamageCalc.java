// Source code is decompiled from a .class file using FernFlower decompiler.
package game;

class DamageCalc {
   String elementP;
   String elementB;
   int damage;
   double dmgMulti;
   double dmgReduc;

   DamageCalc() {
      this.elementP = "none";
      this.elementB = "none";
      this.damage = 0;
      this.dmgMulti = 1.0;
      this.dmgReduc = 1.0;
   }

   DamageCalc(String var1, String var2, int var3, double var4, double var6) {
      this.elementP = var1;
      this.elementB = var2;
      this.damage = var3;
      this.dmgMulti = var4;
      this.dmgReduc = var6;
   }

   public void setElementP(String var1) {
      this.elementP = var1;
   }

   public void setElementB(String var1) {
      this.elementB = var1;
   }

   public void setDamage(int var1) {
      this.damage = var1;
   }

   public void setDmgMulti(double var1) {
      this.dmgMulti = var1;
   }

   public void setDmgReduc(double var1) {
      this.dmgReduc = var1;
   }

   public String getElementP() {
      return this.elementP;
   }

   public String getElementB() {
      return this.elementB;
   }

   public int getDamage() {
      return this.damage;
   }

   public double getDmgMulti() {
      return this.dmgMulti;
   }

   public double getDmgReduc() {
      return this.dmgReduc;
   }

   public double getRandMulti(double var1, double var3) {
      return var1 + Math.random() * (var3 - var1);
   }

   public void dmgMultiCalc() {
      if (this.elementP.equalsIgnoreCase("water") && this.elementB.equalsIgnoreCase("fire")) {
         this.dmgMulti += 0.5;
      } else if (this.elementP.equalsIgnoreCase("earth") && this.elementB.equalsIgnoreCase("fire")) {
         this.dmgMulti += 0.5;
      } else if (this.elementP.equalsIgnoreCase("water") && this.elementB.equalsIgnoreCase("earth")) {
         this.dmgMulti += 0.5;
      } else if (this.elementP.equalsIgnoreCase("sky") && this.elementB.equalsIgnoreCase("earth")) {
         this.dmgMulti += 0.5;
      }

   }

   public void dmgCalc() {
      this.damage = (int)((double)this.damage * this.dmgMulti * this.dmgReduc);
   }
}
