package com.resistor;

import java.util.HashMap;
import java.util.Map;

public class ResistorCode {
    // Mapa de cores para os dígitos
    private static final Map<Integer, String> colorMap = new HashMap<>();
    
    static {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }
    
    public static String getResistorColors(String input) {
        // Remover " ohms" do final da string
        String value = input.replace(" ohms", "");
        
        // Converter o valor de acordo com "k" ou "M"
        double resistorValue;
        if (value.contains("k")) {
            resistorValue = Double.parseDouble(value.replace("k", "")) * 1000;
        } else if (value.contains("M")) {
            resistorValue = Double.parseDouble(value.replace("M", "")) * 1_000_000;
        } else {
            resistorValue = Double.parseDouble(value);
        }
        
        // Obter os dois primeiros dígitos e o multiplicador
        String resistorStr = String.valueOf((int) resistorValue);
        int firstDigit = Character.getNumericValue(resistorStr.charAt(0));
        int secondDigit = Character.getNumericValue(resistorStr.charAt(1));
        int multiplier = resistorStr.length() - 2;
        
        // Montar a sequência de cores
        StringBuilder colorSequence = new StringBuilder();
        colorSequence.append(colorMap.get(firstDigit)).append(" ");
        colorSequence.append(colorMap.get(secondDigit)).append(" ");
        colorSequence.append(colorMap.get(multiplier)).append(" ");
        colorSequence.append("dourado");  // Faixa de tolerância sempre dourada
        
        return colorSequence.toString();
    }
    
    public static void main(String[] args) {
        // Testes
        System.out.println(getResistorColors("47 ohms"));      // amarelo violeta preto dourado
        System.out.println(getResistorColors("4.7k ohms"));    // amarelo violeta vermelho dourado
        System.out.println(getResistorColors("1M ohms"));      // marrom preto verde dourado
    }
}
