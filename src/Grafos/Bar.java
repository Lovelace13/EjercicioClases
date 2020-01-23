/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author ktiusk
 */
public class Bar {  
    
    
    public int cal_co(String drink, int amount, boolean student){
        if(amount > 2 && (drink.equals("GT") || drink.equals("BACARDI_SPECIAL")))
            throw new RuntimeException("Demasiadas bebidas, max 2");
        
        beer bebida = beer.Crear(drink);
        return bebida.getPrice();
    }
}

abstract class beer {
    int price;
    abstract int getPrice();
    public static beer Crear(String tipo)
    {
        switch (tipo)// encapsulamos el switch en un metodo de factoria
        {
            case "ONE_BEER":
                return new ONE_BEER();
            case "ONE_CIDER":
                return new ONE_CIDER();
            case "A_PROPER_CIDER":
                return new A_PROPER_CIDER();
            case "GT":
                return new GT();    
            case "BACARDI":
                return new BACARDI(); 
            default:
                return null;
        }
    }
}

class ONE_BEER extends beer {
    @Override
    int getPrice() {
        return price;
    }
}

class ONE_CIDER extends beer {
    @Override
    int getPrice() {
        return price;
    }
}

class A_PROPER_CIDER extends beer {
    @Override
    int getPrice() {
        return price;
    }
}

class GT extends beer {
    @Override
    int getPrice() {
        return price;
    }
}

class BACARDI extends beer {
    @Override
    int getPrice() {
        return price;
    }
}


