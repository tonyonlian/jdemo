package com.tunyl.effective;

import static com.tunyl.effective.NyPizza.Size.SMALL;
import static com.tunyl.effective.Pizza.Topping.*;

/**
 * @author create by Tunyl on 2019/12/17
 * @version 1.0
 */
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();



    }
}
