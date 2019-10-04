/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai8_GarageManagement;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGOC TY
 */
public class Garage {
    ArrayList<Card> cardList=new ArrayList<>();
    
    public void addCard(){
        Card c=new Card();
        c.checkIn();
        cardList.add(c);
    }
    public void readFile() throws IOException{
        Scanner scan=new Scanner(Paths.get("D:\\NetBean\\Java\\JavaApplication6\\src\\Bai8_GarageManagement\\Card.txt"), "UTF-8");
        while(scan.hasNextLine()){
            Card c=new Card();
            scan.nextInt();
            c.setCardType(scan.nextInt());
            String s=scan.nextLine().trim();
            StringTokenizer token= new StringTokenizer(s,",");
            c.licensePlate=token.nextToken();
            c.setCheckInDay(Integer.parseInt(token.nextToken()));
            c.setCheckInMonth(Integer.parseInt(token.nextToken()));
            c.setCheckInHour(Integer.parseInt(token.nextToken()));
            cardList.add(c);
        }
    }
    public void writeFile() throws UnsupportedEncodingException, IOException{
        FileOutputStream fos;
        int count=1;
        try {
            fos = new FileOutputStream("D:\\NetBean\\Java\\JavaApplication6\\src\\Bai8_GarageManagement\\Card.txt");
            OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            for(Card c:cardList){
                bw.write(count+" ");
                bw.write(c.getCardType()+" ");
                bw.write(c.licensePlate+",");
                bw.write(c.getCheckInDay()+",");
                bw.write(c.getCheckInMonth()+",");
                bw.write(c.getCheckInHour()+"\n");
                count++;
            }
            bw.close();
            osw.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Garage.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public void output(){
        for(Card c: cardList){
            System.out.println(c.getCardType()+"\t"+c.licensePlate+"\t"+c.getCheckInDay()+"/ "+c.getCheckInMonth()+", "+c.getCheckInHour());
        }
    }
    
}
