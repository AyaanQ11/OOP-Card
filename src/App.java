// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import game.Battle;

class Main {
   Main() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      String var3 = "";
      boolean var4 = false;
      JFrame var5 = new JFrame();

      do {
         System.out.println("Please choose a deck: \n[sky]\t[earth]\t\t[fire]\t[water]");
         var3 = var1.next();
      } while(!var3.equals("sky") && !var3.equals("earth") && !var3.equals("fire") && !var3.equals("water"));

      var3 = var3.toLowerCase();
      Battle var6 = new Battle(var3, "earth", 600, 0, "characters/ayaan.png");
      var5.setDefaultCloseOperation(3);
      var5.setLayout((LayoutManager)null);
      var5.setSize(500, 400);
      var5.setVisible(true);
      var5.add(var6);
      getDialogue(1);
      getDialogue(2);

      try {
         Thread.sleep(10000L);
      } catch (InterruptedException var8) {
         System.out.println("Error");
      }

      getDialogue(3);
   }

   public static void getDialogue(int var0) {
      String var1 = "";

      try {
         FileReader var2 = new FileReader("dialogue.txt");
         BufferedReader var3 = new BufferedReader(var2);

         for(int var4 = 0; var4 < var0; ++var4) {
            var1 = var3.readLine();
         }

         System.out.println(var1);
         var3.close();
      } catch (IOException var5) {
         System.out.println("Error gathering dialogue");
      }

   }
}
