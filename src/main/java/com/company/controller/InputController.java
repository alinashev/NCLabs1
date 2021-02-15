package com.company.controller;

import java.util.Scanner;

public class InputController {
    private Scanner input = new Scanner(System.in);
    /**
     * Menu option method that read an integer from user's console and returns value.
     *
     * @return input value from consile
     */
    public int menuOption(){
        return input.nextInt();
    }
}
