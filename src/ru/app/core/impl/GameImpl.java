package ru.app.core.impl;

import ru.app.core.Game;
import ru.app.core.Player;

public class GameImpl implements Game {
    private static int MAXIMUM_GAME_POINT = 11;
    private static int playerOneGamePoint;
    private static int playerTwoGamePoint;


    @Override
    public void run(PingPongTableImpl pingPongTable, Player playerOne, Player playerTwo) {
        while (playerOneGamePoint < 11 && playerTwoGamePoint < 11) {
           TablePoint oneHit = playerOne.hit();
           if (pingPongTable.getPlayerTwoTablePoints().contains(oneHit)) {
               System.out.println(oneHit);
               System.out.println("Первый игрок попал!");
           } else {
               System.out.println(oneHit);
               System.out.println("Первый игрок промазал!");
               playerTwoGamePoint++;
               System.out.println("Второму игроку присуждается очко! Общий счет: " + playerOneGamePoint + " : " + playerTwoGamePoint);

           }
           if(playerTwoGamePoint == 11)
               break;

            TablePoint twoHit = playerTwo.hit();
            if (pingPongTable.getPlayerOneTablePoints().contains(twoHit)) {
                System.out.println(twoHit);
                System.out.println("Второй игрок попал!");
            } else {
                System.out.println(twoHit);
                System.out.println("Второй игрок промазал!");
                playerOneGamePoint++;
                System.out.println("Первому игроку присуждается очко! Общий счет: " + playerOneGamePoint + " : " + playerTwoGamePoint);
            }
            if(playerOneGamePoint == 11)
                break;
        }

        if(playerOneGamePoint == 11)
            System.out.println("Первый игрок победил!");
        if(playerTwoGamePoint == 11)
            System.out.println("Второй игрок победил!");

        //TODO напиши здесь реализацию игры в пинг-понг двух игроков, используя их имплементации
        // алгоритм реализации:
        // При каждом ударе игрока производится проверка, попал ли игрок по столу соперника или нет.
        // Факт удара фиксируется в console (попал или не попал и по какой точке был совершен удар).
        // В случае, если игрок не попадает по столу соперника, очко присуждается его оппонента (общий счет выводится в консоль).
        // Очко разыгрывается до тех пор, пока один из игроков не промахнется по столу соперника.
        // Очки суммируются и тот, кто наберет первым 11 очков, будет победителем.
    }
}
