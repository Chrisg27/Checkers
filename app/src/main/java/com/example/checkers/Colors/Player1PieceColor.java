package com.example.checkers.Colors;

import com.example.checkers.R;

public class Player1PieceColor implements PieceColor {

    @Override
    public int getpieceImageId() {
        return R.drawable.checker_black;
    }

    @Override
    public int getKingPieceImageId() {
        return R.drawable.checker_black_king;
    }
}