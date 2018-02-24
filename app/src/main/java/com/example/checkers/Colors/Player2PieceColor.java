package com.example.checkers.Colors;

import com.example.checkers.R;
import java.io.Serializable;

public class Player2PieceColor implements PieceColor, Serializable{

    @Override
    public int getPieceImageId() {
        return R.drawable.checker_red;
    }

    @Override
    public int getKingPieceImageId() {
        return R.drawable.checker_red_king;
    }
}