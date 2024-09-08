package com.Snail;

import java.util.ArrayList;
import java.util.List;

public class SnailMatrix {
    public static List<Integer> snail(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) {
            return result;  // Retorna uma lista vazia se a matriz estiver vazia
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Percorre a linha superior da esquerda para a direita
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;  // Move a borda superior para baixo

            // Percorre a coluna da direita de cima para baixo
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;  // Move a borda direita para a esquerda

            if (top <= bottom) {
                // Percorre a linha inferior da direita para a esquerda
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;  // Move a borda inferior para cima
            }

            if (left <= right) {
                // Percorre a coluna da esquerda de baixo para cima
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;  // Move a borda esquerda para a direita
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(snail(matrix));  // Saída: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}

