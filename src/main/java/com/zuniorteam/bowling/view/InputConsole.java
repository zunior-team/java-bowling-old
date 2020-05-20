package com.zuniorteam.bowling.view;

import java.util.Scanner;

public class InputConsole {

    private final Scanner SCANNER = new Scanner(System.in);

    public String readUsername() {
        System.out.println("플레이어 이름은(3 english letters)?:");

        return SCANNER.nextLine();
    }

}
