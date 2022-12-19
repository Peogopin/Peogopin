package com.peogopin;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        World world = new World();
    }

    static void print(String...value){
        String val = Arrays.toString(value)
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(",", " ");
        String var = String.join(" | ", val);
        System.out.println(var);
    }

}