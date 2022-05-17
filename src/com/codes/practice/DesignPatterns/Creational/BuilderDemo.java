package com.codes.practice.DesignPatterns.Creational;

import java.util.ArrayList;
import java.util.List;


//construct a complex object from simple objects using step-by-step approach
public class BuilderDemo {
    public static void main(String[] args) {
        CDBuilder cdBuilder=new CDBuilder();
        CDType cdType1=cdBuilder.buildSonyCD();
        cdType1.showItems();

        CDType cdType2=cdBuilder.buildSamsungCD();
        cdType2.showItems();
    }
}

// one interface:
interface Packing {
    public String pack();
    public int price();
}

// two abstract classes:
abstract class CD implements Packing{
    public abstract String pack();
}
abstract class Company extends CD{
    public abstract int price();
}

// Two Implementation classes from Company
class Sony extends Company{
    @Override
    public int price(){
        return 20;
    }
    @Override
    public String pack(){
        return "Sony CD";
    }
}//End of the Sony class.

class Samsung extends Company {
    @Override
    public int price(){
        return 15;
    }
    @Override
    public String pack(){
        return "Samsung CD";
    }
}//End of the Samsung class.

// A list of products with a common Packing interface
class CDType {
    private List<Packing> items=new ArrayList<Packing>();
    public void addItem(Packing packs) {
        items.add(packs);
    }
    public void getCost(){
        for (Packing packs : items) {
            packs.price();
        }
    }
    public void showItems(){
        for (Packing packing : items){
            System.out.print("CD name : "+packing.pack());
            System.out.println(", Price : "+packing.price());
        }
    }
}//End of the CDType class.

class CDBuilder {
    public CDType buildSonyCD(){
        CDType cds=new CDType();
        cds.addItem(new Sony());
        return cds;
    }
    public CDType buildSamsungCD(){
        CDType cds=new CDType();
        cds.addItem(new Samsung());
        return cds;
    }
}// End of the CDBuilder class.