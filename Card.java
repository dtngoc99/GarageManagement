/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai8_GarageManagement;

import java.util.Scanner;

/**
 *
 * @author NGOC TY
 */
public class Card extends Motobike{
    private int cardType;//loại 2 xe ga,loại 1 xe số
    private int checkInHour;
    private int checkOutHour;
    private int checkInDay;
    private int checkInMonth;
    private int checkOutDay;
    private int checkOutMonth;
    final int priceDay1=3000;
    final int priceNight1=6000;
    final int priceDay2=4000;
    final int priceNight2=7000;
    public int getCardType() {
        return cardType;
    }

    public int getCheckInDay() {
        return checkInDay;
    }

    public int getCheckInMonth() {
        return checkInMonth;
    }

    public int getCheckOutDay() {
        return checkOutDay;
    }

    public int getCheckInHour() {
        return checkInHour;
    }

    public int getCheckOutHour() {
        return checkOutHour;
    }



    public int getCheckOutMonth() {
        return checkOutMonth;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public void setCheckInDay(int checkInDay) {
        this.checkInDay = checkInDay;
    }

    public void setCheckInMonth(int checkInMonth) {
        this.checkInMonth = checkInMonth;
    }

    public void setCheckOutDay(int checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public void setCheckOutMonth(int checkOutMonth) {
        this.checkOutMonth = checkOutMonth;
    }
    public void setCheckInHour(int checkInHour) {
        this.checkInHour = checkInHour;
    }

    public void setCheckOutHour(int checkOutHour) {
        this.checkOutHour = checkOutHour;
    }
    public float Money(){
        int totalMoney;
        if(cardType==1){//xe số
            if(checkOutDay-checkInDay>0&& checkOutMonth==checkInMonth){
                totalMoney=(checkOutDay-checkInDay)*(priceDay1+priceNight1);
                if(checkInHour>=18) totalMoney+=priceDay1;
                if(checkOutHour<=7) totalMoney-=priceDay1;
                return totalMoney;
            }
            else return priceDay1;
        }
        else{//xe ga
            if(checkOutDay-checkInDay>0&& checkOutMonth==checkInMonth){
                totalMoney=(checkOutDay-checkInDay)*(priceDay2+priceNight2);
                if(checkInHour>=18) totalMoney+=priceDay2;
                if(checkOutHour<=7) totalMoney-=priceDay2;
                return totalMoney;
            }
            else return priceDay2;
        }
       
    }
    public void checkIn(){
        Scanner scan=new Scanner(System.in);
        System.out.println("CheckInDay: ");
        checkInDay=scan.nextInt();
        System.out.println("CheckInMonth: ");
        checkInMonth=scan.nextInt();
        System.out.println("CheckInHour: ");
        checkInHour=scan.nextInt();
        System.out.println("CardType: ");
        cardType=scan.nextInt();
        System.out.println("LicensePlate: ");
        scan.nextLine();
        licensePlate=scan.nextLine();
    }
    public void checkOut(){
        Scanner scan=new Scanner(System.in);
        System.out.println("LicensePlate: ");
        this.licensePlate=scan.nextLine();
        System.out.println("CheckOutDay: ");
        checkOutDay=scan.nextInt();
        System.out.println("CheckOutMonth: ");
        checkOutMonth=scan.nextInt();
        System.out.println("CheckOutHour: ");
        checkOutHour=scan.nextInt();
    }

}
