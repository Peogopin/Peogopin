package com.peogopin.durak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<User> userList = new ArrayList<User>();
    public static void main(String[] args) {
        addUser("Benjamin", "Lena", "Lisa", "Kevin");
        Game game = new Game(userList);
        print(game.get_trump().get_rank(), game.get_trump().get_card_type());
    }

    static void addUser(String...userNames){
        for (String username : userNames){
            userList.add(new User(username));
        }
    }

    static void print_cards(List<Card> cards){
        for(Card card : cards){
            print(card.get_rank(), card.get_card_type());
        }
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