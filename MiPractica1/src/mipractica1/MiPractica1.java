package mipractica1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Enner
 */
public class MiPractica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int pausa = 0;
        int noRepetirA = 0, noRepetirB = 0, noRepetirC = 0, repetirA, repetirB, repetirC, Solo3, Solo2, Solo1;
        boolean p = false;
        String[][] tablero = new String[8][8];
        boolean[][] penitencias = new boolean[8][8];
        
        System.out.println("TABLERO MATEMÁTICO");
        while (p == false) {
            int numerito;
            menu();
            
            Scanner sc = new Scanner(System.in);
            numerito = sc.nextInt();
            switch (numerito) {
                case 1:
                    Solo3 = 0;
                    Solo2 = 0;
                    Solo1 = 0;
                    int contar = 64;
                    int ra,
                     rra = -1;
                    System.out.println("Comenzando juego nuevo");
                    for (int i = 0; i < tablero.length; i++) {//Solo es mi generación del tablero
                        for (int j = 0; j < tablero[i].length; j++) {
                            tablero[j][i] = "|" + contar-- + "";
                        }
                    }//Aquí termina de generarlo
                    for (int i = 0; i < penitencias.length; i++) {//Solo es mi generación de la penitencias
                        for (int j = 0; j < penitencias[i].length; j++) {
                            penitencias[j][i] = false;
                        }
                    }//Aquí termina de generar las penitencias
                    for (int i = 0; i < tablero.length; i++) {//Aquí genero los #
                        for (int j = 0; j < random(); j++) {
                            ra = rra;
                            rra = posición();
                            if (penitencias[rra][i] == false) {
                                tablero[rra][i] += "#";
                                penitencias[rra][i] = true;
                            } else {
                                j--;
                            }
                            ra = rra;
                        }
                    }
                    String precache = tablero[7][7];
                    String cache;
                    tablero[7][7] += "@";
                    for (int i = 0; i < tablero.length; i++) {//Aquí solo lo ando mostrando al usuario
                        if (i % 2 == 0) {
                            for (int j = tablero[i].length; j > 0; j--) {
                                System.out.print(tablero[j - 1][i] + "  ");
                            }
                        } else {
                            for (int j = 0; j < tablero[i].length; j++) {
                                System.out.print(tablero[j][i] + "  ");
                            }
                        }
                        System.out.println("");
                        System.out.println("----------------------------------------------------");
                    }//Aquí termino de mostrarlo
                    boolean pou = false;
                    int pasos = 0;
                    int columna = 7,
                     fila = 7,
                     alif = 7,
                     anmuloc = 7;
                    while (pou == false) {//Esto es para ejecutar el juego
                        if (fila == 0 && columna == 0) {
                            System.out.println("Felicidades, haz gando el juego");
                            System.out.println("Haz llegado a la casilla 64");
                            break;
                        }
                        System.out.println("Escoja:");
                        System.out.println("e. Tirar dado");
                        System.out.println("p. Pausar juego");
                        Scanner scc = new Scanner(System.in);
                        String escoje = scc.nextLine();
                        if ("E".equals(escoje) || "e".equals(escoje)) {
                            int dadito = dado();
                            System.out.println("Obtuvo un: " + dadito);
                            pasos += dadito;
                            if (pasos <= 7) {
                                tablero[alif][anmuloc] = precache;//deja la posición anterior como estaba antes
                                fila -= dadito;//mueve la fila
                                alif = fila;//coloca la posición anterior osea donde no está @
                                anmuloc = columna;//coloca también la columna (creo que es innesario xd)
                                cache = tablero[fila][columna];//guarda el valor de la nueva posición
                                tablero[fila][columna] += "@";//coloca el valor
                                precache = cache;
                                for (int i = 0; i < tablero.length; i++) {//Aquí solo lo ando mostrando al usuario
                                    if (i % 2 == 0) {
                                        for (int j = tablero[i].length; j > 0; j--) {
                                            System.out.print(tablero[j - 1][i] + "  ");
                                        }
                                    } else {
                                        for (int j = 0; j < tablero[i].length; j++) {
                                            System.out.print(tablero[j][i] + "  ");
                                        }
                                    }
                                    System.out.println("");
                                    System.out.println("----------------------------------------------------");
                                }//Aquí termino de mostrarlo

                                //************************************************************************************************************************
                                if (penitencias[fila][columna] == true) {
                                    System.out.println("Ha caido en una penalización");
                                    if (columna <= 1) {
                                        System.out.println("La dificultad de la penalización es AVANZADO");
                                        Solo1++;//Esa parte es para que no se repitan
                                        repetirA = randomj();
                                        if (Solo1 <= 2) {
                                            if (repetirA == noRepetirA) {
                                                repetirA++;
                                                if (repetirA == 3) {
                                                    repetirA = 1;
                                                }
                                            }
                                        } else {
                                            repetirA = 0;
                                        }//la partecita para que no se repita más de dos veces
                                        switch (repetirA) {
                                            case 1:
                                                noRepetirA = repetirA;
                                                System.out.println("División de matrices");
                                                divMatriz1();
                                                if (verificado == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }else{
                                                    System.out.println("Ha respondido correctamente la penalización!");
                                                }
                                                break;
                                            case 2:
                                                noRepetirA = repetirA;
                                                System.out.println("División de matrices");
                                                divMatriz2();
                                                if (verificado == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }else{
                                                    System.out.println("Ha respondido correctamente la penalización!");
                                                }
                                                break;
                                            case 0:
                                                System.out.println("No hay penalización, ya cayó dos veces en esta dificultad");
                                                break;
                                        }
                                    } else if (columna <= 4) {
                                        System.out.println("La dificultad de la penalización es INTERMEDIO");
                                        Solo2++;//Esa parte es para que no se repitan
                                        repetirB = randomj();
                                        if (Solo2 <= 2) {
                                            if (repetirB == noRepetirB) {
                                                repetirB++;
                                                if (repetirB == 4) {
                                                    repetirB = 1;
                                                }
                                            }
                                        } else {
                                            repetirB = 0;
                                        }//Aqui termina la parte para evitar que se repitan las penitencias
                                        switch (repetirB) {
                                            case 1:
                                                noRepetirB = repetirB;
                                                System.out.println("Suma de matrices");
                                                System.out.println("Sume las siguentes matrices y digite la matriz resultante");
                                                VerificoM = true;
                                                matriz1();
                                                if (VerificoM == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }else{
                                                    System.out.println("Ha respondido correctamente la penalización!");
                                                }
                                                break;
                                            case 2:
                                                noRepetirB = repetirB;
                                                System.out.println("Suma de matrices");
                                                System.out.println("Sume las siguentes matrices y digite la matriz resultante");
                                                VerificoM = true;
                                                matriz2();
                                                if (VerificoM == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }else{
                                                    System.out.println("Ha respondido correctamente la penalización!");
                                                }
                                                break;
                                            case 3:
                                                noRepetirB = repetirB;
                                                System.out.println("Suma de matrices");
                                                System.out.println("Sume las siguentes matrices y digite la matriz resultante");
                                                VerificoM = true;
                                                matriz3();
                                                if (VerificoM == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }else{
                                                    System.out.println("Ha respondido correctamente la penalización!");
                                                }
                                                break;
                                            case 0:
                                                System.out.println("No hay penalización, ya cayó dos veces en esta dificultad");
                                                break;
                                        }
                                    } else {
                                        System.out.println("La dificultad de la penalización es FÁCIL ");

                                        Solo3++;//Esa parte es para que no se repitan
                                        repetirC = randomj();
                                        if (Solo3 <= 2) {
                                            if (repetirC == noRepetirC) {
                                                repetirC++;
                                                if (repetirC == 4) {
                                                    repetirC = 1;
                                                }
                                            }
                                        } else {
                                            repetirC = 0;
                                        }//Aqui termina la parte para evitar que se repitan las penitencias
                                        System.out.println("Ingrese más de 5 decimales en las respuestas");
                                        switch (repetirC) {
                                            case 1:
                                                noRepetirC = repetirC;
                                                System.out.println("LEY DE COSENOS");
                                                System.out.println("Lado a=15");
                                                System.out.println("Lado c=20");
                                                System.out.println("Ángulo B=25");
                                                System.out.println("Encuentre el valor del lado b");
                                                Scanner ssc = new Scanner(System.in);
                                                float facil = ssc.nextFloat();
                                                float respuesta1 = opción1de1(15, 20, 25);//el tercero es el angulo
                                                if ((float) Math.round(facil * 1000) / 1000 != (float) Math.round(respuesta1 * 1000) / 1000) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                } else {
                                                    System.out.println("Ingrese el valor del ángulo  A");
                                                    Scanner ssc1 = new Scanner(System.in);
                                                    float facil1 = ssc1.nextFloat();
                                                    if ((float) Math.round(facil1 * 1000) / 1000 != (float) Math.round(opción2de2(15, 20, respuesta1) * 1000) / 1000) {
                                                        System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                        pou = true;
                                                    } else {
                                                        System.out.println("Ingrese el valor del ángulo  C");
                                                        Scanner ssc2 = new Scanner(System.in);
                                                        float facil2 = ssc2.nextFloat();
                                                        if ((float) Math.round(facil2 * 1000) / 1000 != (float) Math.round(opción2de2(20, 15, respuesta1) * 1000) / 1000) {
                                                            System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                            pou = true;
                                                        } else {
                                                            System.out.println("Ha respondido correctamente la penalización!");
                                                        }
                                                    }
                                                }
                                                break;
                                            case 2:
                                                noRepetirC = repetirC;
                                                System.out.println("LEY DE COSENOS");
                                                System.out.println("Lado b=10");
                                                System.out.println("Lado c=25");
                                                System.out.println("Ángulo A=30");
                                                System.out.println("Encuentre el valor del lado a");
                                                Scanner ssc2 = new Scanner(System.in);
                                                float facil2 = ssc2.nextFloat();
                                                float respuesta2 = opción1de1(10, 25, 30);
                                                if ((float) Math.round(facil2 * 1000) / 1000 != (float) Math.round(respuesta2 * 1000) / 1000) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                } else {
                                                    System.out.println("Ingrese el valor de ángulo  B");
                                                    Scanner ssc21 = new Scanner(System.in);
                                                    float facil21 = ssc21.nextFloat();
                                                    if ((float) Math.round(facil21 * 1000) / 1000 != (float) Math.round(opción2de2(25, 20, respuesta2) * 1000) / 1000) {
                                                        System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                        pou = true;
                                                    } else {
                                                        System.out.println("Ingrese el valor del ángulo C");
                                                        Scanner ssc22 = new Scanner(System.in);
                                                        float facil22 = ssc22.nextFloat();
                                                        if (((float) Math.round(facil22 * 1000) / 1000 != (float) Math.round(opción2de2(25, 10, respuesta2) * 1000) / 1000)) {
                                                            System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                            pou = true;
                                                        } else {
                                                            System.out.println("Ha respondido correctamente la penalización!");
                                                        }
                                                    }
                                                }
                                                break;
                                            case 3:
                                                noRepetirC = repetirC;
                                                System.out.println("LEY DE COSENOS");
                                                System.out.println("Lado a=18");
                                                System.out.println("Lado b=25");
                                                System.out.println("Ángulo C=30");
                                                System.out.println("Recuerde aproximar el resultado a 3 decimales");
                                                System.out.println("Encuentre el valor del lado c");
                                                Scanner ssc3 = new Scanner(System.in);
                                                float facil3 = ssc3.nextFloat();
                                                float respuesta3 = opción1de1(18, 25, 30);
                                                if ((float) Math.round(facil3 * 1000) / 1000 != (float) Math.round(respuesta3 * 1000) / 1000) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                } else {
                                                    System.out.println("Ingrese el valor del ángulo  B");
                                                    Scanner ssc31 = new Scanner(System.in);
                                                    float facil31 = ssc31.nextFloat();
                                                    if ((float) Math.round(facil31 * 1000) / 1000 != (float) Math.round(opción2de2(25, 18, respuesta3) * 1000) / 1000) {
                                                        System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                        pou = true;
                                                    } else {
                                                        System.out.println("Ingrese el valor del ángulo A");
                                                        Scanner ssc32 = new Scanner(System.in);
                                                        float facil32 = ssc32.nextFloat();
                                                        if (((float) Math.round(facil32 * 1000) / 1000 != (float) Math.round(opción2de2(18, 25, respuesta3) * 1000) / 1000)) {
                                                            System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                            pou = true;
                                                        } else {
                                                            System.out.println("Ha respondido correctamente la penalización!");
                                                        }
                                                    }
                                                }
                                                break;
                                            case 0:
                                                System.out.println("No hay penalización, ya cayó dos veces en esta dificultad");
                                        }
                                    }
                                }//***********************************************************************************************************************

                            } else if (pasos > 7) {
                                if (columna <= 0) {
                                    tablero[alif][anmuloc] = precache;
                                    tablero[0][0] += "@";
                                    for (int i = 0; i < tablero.length; i++) {//Aquí solo lo ando mostrando al usuario
                                        if (i % 2 == 0) {
                                            for (int j = tablero[i].length; j > 0; j--) {
                                                System.out.print(tablero[j - 1][i] + "  ");
                                            }
                                        } else {
                                            for (int j = 0; j < tablero[i].length; j++) {
                                                System.out.print(tablero[j][i] + "  ");
                                            }
                                        }
                                        System.out.println("");
                                        System.out.println("----------------------------------------------------");
                                    }//Aquí termino de mostrarlo
                                    System.out.println("Felicidades, haz gando el juego");
                                    System.out.println("Haz llegado a la casilla 64");
                                    break;
                                }
                                tablero[alif][anmuloc] = precache;
                                pasos -= 8;//en si es lo mismo pero resta 7 para que vuelva al anterior if
                                fila = (fila + 8);//le suma 7 a la fila para que vuelva a valer 7
                                fila -= dadito;
                                columna--;//le resta 1 para que suba una fila
                                alif = fila;
                                anmuloc = columna;
                                cache = tablero[fila][columna];
                                tablero[fila][columna] += "@";
                                precache = cache;// aquí ya todo es lo mismo
                                for (int i = 0; i < tablero.length; i++) {//Aquí solo lo ando mostrando al usuario
                                    if (i % 2 == 0) {
                                        for (int j = tablero[i].length; j > 0; j--) {
                                            System.out.print(tablero[j - 1][i] + "  ");
                                        }
                                    } else {
                                        for (int j = 0; j < tablero[i].length; j++) {
                                            System.out.print(tablero[j][i] + "  ");
                                        }
                                    }
                                    System.out.println("");
                                    System.out.println("----------------------------------------------------");
                                }//Aquí termino de mostrarlo
                                if (penitencias[fila][columna] == true) {//****************************************************************************************
                                    System.out.println("Ha caido en una penalización");
                                    if (columna <= 1) {
                                        System.out.println("La dificultad de la penalización es AVANZADO");
                                        Solo1++;//Esa parte es para que no se repitan
                                        repetirA = randomj();
                                        if (Solo1 <= 2) {
                                            if (repetirA == noRepetirA) {
                                                repetirA++;
                                                if (repetirA == 3) {
                                                    repetirA = 1;
                                                }
                                            }
                                        } else {
                                            repetirA = 0;
                                        }//la partecita para que no se repita más de dos veces
                                        switch (repetirA) {
                                            case 1:
                                                noRepetirA = repetirA;
                                                System.out.println("División de matrices");
                                                divMatriz1();
                                                if (verificado == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }
                                                break;
                                            case 2:
                                                noRepetirA = repetirA;
                                                System.out.println("División de matrices");
                                                divMatriz2();
                                                if (verificado == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }
                                                break;
                                            case 0:
                                                System.out.println("No hay penalización, ya cayó dos veces en esta dificultad");
                                                break;
                                        }
                                    } else if (columna <= 4) {
                                        System.out.println("La dificultad de la penalización es INTERMEDIO");
                                        Solo2++;//Esa parte es para que no se repitan
                                        repetirB = randomj();
                                        if (Solo2 <= 2) {
                                            if (repetirB == noRepetirB) {
                                                repetirB++;
                                                if (repetirB == 4) {
                                                    repetirB = 1;
                                                }
                                            }
                                        } else {
                                            repetirB = 0;
                                        }//Aqui termina la parte para evitar que se repitan las penitencias
                                        switch (repetirB) {
                                            case 1:
                                                noRepetirB = repetirB;
                                                System.out.println("Suma de matrices");
                                                System.out.println("Sume las siguentes matrices y digite la matriz resultante");
                                                VerificoM = true;
                                                matriz1();
                                                if (VerificoM == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }
                                                break;
                                            case 2:
                                                noRepetirB = repetirB;
                                                System.out.println("Suma de matrices");
                                                System.out.println("Sume las siguentes matrices y digite la matriz resultante");
                                                VerificoM = true;
                                                matriz2();
                                                if (VerificoM == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }
                                                break;
                                            case 3:
                                                noRepetirB = repetirB;
                                                System.out.println("Suma de matrices");
                                                System.out.println("Sume las siguentes matrices y digite la matriz resultante");
                                                VerificoM = true;
                                                matriz3();
                                                if (VerificoM == false) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                }
                                                break;
                                            case 0:
                                                System.out.println("No hay penalización, ya cayó dos veces en esta dificultad");
                                                break;
                                        }
                                    } else {
                                        System.out.println("La dificultad de la penalización es FÁCIL ");

                                        Solo3++;//Esa parte es para que no se repitan
                                        repetirC = randomj();
                                        if (Solo3 <= 2) {
                                            if (repetirC == noRepetirC) {
                                                repetirC++;
                                                if (repetirC == 4) {
                                                    repetirC = 1;
                                                }
                                            }
                                        } else {
                                            repetirC = 0;
                                        }//Aqui termina la parte para evitar que se repitan las penitencias
                                        System.out.println("Ingrese más de 5 decimales en las respuestas");
                                        switch (repetirC) {
                                            case 1:
                                                noRepetirC = repetirC;
                                                System.out.println("LEY DE COSENOS");
                                                System.out.println("Lado a=15");
                                                System.out.println("Lado c=20");
                                                System.out.println("Ángulo B=25");
                                                System.out.println("Encuentre el valor del lado b");
                                                Scanner ssc = new Scanner(System.in);
                                                float facil = ssc.nextFloat();
                                                float respuesta1 = opción1de1(15, 20, 25);//el tercero es el angulo
                                                if ((float) Math.round(facil * 1000) / 1000 != (float) Math.round(respuesta1 * 1000) / 1000) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                } else {
                                                    System.out.println("Ingrese el valor del ángulo  A");
                                                    Scanner ssc1 = new Scanner(System.in);
                                                    float facil1 = ssc1.nextFloat();
                                                    if ((float) Math.round(facil1 * 1000) / 1000 != (float) Math.round(opción2de2(15, 20, respuesta1) * 1000) / 1000) {
                                                        System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                        pou = true;
                                                    } else {
                                                        System.out.println("Ingrese el valor del ángulo  C");
                                                        Scanner ssc2 = new Scanner(System.in);
                                                        float facil2 = ssc2.nextFloat();
                                                        if ((float) Math.round(facil2 * 1000) / 1000 != (float) Math.round(opción2de2(20, 15, respuesta1) * 1000) / 1000) {
                                                            System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                            pou = true;
                                                        } else {
                                                            System.out.println("Ha respondido correctamente la penalización!");
                                                        }
                                                    }
                                                }
                                                break;
                                            case 2:
                                                noRepetirC = repetirC;
                                                System.out.println("LEY DE COSENOS");
                                                System.out.println("Lado b=10");
                                                System.out.println("Lado c=25");
                                                System.out.println("Ángulo A=30");
                                                System.out.println("Encuentre el valor del lado a");
                                                Scanner ssc2 = new Scanner(System.in);
                                                float facil2 = ssc2.nextFloat();
                                                float respuesta2 = opción1de1(10, 25, 30);
                                                if ((float) Math.round(facil2 * 1000) / 1000 != (float) Math.round(respuesta2 * 1000) / 1000) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                } else {
                                                    System.out.println("Ingrese el valor de ángulo  B");
                                                    Scanner ssc21 = new Scanner(System.in);
                                                    float facil21 = ssc21.nextFloat();
                                                    if ((float) Math.round(facil21 * 1000) / 1000 != (float) Math.round(opción2de2(10, 25, respuesta2) * 1000) / 1000) {
                                                        System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                        pou = true;
                                                    } else {
                                                        System.out.println("Ingrese el valor del ángulo C");
                                                        Scanner ssc22 = new Scanner(System.in);
                                                        float facil22 = ssc22.nextFloat();
                                                        if (((float) Math.round(facil22 * 1000) / 1000 != (float) Math.round(opción2de2(25, 10, respuesta2) * 1000) / 1000)) {
                                                            System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                            pou = true;
                                                        } else {
                                                            System.out.println("Ha respondido correctamente la penalización!");
                                                        }
                                                    }
                                                }
                                                break;
                                            case 3:
                                                noRepetirC = repetirC;
                                                System.out.println("LEY DE COSENOS");
                                                System.out.println("Lado a=18");
                                                System.out.println("Lado b=25");
                                                System.out.println("Ángulo C=30");
                                                System.out.println("Recuerde aproximar el resultado a 3 decimales");
                                                System.out.println("Encuentre el valor del lado c");
                                                Scanner ssc3 = new Scanner(System.in);
                                                float facil3 = ssc3.nextFloat();
                                                float respuesta3 = opción1de1(18, 25, 30);
                                                if ((float) Math.round(facil3 * 1000) / 1000 != (float) Math.round(respuesta3 * 1000) / 1000) {
                                                    System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                    pou = true;
                                                } else {
                                                    System.out.println("Ingrese el valor del ángulo  B");
                                                    Scanner ssc31 = new Scanner(System.in);
                                                    float facil31 = ssc31.nextFloat();
                                                    if ((float) Math.round(facil31 * 1000) / 1000 != (float) Math.round(opción2de2(18, 25, respuesta3) * 1000) / 1000) {
                                                        System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                        pou = true;
                                                    } else {
                                                        System.out.println("Ingrese el valor del ángulo A");
                                                        Scanner ssc32 = new Scanner(System.in);
                                                        float facil32 = ssc32.nextFloat();
                                                        if (((float) Math.round(facil32 * 1000) / 1000 != (float) Math.round(opción2de2(18, 25, respuesta3) * 1000) / 1000)) {
                                                            System.out.println("Respuesta incorrecta, ha perdido el juego");
                                                            pou = true;
                                                        } else {
                                                            System.out.println("Ha respondido correctamente la penalización!");
                                                        }
                                                    }
                                                }
                                                break;
                                            case 0:
                                                System.out.println("No hay penalización, ya cayó dos veces en esta dificultad");
                                        }
                                    }
                                }//***********************************************************************************************************************
                            }
                        } else if ("p".equals(escoje) || "P".equals(escoje)) {
                            pausa++;
                            System.out.println("Juego pausado");
                            break;

                        } else {
                            System.out.println("Opción invalida");
                        }
                    }//Aquí termina la ejecución del juego
                    break;
                case 2:
                    if (pausa == 0) {
                        System.out.println("Antes se debe iniciar un juego");
                    } else {
                        System.out.println("Retomando juego...");
                        

                    }
                    break;
                case 3:
                    System.out.println("CREADO POR:");
                    System.out.println("Enner Esaí Mendizabal Castro");
                    System.out.println("Carnet: 202302220");
                    System.out.println("Sección: B");
                    break;
                case 4:
                    p = true;
                    System.out.println("Gracias por jugar");
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no permitida");
            }
        }
    }

    //Aquí estan todos lo randoms
    static int dado() {
        Random random = new Random();
        int d = random.nextInt(5) + 2;
        return d;
    }

    static int random() {
        Random random = new Random();
        int rra = random.nextInt(3) + 2;
        return rra;
    }

    static int posición() {
        Random random = new Random();
        int ra = random.nextInt(7);
        return ra;
    }

    static int randomj() {
        Random random = new Random();
        int ra = random.nextInt(3) + 1;
        return ra;
    }//Aquí acaban todos los randoms ----------------------------------------------------------------------------------------------------------------

    static void menu() {//Menu y simplemente el menu xd
        System.out.println("Escoja una opción");
        System.out.println("1. Iniciar juego");
        System.out.println("2. Retomar Juego");
        System.out.println("3. Mostrar información de estudiante");
        System.out.println("4. Salir");
    }

    static float opción1de1(float n1, float n2, float a) {//Aquí comienzo con lo de los cosenos
        float m = (float) (Math.pow(n1, 2) + (float) Math.pow(n2, 2) - 2 * n1 * n2 * Math.cos(Math.toRadians(a)));
        float mm = (float) Math.sqrt(m);
        return mm;
    }

    static float opción2de2(float l, float l2, float l3) {//Aquí solo despejé el teorema de coseno
        float na = (float) (Math.acos((Math.pow(l, 2) - Math.pow(l2, 2) - Math.pow(l3, 2)) / (-2 * l2 * l3)));
        float nana = (float) (Math.toDegrees(na));
        return nana;
    }

//termino el cosito para los cosenos --------------------------------------------------------------------------------------------------------------
    //Aquí colocaré las matrices
    static int[][] matrizR = new int[5][5];
    static int[][] matrizRR = new int[5][5];
    static int[][] matrizA = {
        {7, 48, 5, 0, 1},
        {57, 8, 4, 6, 14},
        {0, 5, 6, 78, 15},
        {21, 14, 8, 19, 54},
        {32, 20, 26, 47, 12}};
    static int[][] matrizB = {
        {9, 5, 2, 1, 8},
        {4, 2, 3, 47, 8},
        {48, 55, 32, 19, 6},
        {7, 56, 32, 14, 8},
        {32, 87, 0, 1, 7}};
    static boolean VerificoM;

    static void matriz1() {
        VerificoM = true;

        System.out.println("Sume la matriz A:");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                System.out.print(matrizA[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Con la Matriz B:");
        for (int i = 0; i < matrizB.length; i++) {
            for (int j = 0; j < matrizB[i].length; j++) {
                System.out.print(matrizB[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrizRR.length; i++) {
            for (int j = 0; j < matrizRR[i].length; j++) {
                matrizRR[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        for (int i = 0; i < matrizR.length; i++) {
            System.out.println("Ingrese los valores de la fila " + (i + 1) + " (horizontal)");
            for (int j = 0; j < matrizR[i].length; j++) {
                Scanner scM = new Scanner(System.in);
                matrizR[i][j] = scM.nextInt();
            }
        }
        System.out.println("La matriz que colocó es: ");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("La respuesta correcta es: ");
        for (int i = 0; i < matrizRR.length; i++) {
            for (int j = 0; j < matrizRR[i].length; j++) {
                System.out.print(matrizRR[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR.length; j++) {
                if (matrizR[i][j] != matrizRR[i][j]) {
                    VerificoM = false;
                }
            }
        }
    }
    static int[][] matrizC = {
        {4, 9, 7, 45, 18},
        {7, 51, 26, 8, 38},
        {48, 26, 37, 21, 19},
        {1, 0, 6, 8, 1},
        {2, 19, 55, 25, 15}};
    static int[][] matrizD = {
        {0, 2, 15, 1, 66},
        {21, 48, 62, 7, 33},
        {4, 88, 0, 68, 4},
        {25, 18, 24, 7, 55},
        {24, 15, 36, 5, 98}};

    static void matriz2() {
        VerificoM = true;
        System.out.println("Sume la matriz A:");
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[i].length; j++) {
                System.out.print(matrizC[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Con la Matriz B:");

        for (int i = 0; i < matrizD.length; i++) {
            for (int j = 0; j < matrizD[i].length; j++) {
                System.out.print(matrizD[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrizRR.length; i++) {
            for (int j = 0; j < matrizRR[i].length; j++) {
                matrizRR[i][j] = matrizC[i][j] + matrizD[i][j];
            }
        }
        for (int i = 0; i < matrizR.length; i++) {
            System.out.println("Ingrese los valores de la fila " + (i + 1) + " (horizontal)");
            for (int j = 0; j < matrizR[i].length; j++) {
                Scanner scM = new Scanner(System.in);
                matrizR[i][j] = scM.nextInt();
            }
        }
        System.out.println("La matriz que colocó es: ");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("La respuesta correcta es: ");
        for (int i = 0; i < matrizRR.length; i++) {
            for (int j = 0; j < matrizRR[i].length; j++) {
                System.out.print(matrizRR[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR.length; j++) {
                if (matrizR[i][j] != matrizRR[i][j]) {
                    VerificoM = false;
                }
            }
        }
    }
    static int[][] matrizE = {
        {0, 1, 15, 5, 36},
        {1, 78, 65, 32, 4},
        {48, 66, 39, 0, 55},
        {14, 98, 63, 20, 15},
        {11, 39, 84, 7, 1}};
    static int[][] matrizF = {
        {78, 25, 66, 48, 98},
        {0, 45, 2, 3, 1},
        {2, 9, 14, 10, 20},
        {35, 87, 65, 2, 32},
        {25, 8, 4, 9, 39}};

    static void matriz3() {//Ando arreglando esto +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        VerificoM = true;
        System.out.println("Sume la matriz A:");
        for (int i = 0; i < matrizE.length; i++) {
            for (int j = 0; j < matrizE[i].length; j++) {
                System.out.print(matrizE[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Con la Matriz B:");
        for (int i = 0; i < matrizF.length; i++) {
            for (int j = 0; j < matrizF[i].length; j++) {
                System.out.print(matrizF[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrizRR.length; i++) {
            for (int j = 0; j < matrizRR[i].length; j++) {
                matrizRR[i][j] = matrizE[i][j] + matrizF[i][j];
            }
        }
        for (int i = 0; i < matrizR.length; i++) {
            System.out.println("Ingrese los valores de la fila " + (i + 1) + " (horizontal)");
            for (int j = 0; j < matrizR[i].length; j++) {
                Scanner scM = new Scanner(System.in);
                matrizR[i][j] = scM.nextInt();
            }
        }
        System.out.println("La matriz que colocó es: ");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("La respuesta correcta es: ");
        for (int i = 0; i < matrizRR.length; i++) {
            for (int j = 0; j < matrizRR[i].length; j++) {
                System.out.print(matrizRR[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR.length; j++) {
                if (matrizR[i][j] != matrizRR[i][j]) {
                    VerificoM = false;
                }
            }
        }
    }//Aquí acaban la suma de matrices --------------------------------------------------------------------------------------------------------------
    //También comienzo a trabajar con lo de la división de matrices --------------------------------------------------------------------------------
    static double dA[][] = {
        {5, 10, 1, 3},
        {9, 14, 2, 6},
        {7, 8, 15, 3},
        {6, 8, 9, 2}
    };
    static double dB[][] = {
        {5, 13, 9, 4},
        {1, 9, 6, 3},
        {8, 11, 69, 33},
        {25, 6, 7, 4}
    };
    static double dC[][] = {
        {1, 12, 9, 8},
        {7, 6, 3, 2},
        {0, 5, 6, 14},
        {6, 9, 6, 10}
    };
    static double dD[][] = {
        {8, 19, 20, 4},
        {12, 33, 6, 8},
        {4, 5, 9, 7},
        {8, 22, 14, 6}
    };
    static double determinante(double[][] matriza) {
        double determinada = 0;
        for (int j = 0; j < matriza.length; j++) {
            determinada += (double) matriza[0][j] * (double) cofactor(matriza, j, 0) * (double) Math.pow(-1, j);
        }
        return determinada;
    }
    static double cofactor(double[][] matri, int position, int position2) {
        double[][] matrix = new double[3][3];
        double cofact;
        switch (position2) {
            case 0:
                switch (position) {
                    case 0:
                        for (int i = 0; i < matri.length - 1; i++) {
                            for (int j = 0; j < matri[i].length - 1; j++) {
                                matrix[i][j] = matri[i + 1][j + 1];
                            }
                        }
                        break;
                    case 1:
                        for (int i = 0; i < matri.length - 1; i++) {
                            matrix[i][0] = matri[i + 1][0];
                            matrix[i][1] = matri[i + 1][2];
                            matrix[i][2] = matri[i + 1][3];
                        }
                        break;
                    case 2:
                        for (int i = 0; i < matri.length - 1; i++) {
                            matrix[i][0] = matri[i + 1][0];
                            matrix[i][1] = matri[i + 1][1];
                            matrix[i][2] = matri[i + 1][3];
                        }
                        break;
                    case 3:
                        for (int i = 0; i < matri.length - 1; i++) {
                            matrix[i][0] = matri[i + 1][0];
                            matrix[i][1] = matri[i + 1][1];
                            matrix[i][2] = matri[i + 1][2];
                        }
                        break;
                    default:
                        System.out.println("Este es el mensaje que me muestra");
                        break;
                }
                break;
            case 1:

                switch (position) {
                    case 0:
                        matrix[0][0] = matri[0][1];
                        matrix[0][1] = matri[0][2];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[2][1];
                        matrix[1][1] = matri[2][2];
                        matrix[1][2] = matri[2][3];
                        matrix[2][0] = matri[3][1];
                        matrix[2][1] = matri[3][2];
                        matrix[2][2] = matri[3][3];

                        break;
                    case 1:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][2];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[2][0];
                        matrix[1][1] = matri[2][2];
                        matrix[1][2] = matri[2][3];
                        matrix[2][0] = matri[3][0];
                        matrix[2][1] = matri[3][2];
                        matrix[2][2] = matri[3][3];
                        break;
                    case 2:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][1];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[2][0];
                        matrix[1][1] = matri[2][1];
                        matrix[1][2] = matri[2][3];
                        matrix[2][0] = matri[3][0];
                        matrix[2][1] = matri[3][1];
                        matrix[2][2] = matri[3][3];
                        break;
                    case 3:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][1];
                        matrix[0][2] = matri[0][2];
                        matrix[1][0] = matri[2][0];
                        matrix[1][1] = matri[2][1];
                        matrix[1][2] = matri[2][2];
                        matrix[2][0] = matri[3][0];
                        matrix[2][1] = matri[3][1];
                        matrix[2][2] = matri[3][2];
                        break;
                    default:
                        System.out.println("No creo que se posible llegar a esta parte por las restricciones que pongo pero por si acaso lo pongo xd");
                        break;
                }
                break;
            case 2:
                switch (position) {
                    case 0:
                        matrix[0][0] = matri[0][1];
                        matrix[0][1] = matri[0][2];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[1][1];
                        matrix[1][1] = matri[1][2];
                        matrix[1][2] = matri[1][3];
                        matrix[2][0] = matri[3][1];
                        matrix[2][1] = matri[3][2];
                        matrix[2][2] = matri[3][3];
                        break;
                    case 1:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][2];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[1][0];
                        matrix[1][1] = matri[1][2];
                        matrix[1][2] = matri[1][3];
                        matrix[2][0] = matri[3][0];
                        matrix[2][1] = matri[3][2];
                        matrix[2][2] = matri[3][3];
                        break;
                    case 2:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][1];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[1][0];
                        matrix[1][1] = matri[1][1];
                        matrix[1][2] = matri[1][3];
                        matrix[2][0] = matri[3][0];
                        matrix[2][1] = matri[3][1];
                        matrix[2][2] = matri[3][3];
                        break;
                    case 3:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][1];
                        matrix[0][2] = matri[0][2];
                        matrix[1][0] = matri[1][0];
                        matrix[1][1] = matri[1][1];
                        matrix[1][2] = matri[1][2];
                        matrix[2][0] = matri[3][0];
                        matrix[2][1] = matri[3][1];
                        matrix[2][2] = matri[3][2];
                        break;
                    default:
                        System.out.println("No creo que se posible llegar a esta parte por las restricciones que pongo pero por si acaso lo pongo xd");
                        break;
                }

                break;

            case 3:
                switch (position) {
                    case 0:
                        matrix[0][0] = matri[0][1];
                        matrix[0][1] = matri[0][2];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[1][1];
                        matrix[1][1] = matri[1][2];
                        matrix[1][2] = matri[1][3];
                        matrix[2][0] = matri[2][1];
                        matrix[2][1] = matri[2][2];
                        matrix[2][2] = matri[2][3];
                        break;
                    case 1:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][2];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[1][0];
                        matrix[1][1] = matri[1][2];
                        matrix[1][2] = matri[1][3];
                        matrix[2][0] = matri[2][0];
                        matrix[2][1] = matri[2][2];
                        matrix[2][2] = matri[2][3];
                        break;
                    case 2:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][1];
                        matrix[0][2] = matri[0][3];
                        matrix[1][0] = matri[1][0];
                        matrix[1][1] = matri[1][1];
                        matrix[1][2] = matri[1][3];
                        matrix[2][0] = matri[2][0];
                        matrix[2][1] = matri[2][1];
                        matrix[2][2] = matri[2][3];
                        break;
                    case 3:
                        matrix[0][0] = matri[0][0];
                        matrix[0][1] = matri[0][1];
                        matrix[0][2] = matri[0][2];
                        matrix[1][0] = matri[1][0];
                        matrix[1][1] = matri[1][1];
                        matrix[1][2] = matri[1][2];
                        matrix[2][0] = matri[2][0];
                        matrix[2][1] = matri[2][1];
                        matrix[2][2] = matri[2][2];
                        break;
                    default:
                        System.out.println("No creo que se posible llegar a esta parte por las restricciones que pongo pero por si acaso lo pongo xd");
                        break;
                }

                break;
            default:
                System.out.println("No creo que se posible llegar a esta parte por las restricciones que pongo pero por si acaso lo pongo xd");
                break;
        }
        cofact = (double) (double) matrix[0][0] * (double) matrix[1][1] * (double) matrix[2][2] + (double) matrix[0][1] * (double) matrix[1][2] * (double) matrix[2][0] + (double) matrix[0][2] * (double) matrix[1][0] * (double) matrix[2][1]
                - (double) ((double) matrix[0][2] * (double) matrix[1][1] * (double) matrix[2][0] + (double) matrix[0][1] * (double) matrix[1][0] * (double) matrix[2][2] + (double) matrix[0][0] * (double) matrix[1][2] * (double) matrix[2][1]);
        return cofact;
    }

    static double[][] adjunta(double[][] matri) {//Esto lo ando probando
        double[][] adjunto = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                adjunto[i][j] = (double) cofactor(matri, i, j) * (double) Math.pow(-1, j + i);
            }
        }
        return adjunto;
    }

    static double[][] inversa(double[][] matrizinha) {
        double[][] invertida = new double[4][4];
        double[][] adjuntada = adjunta(matrizinha);
        double determinada = determinante(matrizinha);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invertida[i][j] = (double) adjuntada[i][j] / (double) determinada;
            }
        }
        return invertida;
    }

    static double[][] rD = new double[4][4];
    static double[][] rdD = new double[4][4];
    static boolean verificado;

    static void divMatriz1() {
        verificado = true;
        double c = 0;
        double[][] laB = inversa(dB);
        System.out.println("Divida la matriz A");
        for (int i = 0; i < dA.length; i++) {
            for (int j = 0; j < dA[i].length; j++) {
                System.out.print(dA[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Por la matriz B");
        for (int i = 0; i < dB.length; i++) {
            for (int j = 0; j < dB[i].length; j++) {
                System.out.print(dB[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" ");
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    c += dA[k][j] * laB[j][i];
                }
                rdD[k][i] = ((double) Math.round((double) c * 1000)) / 1000;
                c = 0;
            }
        }
        System.out.println("Ingrese al menos 5 decimales");
        for (int i = 0; i < rD.length; i++) {
            System.out.println("Ingrese los valores de la fila " + (i + 1) + " (la horizontal)");
            for (int j = 0; j < rD[i].length; j++) {
                Scanner rdM = new Scanner(System.in);
                rD[i][j] = (double) Math.round((double) rdM.nextDouble() * 1000) / 1000;
            }
        }
        System.out.println("La matriz que colocó es: ");
        for (int i = 0; i < rD.length; i++) {
            for (int j = 0; j < rD[i].length; j++) {
                System.out.print(rD[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("La respuesta correcta es: ");
        for (int i = 0; i < rD.length; i++) {
            for (int j = 0; j < rD[i].length; j++) {
                System.out.print(rdD[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < rD.length; i++) {
            for (int j = 0; j < rD[i].length; j++) {
                if (rD[i][j] != rdD[i][j]) {
                    verificado = false;
                }
            }
        }
    }

    static void divMatriz2() {
        verificado = true;
        double c = 0;
        double[][] laB = inversa(dD);
        System.out.println("Divida la matriz C");
        for (int i = 0; i < dC.length; i++) {
            for (int j = 0; j < dC[i].length; j++) {
                System.out.print(dC[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Por la matriz D");
        for (int i = 0; i < dD.length; i++) {
            for (int j = 0; j < dD[i].length; j++) {
                System.out.print(dD[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" ");
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    c += dC[k][j] * laB[j][i];
                }
                rdD[k][i] = (double) Math.round((double) c * 1000) / 1000;
                c = 0;
            }
        }

        System.out.println("Ingrese al menos 5 decimales");
        for (int i = 0; i < rD.length; i++) {
            System.out.println("Ingrese los valores de la fila " + (i + 1) + " (la horizontal)");
            for (int j = 0; j < rD[i].length; j++) {
                Scanner rdM = new Scanner(System.in);
                rD[i][j] = (double) Math.round(rdM.nextDouble() * 1000) / 1000;
            }
        }
        System.out.println("La matriz que colocó es: ");
        for (int i = 0; i < rD.length; i++) {
            for (int j = 0; j < rD[i].length; j++) {
                System.out.print(rD[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("La respuesta correcta es: ");
        for (int i = 0; i < rD.length; i++) {
            for (int j = 0; j < rD[i].length; j++) {
                System.out.print(rdD[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < rD.length; i++) {
            for (int j = 0; j < rD[i].length; j++) {
                if (rD[i][j] != rdD[i][j]) {
                    verificado = false;
                }
            }
        }
    }
}