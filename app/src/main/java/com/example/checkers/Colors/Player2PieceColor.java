package com.example.checkers.Colors;

import com.example.checkers.R;

public class Player2PieceColor implements PieceColor {

    @Override
    public int getPieceImageId() {
        return R.drawable.checker_red;
    }

    @Override
    public int getKingPieceImageId() {
        return R.drawable.checker_red_king;
    }
}