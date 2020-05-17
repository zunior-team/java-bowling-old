package view;

import static domain.Player.NAME_LENGTH;

public class OutputView {


    public void printInputPlayerNameMessage() {
        System.out.println("플레이어 이름은(" + NAME_LENGTH + " english letters)?: ");
    }

    public void printInputFallenPinsMessageOf(int nextFrame) {
        System.out.println(nextFrame + " 프레임 투구 : ");
    }
}
