// Source code is decompiled from a .class file using FernFlower decompiler.
package game;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Battle extends JPanel implements MouseListener {
   JPanel layout = new JPanel();
   JPanel layoutCards = new JPanel();
   JLabel bIcon;
   JLabel stats = new JLabel();
   JButton endTurn = new JButton();
   JProgressBar hpBar;
   JProgressBar manaBar;
   Player p1 = new Player();
   Player boss = new Player();
   DamageCalc p1Calc = new DamageCalc();
   DamageCalc bossCalc = new DamageCalc();
   ArrayList<Card> hand = new ArrayList();
   ArrayList<Card> bHand = new ArrayList();
   Image bImage;
   String p1Deck;
   String bossE;
   int bossHp;
   int count;
   int chat;
   Npc npc1 = new Npc("Ayaan", 0);
   Npc npc2 = new Npc("Marina", 0);
   Npc npc3 = new Npc("Mercury", 0);

   public Battle() {
      this.hpBar = new JProgressBar(0, this.p1.getHp());
      this.manaBar = new JProgressBar(0, this.p1.getMana());
      this.p1Deck = "sky";
      this.endTurn.setBounds(400, 330, 80, 40);
      this.endTurn.addActionListener((var1x) -> {
         this.bossTurn();
      });
      this.stats.setBounds(0, 250, 500, 50);
      this.add(this.stats);
      this.hpBar.setPreferredSize(new Dimension(400, 20));
      this.hpBar.setValue(this.p1.getHp());
      this.hpBar.setStringPainted(true);
      JProgressBar var10000 = this.hpBar;
      int var10001 = this.hpBar.getValue();
      var10000.setString("" + var10001 + "/" + this.hpBar.getMaximum());
      this.hpBar.setForeground(new Color(255, 0, 0));
      this.manaBar.setPreferredSize(new Dimension(290, 20));
      this.manaBar.setValue(this.p1.getMana());
      var10000 = this.manaBar;
      var10001 = this.manaBar.getValue();
      var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());
      this.manaBar.setStringPainted(true);
      this.manaBar.setForeground(new Color(135, 206, 255));
      this.layout.setBackground(new Color(20, 20, 50));
      this.layout.setBounds(5, 5, 490, 60);
      this.layout.setLayout(new FlowLayout());
      this.layout.setVisible(true);
      this.layout.add(this.hpBar);
      this.layout.add(this.manaBar);
      this.layoutCards.setBackground(new Color(20, 20, 50));
      this.layoutCards.setBounds(0, 290, 500, 100);
      this.layoutCards.setLayout(new FlowLayout());
      this.layoutCards.setVisible(true);
      this.setBounds(0, 0, 500, 500);
      this.setBackground(new Color(0, 182, 213));
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      this.add(this.layout);
      this.add(this.stats);
      this.add(this.layoutCards);
      this.add(this.endTurn);
      this.battleStart();
   }

   public Battle(String var1, String var2, int var3, int var4, String var5) {
      this.bImage = (new ImageIcon(var5)).getImage();
      this.hpBar = new JProgressBar(0, this.p1.getHp());
      this.manaBar = new JProgressBar(0, this.p1.getMana());
      this.p1Deck = var1;
      this.bossE = var2;
      this.boss.setBossHP(var3);
      this.bossHp = var3;
      this.count = var4;
      this.endTurn.setBounds(400, 330, 80, 40);
      this.endTurn.addActionListener((var1x) -> {
         this.bossTurn();
      });
      this.stats.setBounds(0, 250, 500, 50);
      this.add(this.stats);
      this.hpBar.setPreferredSize(new Dimension(400, 20));
      this.hpBar.setValue(this.p1.getHp());
      this.hpBar.setStringPainted(true);
      JProgressBar var10000 = this.hpBar;
      int var10001 = this.hpBar.getValue();
      var10000.setString("Player HP: " + var10001 + "/" + this.hpBar.getMaximum());
      this.hpBar.setForeground(new Color(255, 0, 0));
      this.manaBar.setPreferredSize(new Dimension(290, 20));
      this.manaBar.setValue(this.p1.getMana());
      var10000 = this.manaBar;
      var10001 = this.manaBar.getValue();
      var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());
      this.manaBar.setStringPainted(true);
      this.manaBar.setForeground(new Color(135, 206, 255));
      this.layout.setBackground(new Color(20, 20, 50));
      this.layout.setBounds(5, 5, 490, 60);
      this.layout.setLayout(new FlowLayout());
      this.layout.setVisible(true);
      this.layout.add(this.hpBar);
      this.layout.add(this.manaBar);
      this.layoutCards.setBackground(new Color(20, 20, 50));
      this.layoutCards.setBounds(0, 290, 500, 100);
      this.layoutCards.setLayout(new FlowLayout());
      this.layoutCards.setVisible(true);
      this.setBounds(0, 0, 500, 500);
      this.setBackground(new Color(0, 182, 213));
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      this.setOpaque(false);
      this.battleStart();
   }

   public void paint(Graphics var1) {
      Graphics2D var2 = (Graphics2D)var1;
      var2.drawImage(this.bImage, 0, 0, (ImageObserver)null);
      this.add(this.layout);
      this.add(this.stats);
      this.add(this.layoutCards);
      this.add(this.endTurn);
   }

   public void createHand() {
      int var1;
      for(var1 = 0; var1 < 5; ++var1) {
         this.hand.add(new Card((int)(22.0 * Math.random()) * 8, this.p1Deck + ".txt"));
         ((Card)this.hand.get(var1)).addMouseListener(this);
         this.layoutCards.add((Component)this.hand.get(var1));
      }

      for(var1 = 0; var1 < 5; ++var1) {
         this.bHand.add(new Card((int)(22.0 * Math.random()) * 8, this.bossE + ".txt"));
      }

   }

   public void fillHand() {
      int var1;
      for(var1 = this.hand.size(); var1 < 5; ++var1) {
         this.hand.add(new Card((int)(22.0 * Math.random()) * 8, this.p1Deck + ".txt"));
         ((Card)this.hand.get(var1)).addMouseListener(this);
         this.layoutCards.add((Component)this.hand.get(var1));
      }

      for(var1 = this.bHand.size(); var1 < 5; ++var1) {
         this.bHand.add(new Card((int)(25.0 * Math.random()) * 8, this.bossE + ".txt"));
      }

   }

   public void battleStart() {
      this.hand.clear();
      this.bHand.clear();
      this.hand = new ArrayList();
      this.bHand = new ArrayList();
      this.createHand();
   }

   public void mousePressed(MouseEvent var1) {
   }

   public void mouseClicked(MouseEvent var1) {
      for(int var2 = 0; var2 < this.hand.size(); ++var2) {
         if (((Card)this.hand.get(var2)).getPlayed() && this.manaBar.getValue() - ((Card)this.hand.get(var2)).getManaCost() >= 0 && this.boss.getHp() > 0 && this.hand.size() > 1) {
            ((Card)this.hand.get(var2)).setVisible(false);
            if (((Card)this.hand.get(var2)).getEffect().equalsIgnoreCase("Attack")) {
               this.p1Calc.setDamage(((Card)this.hand.get(var2)).getAmount());
               this.p1Calc.setElementP(((Card)this.hand.get(var2)).getType());
               this.p1Calc.setElementB(this.bossE);
               this.p1Calc.dmgMultiCalc();
               this.p1Calc.dmgCalc();
               this.boss.subtractHp(this.p1Calc.getDamage());
            } else if (((Card)this.hand.get(var2)).getEffect().equalsIgnoreCase("Heal")) {
               this.p1.addHP(((Card)this.hand.get(var2)).getAmount());
            } else if (((Card)this.hand.get(var2)).getEffect().equalsIgnoreCase("multi")) {
               this.p1Calc.setDmgMulti(this.p1Calc.getRandMulti(((Card)this.hand.get(var2)).getMin(), ((Card)this.hand.get(var2)).getMax()));
            } else if (((Card)this.hand.get(var2)).getEffect().equalsIgnoreCase("reduc")) {
               this.bossCalc.setDmgReduc(((Card)this.hand.get(var2)).getMin());
            } else {
               this.manaBar.setValue(this.manaBar.getValue() + ((Card)this.hand.get(var2)).getAmount());
               this.p1.addMana(((Card)this.hand.get(var2)).getAmount());
            }

            this.manaBar.setValue(this.manaBar.getValue() - ((Card)this.hand.get(var2)).getManaCost());
            JProgressBar var10000 = this.manaBar;
            int var10001 = this.manaBar.getValue();
            var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());
            this.hpBar.setValue(this.p1.getHp());
            this.hpBar.setStringPainted(true);
            var10000 = this.hpBar;
            var10001 = this.hpBar.getValue();
            var10000.setString("Player HP: " + var10001 + "/" + this.hpBar.getMaximum());
            this.hand.remove(var2);
         }

         System.out.print(this.boss.getHp());
         this.BattleOver();
      }

   }

   public void mouseReleased(MouseEvent var1) {
   }

   public void mouseEntered(MouseEvent var1) {
      Iterator var2 = this.hand.iterator();

      while(true) {
         while(true) {
            Card var3;
            do {
               if (!var2.hasNext()) {
                  return;
               }

               var3 = (Card)var2.next();
            } while(!var3.getPlayed());

            this.stats.setVisible(true);
            JLabel var10000;
            String var10001;
            if (var3.getEffect().equalsIgnoreCase("multi") && !var3.getEffect().equalsIgnoreCase("reduc")) {
               var10000 = this.stats;
               var10001 = var3.getEffect();
               var10000.setText("Effect: " + var10001 + ";" + var3.getEffect() + " Amount: " + var3.getMin() + "x - " + var3.getMax() + "x Dmg; Mana Cost: " + var3.getManaCost());
            } else {
               var10000 = this.stats;
               var10001 = var3.getEffect();
               var10000.setText("Effect: " + var10001 + ";" + var3.getEffect() + " Amount: " + var3.getAmount() + "; Mana Cost: " + var3.getManaCost());
            }
         }
      }
   }

   public void mouseExited(MouseEvent var1) {
      this.stats.setVisible(false);
   }

   public void bossTurn() {
      this.p1.addMana(100);
      this.manaBar.setValue(this.manaBar.getValue() + 100);
      JProgressBar var10000 = this.manaBar;
      int var10001 = this.manaBar.getValue();
      var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());

      for(int var1 = 0; var1 < this.bHand.size(); ++var1) {
         if (this.boss.getMana() - ((Card)this.bHand.get(var1)).getManaCost() >= 0 && this.p1.getHp() > 0) {
            if (((Card)this.bHand.get(var1)).getEffect().equalsIgnoreCase("Attack")) {
               this.bossCalc.setDamage(((Card)this.bHand.get(var1)).getAmount());
               this.bossCalc.setElementP(((Card)this.bHand.get(var1)).getType());
               this.bossCalc.setElementB(this.p1Deck);
               this.bossCalc.dmgMultiCalc();
               this.bossCalc.dmgCalc();
               this.p1.subtractHp(this.bossCalc.getDamage());
            } else if (((Card)this.bHand.get(var1)).getEffect().equalsIgnoreCase("Heal")) {
               this.boss.addHP(((Card)this.bHand.get(var1)).getAmount());
            } else if (((Card)this.bHand.get(var1)).getEffect().equalsIgnoreCase("multi")) {
               this.bossCalc.setDmgMulti(this.bossCalc.getRandMulti(((Card)this.bHand.get(var1)).getMin(), ((Card)this.bHand.get(var1)).getMax()));
            } else if (((Card)this.bHand.get(var1)).getEffect().equalsIgnoreCase("reduc")) {
               this.p1Calc.setDmgReduc(((Card)this.bHand.get(var1)).getMin());
            } else {
               this.boss.addMana(((Card)this.bHand.get(var1)).getAmount());
            }

            this.boss.setMana(this.boss.getMana() - ((Card)this.bHand.get(var1)).getManaCost());
            this.bHand.remove(var1);
         }

         this.BattleOver();
      }

      this.hpBar.setValue(this.p1.getHp());
      this.hpBar.setStringPainted(true);
      var10000 = this.hpBar;
      var10001 = this.hpBar.getValue();
      var10000.setString("Player HP: " + var10001 + "/" + this.hpBar.getMaximum());
      this.boss.addMana(100);
      this.fillHand();
   }

   public void BattleOver() {
      Scanner var1 = new Scanner(System.in);
      if (this.boss.getDeath()) {
         ++this.count;
         JProgressBar var10000;
         int var10001;
         Iterator var3;
         Card var4;
         if (this.count == 1) {
            getDialogue(6);

            do {
               do {
                  System.out.print("1. Thanks for teaching me about magic\n2. Yeah right, you're get bitter\n3. Well okay then...\n(How do you respond?): ");
                  this.chat = var1.nextInt();
               } while(this.chat < 1);
            } while(this.chat > 3);

            if (this.chat == 1) {
               getDialogue(7);
               this.npc1.addFp();
            } else if (this.chat == 2) {
               getDialogue(8);
               this.npc1.minusFp();
            } else {
               getDialogue(9);
            }

            System.out.println("\n\n");
            getDialogue(12);
            getDialogue(13);
            getDialogue(14);
            this.p1 = new Player();
            this.p1Calc = new DamageCalc();
            this.boss = new Player();
            this.bossCalc = new DamageCalc();
            new Battle(this.p1Deck, "water", 700, this.count, "characters/marina.png");
            this.bossHp = 700;
            this.boss.setBossHP(this.bossHp);
            this.hpBar.setValue(this.p1.getHp());
            this.hpBar.setStringPainted(true);
            var10000 = this.hpBar;
            var10001 = this.hpBar.getValue();
            var10000.setString("Player HP: " + var10001 + "/" + this.hpBar.getMaximum());
            this.manaBar.setValue(this.p1.getMana());
            var10000 = this.manaBar;
            var10001 = this.manaBar.getValue();
            var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());
            this.manaBar.setStringPainted(true);
            var3 = this.hand.iterator();

            while(var3.hasNext()) {
               var4 = (Card)var3.next();
               var4.setVisible(false);
            }

            this.battleStart();
         } else if (this.count == 2) {
            getDialogue(16);

            do {
               do {
                  System.out.print("1. Well it was fun battling at least!\n2. I could\u2019ve just\u2026 kept walking?!\n3. Why would you waste my time you lake lizard\n(How do you respond?): ");
                  this.chat = var1.nextInt();
               } while(this.chat < 1);
            } while(this.chat > 3);

            if (this.chat == 1) {
               getDialogue(17);
               this.npc2.addFp();
            } else if (this.chat == 2) {
               getDialogue(18);
            } else {
               getDialogue(19);
               this.npc2.minusFp();
            }

            if (this.npc1.getFp() + this.npc2.getFp() < 0) {
               getDialogue(22);
            } else {
               getDialogue(23);
               System.out.println("\n");
               getDialogue(24);
            }

            this.p1 = new Player();
            this.p1Calc = new DamageCalc();
            this.boss = new Player();
            this.bossCalc = new DamageCalc();
            new Battle(this.p1Deck, "sky", 800, this.count, "characters/mercury.png");
            this.bossHp = 800;
            this.boss.setBossHP(this.bossHp);
            this.hpBar.setValue(this.p1.getHp());
            this.hpBar.setStringPainted(true);
            var10000 = this.hpBar;
            var10001 = this.hpBar.getValue();
            var10000.setString("Player HP: " + var10001 + "/" + this.hpBar.getMaximum());
            this.manaBar.setValue(this.p1.getMana());
            var10000 = this.manaBar;
            var10001 = this.manaBar.getValue();
            var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());
            this.manaBar.setStringPainted(true);
            var3 = this.hand.iterator();

            while(var3.hasNext()) {
               var4 = (Card)var3.next();
               var4.setVisible(false);
            }

            this.battleStart();
            System.out.println("BATTTTTTTLEEEEEEE 222222");
         } else if (this.count == 3) {
            getDialogue(26);

            do {
               do {
                  System.out.print("1. Hah, you put up quite the fight yourself!\n2. Like I care about a fight like this. Only that final battle matters\n(How do you respond?): ");
                  this.chat = var1.nextInt();
               } while(this.chat < 1);
            } while(this.chat > 2);

            if (this.chat == 2) {
               getDialogue(27);
               this.npc3.addFp();
            } else {
               getDialogue(28);
               this.npc3.minusFp();
            }

            System.out.println("\n\n");
            getDialogue(31);
            this.p1 = new Player();
            this.p1Calc = new DamageCalc();
            this.boss = new Player();
            this.bossCalc = new DamageCalc();
            new Battle(this.p1Deck, "fire", 900, this.count, "characters/evilayaan.png");
            this.bossHp = 900;
            this.boss.setBossHP(this.bossHp);
            this.hpBar.setValue(this.p1.getHp());
            this.hpBar.setStringPainted(true);
            var10000 = this.hpBar;
            var10001 = this.hpBar.getValue();
            var10000.setString("Player HP: " + var10001 + "/" + this.hpBar.getMaximum());
            this.manaBar.setValue(this.p1.getMana());
            var10000 = this.manaBar;
            var10001 = this.manaBar.getValue();
            var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());
            this.manaBar.setStringPainted(true);
            var3 = this.hand.iterator();

            while(var3.hasNext()) {
               var4 = (Card)var3.next();
               var4.setVisible(false);
            }

            this.battleStart();
            System.out.println("BATTTTTTTLEEEEEEE 333333");
         } else if (this.count == 4) {
            getDialogue(33);

            do {
               do {
                  System.out.print("1. (hand Ayaan a small mana potion before continuing)\n2. (go into the castle without another word)\n3. (repay Ayaan for his betrayal)\n(How do you respond?): ");
                  this.chat = var1.nextInt();
               } while(this.chat < 1);
            } while(this.chat > 3);

            if (this.chat == 1) {
               getDialogue(34);
               this.npc2.addFp();
            } else if (this.chat == 2) {
               getDialogue(35);
            } else {
               getDialogue(36);
               this.npc2.minusFp();
            }

            System.out.println("\n\n");
            getDialogue(39);
            this.p1 = new Player();
            this.p1Calc = new DamageCalc();
            this.boss = new Player();
            this.bossCalc = new DamageCalc();
            new Battle(this.p1Deck, "water", 1000, this.count, "characters/queenbaker.png");
            this.bossHp = 1000;
            this.boss.setBossHP(this.bossHp);
            this.hpBar.setValue(this.p1.getHp());
            var10000 = this.hpBar;
            var10001 = this.hpBar.getValue();
            var10000.setString("Player HP: " + var10001 + "/" + this.hpBar.getMaximum());
            this.manaBar.setValue(this.p1.getMana());
            var10000 = this.manaBar;
            var10001 = this.manaBar.getValue();
            var10000.setString("" + var10001 + "/" + this.manaBar.getMaximum());
            this.manaBar.setStringPainted(true);
            var3 = this.hand.iterator();

            while(var3.hasNext()) {
               var4 = (Card)var3.next();
               var4.setVisible(false);
            }

            this.battleStart();
         }
      } else if (this.p1.getDeath()) {
         System.out.println(" .------..------..------..------.     .------..------..------..------.");
         System.out.println(" |G.--. ||A.--. ||M.--. ||E.--. |.-.  |O.--. ||V.--. ||E.--. ||R.--. |");
         System.out.println(" | :/\\: || (\\/) || (\\/) || (\\/) ((5)) | :/\\: || :(): || (\\/) || :(): |");
         System.out.println(" | :\\/: || :\\/: || :\\/: || :\\/: |'-.-.| :\\/: || ()() || :\\/: || ()() |");
         System.out.println(" | '--'G|| '--'A|| '--'M|| '--'E| ((1)) '--'O|| '--'V|| '--'E|| '--'R|");
         System.out.println(" `------'`------'`------'`------'  '-'`------'`------'`------'`------'");
         System.exit(0);
      }

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
