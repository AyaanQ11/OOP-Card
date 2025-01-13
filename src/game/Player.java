// Source code is decompiled from a .class file using FernFlower decompiler.
package game;

class Player {
   int hp;
   int mana;
   Boolean death;
   int bossHP;

   Player() {
      this.hp = 1000;
      this.mana = 200;
      this.death = false;
      this.bossHP = 500;
   }

   Player(int var1, int var2) {
      this.hp = var1;
      this.mana = 200;
      this.death = false;
      this.bossHP = var2;
   }

   public void setHp(int var1) {
      this.hp = var1;
   }

   public void setMana(int var1) {
      this.mana = var1;
   }

   public void setDeath(Boolean var1) {
      this.death = var1;
   }

   public void setBossHP(int var1) {
      this.bossHP = var1;
      this.hp = var1;
   }

   public int getBossHP() {
      return this.bossHP;
   }

   public int getHp() {
      return this.hp;
   }

   public int getMana() {
      return this.mana;
   }

   public Boolean getDeath() {
      if (this.hp <= 0) {
         this.death = true;
      }

      return this.death;
   }

   public void subtractHp(int var1) {
      if (var1 <= this.hp) {
         this.hp -= var1;
      } else {
         this.hp = 0;
      }

   }

   public void subtractMana(int var1) {
      if (var1 <= this.mana) {
         this.mana -= var1;
      }

   }

   public void addHP(int var1) {
      if (this.hp + var1 >= 1000) {
         this.hp = 1000;
      } else {
         this.hp += var1;
      }

   }

   public void addBossHP(int var1) {
      if (this.hp + var1 > this.bossHP) {
         this.hp = this.bossHP;
      } else {
         this.hp += var1;
      }

   }

   public void addMana(int var1) {
      if (this.mana + var1 >= 200) {
         this.mana = 200;
      } else {
         this.mana += var1;
      }

   }
}
