package com.company.controller;

import java.util.Scanner;

public class InputController {
    private Scanner input = new Scanner(System.in);
    public int menuOption(){
        return input.nextInt();
    }
}
