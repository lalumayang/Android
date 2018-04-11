package com.paperscissorsstonegame;

import android.view.View;

/**
 * Created by laluma on 2018/4/11.
 */

public class ComputerHandle {

    public static int getComputerChoice() {
        return (int) (Math.random()*3 + 1);
    }

    public static int getResult(int playerChoice, int computerChoice) {
        int result = 0;
        if(playerChoice == 1){
            if(computerChoice == 1){
                result = 3;
            }
            else if(computerChoice == 2){
                result = 2;
            }
            else if(computerChoice == 3){
                result = 1;
            }
        }
        else if(playerChoice == 2){
            if(computerChoice == 1){
                result = 1;
            }
            else if(computerChoice == 2){
                result = 3;
            }
            else if(computerChoice == 3){
                result = 2;
            }
        }
        else if(playerChoice == 3){
            if(computerChoice == 1){
                result = 2;
            }
            else if(computerChoice == 2){
                result = 1;
            }
            else if(computerChoice == 3){
                result = 3;
            }
        }
        return result;
    }

}
