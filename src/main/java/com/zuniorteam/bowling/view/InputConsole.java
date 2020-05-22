package com.zuniorteam.bowling.view;

import com.zuniorteam.bowling.core.value.FrameNumber;

import java.util.Scanner;

public class InputConsole {

    private final Scanner SCANNER = new Scanner(System.in);

    public String readUsername() {
        System.out.println("플레이어 이름은(3 english letters)?:");

        return SCANNER.nextLine();
    }

    public int readFallenPin(FrameNumber frameNumber) {
        System.out.print(frameNumber + " 프레임 투구 : ");

        final int fallenPin = SCANNER.nextInt();

        SCANNER.nextLine();

        return fallenPin;

    }
}
