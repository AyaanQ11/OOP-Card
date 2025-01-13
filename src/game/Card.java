// Source code is decompiled from a .class file using FernFlower decompiler.
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Card extends JPanel implements MouseListener {
   Color colour;
   String type;
   String effect;
   String name;
   int amount;
   int manaCost;
   double min;
   double max;
   Image cImage;
   Boolean played = false;

   Card() {
      this.type = "";
      this.effect = "";
      this.amount = 0;
      this.manaCost = 0;
      this.min = 0.0;
      this.max = 0.0;
      this.name = "";
      this.colour = new Color(255, 0, 0);
      this.setVisible(true);
      this.setPreferredSize(new Dimension(50, 80));
      this.setBackground(this.colour);
      this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      this.addMouseListener(this);
   }

   Card(int var1, String var2) {
      try {
         FileReader var3 = new FileReader(var2);
         BufferedReader var4 = new BufferedReader(var3);

         for(int var5 = 0; var5 < var1; ++var5) {
            var4.readLine();
         }

         this.name = var4.readLine();
         this.type = var4.readLine();
         this.amount = Integer.parseInt(var4.readLine());
         this.manaCost = Integer.parseInt(var4.readLine());
         this.min = Double.parseDouble(var4.readLine());
         this.max = Double.parseDouble(var4.readLine());
         this.effect = var4.readLine();
         this.cImage = (new ImageIcon(var4.readLine())).getImage();
         var4.close();
      } catch (IOException var6) {
         System.out.print("Could not read from the file");
      }

      if (this.type.equalsIgnoreCase("fire")) {
         this.colour = new Color(255, 0, 0);
      } else if (this.type.equalsIgnoreCase("sky")) {
         this.colour = new Color(163, 104, 230);
      } else if (this.type.equalsIgnoreCase("water")) {
         this.colour = new Color(90, 188, 216);
      } else {
         this.colour = new Color(204, 135, 80);
      }

      this.setVisible(true);
      this.setPreferredSize(new Dimension(50, 80));
      this.setBackground(this.colour);
      this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      this.addMouseListener(this);
   }

   public void paint(Graphics var1) {
      Graphics2D var2 = (Graphics2D)var1;
      var2.drawImage(this.cImage, 0, 0, (ImageObserver)null);
   }

   public void setPlayed(Boolean var1) {
      this.played = var1;
   }

   public Boolean getPlayed() {
      return this.played;
   }

   public String getType() {
      return this.type;
   }

   public String getEffect() {
      return this.effect;
   }

   public int getAmount() {
      return this.amount;
   }

   public int getManaCost() {
      return this.manaCost;
   }

   public double getMin() {
      return this.min;
   }

   public double getMax() {
      return this.max;
   }

   public void mousePressed(MouseEvent var1) {
   }

   public void mouseClicked(MouseEvent var1) {
      this.played = true;
   }

   public void mouseReleased(MouseEvent var1) {
   }

   public void mouseEntered(MouseEvent var1) {
      this.played = true;
   }

   public void mouseExited(MouseEvent var1) {
      this.played = false;
   }
}
