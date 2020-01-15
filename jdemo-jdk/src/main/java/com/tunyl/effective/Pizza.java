package com.tunyl.effective;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author create by Tunyl on 2019/12/17
 * @version 1.0
 */
public abstract class Pizza {
    public enum Topping{ HAM,MUSHROOM,ONION,PEPPER, SAUSAGE};
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        protected  abstract  T self();

    }
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
