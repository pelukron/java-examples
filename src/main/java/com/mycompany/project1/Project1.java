/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author DMoreno4
 */
public class Project1 {

    public static void main(String args[]) throws IOException {
        int kg;
        double mt;
        double imc;
        boolean esHombre = true;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Por favor selecciona una opcion:");
        System.out.println("1. Cálculo de masa corporal (índice de masa corporal) ");
        System.out.println("2. Cálculo de masa corporal magra ");
        System.out.println("3. Cálculo de metabolismo basal (gasto energético basal) ");

        int option = Integer.parseInt(entrada.readLine());

        System.out.println("Por favor deme su peso en Kg");
        kg = Integer.parseInt(entrada.readLine());
        
        // definicion de variables repetidas
        double sexo_paciente;
        double estatura_centimetros;
        
        switch (option) {
            case 1:               
                System.out.println("Por favor deme su estura en mt");
                mt = Double.parseDouble(entrada.readLine());
                imc = kg / (mt * mt);

                if (imc < 18.9) {
                    System.out.println("Ustes tiene un peso bajo");
                } else if ((imc > 18.50) && (imc < 24.99)) {
                    System.out.println("Usted tiene un peso normal");
                } else if ((imc > 25.00) && (imc < 29.99)) {
                    System.out.println("Usted tiene sobrepeso");
                } else if ((imc > 30.00) && (imc < 34.99)) {
                    System.out.println("Usted tiene obesidad leve ");
                } else if ((imc > 35.00) && (imc < 39.99)) {
                    System.out.println("Usted tiene obesidad media ");
                } else {
                    System.out.println("Usted tiene obesidad mórbida");
                }
                break;
            case 2:
                //masa corpotal magra
                System.out.println("Es hombre el paciente, 1 si, 0 no");
                sexo_paciente = Double.parseDouble(entrada.readLine());
                esHombre = sexo_paciente == 1;
                
                System.out.println("Por favor deme su estura en cm");
                estatura_centimetros = Double.parseDouble(entrada.readLine());
                
                double masa_corporal_magra;
                double peso_cuadrado = kg * kg;
                double estatura_cuadrado = estatura_centimetros * estatura_centimetros;
                if(esHombre) {
                    masa_corporal_magra = (1.10 * kg) - 128 * (peso_cuadrado / estatura_cuadrado);
                } else {
                    masa_corporal_magra = (1.07 * kg) - 148 * (peso_cuadrado / estatura_cuadrado);
                }
                System.out.println("La masa corporal es de "+ masa_corporal_magra);
                break;
            case 3:
                //metabolismo basal
                System.out.println("Es hombre el paciente, 1 si, 0 no");
                sexo_paciente = Double.parseDouble(entrada.readLine());
                esHombre = sexo_paciente == 1;
                
                System.out.println("Por favor deme su estura en cm");
                estatura_centimetros = Double.parseDouble(entrada.readLine());
                
                System.out.println("Ingrese la edad del paciente");
                double edad = Double.parseDouble(entrada.readLine());
                
                double geb;
                
                if(esHombre) {
                    geb = 66.5 + (13.75 * kg) + (5.003 * estatura_centimetros) - (4.775 * edad);
                } else {
                    geb = 655.1 + (9.563 * kg) + (1.85 * estatura_centimetros) - (4.676 * edad);
                }
                
                System.out.println("el valor de geb es "+ geb);
                break;
            default:
            //instrucciones
                System.out.println("opcion invalida");
        }

    }
}
