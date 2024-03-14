import java.util.Random;
public class Tablica {
    int[][] tablica = new int[20][20];
    public Tablica(int iloscbomb){
        Random rand = new Random();//f

        // zerowanie tablicy
        for (int s = 0; s < 20; s++) {
            for (int k = 0; k < 20; k++) {
                tablica[s][k] = 0;
            }
        }
        // losowe bomby
        int sumabomb = 0;
        int t, k;

        while (sumabomb < iloscbomb) {
            t = rand.nextInt(20);
            k = rand.nextInt(20);
            if (tablica[t][k] != 9) {
                tablica[t][k] = 9;
                sumabomb++;
            }
        }
        int ilosc9 = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (tablica[i][j] == 9) {
                    ilosc9++;
                }
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("ilosc bomb:" + ilosc9);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int suma = 0;

                if (i == 0 && j == 0 && tablica[i][j] != 9) {
                    if (tablica[i + 1][j + 1] == 9) {
                        suma++;
                    }
                    if (tablica[i][j + 1] == 9) {
                        suma++;
                    }
                    if (tablica[i + 1][j] == 9) {
                        suma++;
                    }

                } else if (i == 0 && j == 19 && tablica[i][j] != 9) {
                    if (tablica[i + 1][j] == 9) {
                        suma++;
                    }
                    if (tablica[i][j - 1] == 9) {
                        suma++;
                    }
                    if (tablica[i + 1][j - 1] == 9) {
                        suma++;
                    }

                } else if (i == 19 && j == 0 && tablica[i][j] != 9) {
                    if (tablica[i - 1][j + 1] == 9) {
                        suma++;
                    }
                    if (tablica[i][j + 1] == 9) {
                        suma++;
                    }
                    if (tablica[i - 1][j] == 9) {
                        suma++;
                    }

                } else if (i == 19 && j == 19 && tablica[i][j] != 9) {
                    if (tablica[i - 1][j - 1] == 9) {
                        suma++;
                    }
                    if (tablica[i][j - 1] == 9) {
                        suma++;
                    }
                    if (tablica[i - 1][j] == 9) {
                        suma++;
                    }

                } else if (i == 0 && j > 0 && j < 19 && tablica[i][j] != 9) {
                    for (int s = -1; s <= 1; s++) {
                        if ((j + s >= 0) && (j + s < 20) && tablica[i + 1][j + s] == 9) {
                            suma++;
                        }
                    }
                    if ((j + 1 < 20) && tablica[i][j + 1] == 9) {
                        suma++;
                    }
                    if ((j - 1 >= 0) && tablica[i][j - 1] == 9) {
                        suma++;
                    }
                } else if (i == 19 && j > 0 && j < 19 && tablica[i][j] != 9) {
                    for (int s = -1; s <= 1; s++) {
                        if ((j + s >= 0) && (j + s < 20) && tablica[i - 1][j + s] == 9) {
                            suma++;
                        }
                    }
                    if ((j + 1 < 20) && tablica[i][j + 1] == 9) {
                        suma++;
                    }
                    if ((j - 1 >= 0) && tablica[i][j - 1] == 9) {
                        suma++;
                    }
                } else if (j == 0 && i > 0 && i < 19 && tablica[i][j] != 9) {
                    for (int s = -1; s <= 1; s++) {
                        if ((i + s >= 0) && (i + s < 20) && tablica[i + s][j + 1] == 9) {
                            suma++;
                        }
                    }
                    if ((i + 1 < 20) && tablica[i + 1][j] == 9) {
                        suma++;
                    }
                    if ((i - 1 >= 0) && tablica[i - 1][j] == 9) {
                        suma++;
                    }
                } else if (j == 19 && i > 0 && i < 19 && tablica[i][j] != 9) {
                    for (int s = -1; s <= 1; s++) {
                        if ((i + s >= 0) && (i + s < 20) && tablica[i + s][j - 1] == 9) {
                            suma++;
                        }
                    }
                    if ((i + 1 < 20) && tablica[i + 1][j] == 9) {
                        suma++;
                    }
                    if ((i - 1 >= 0) && tablica[i - 1][j] == 9) {
                        suma++;
                    }
                } else if (j > 0 && j < 19 && i > 0 && i < 19 && tablica[i][j] != 9) {
                    for (int s = -1; s <= 1; s++) {
                        if ((j + s >= 0) && (j + s < 20) && tablica[i + 1][j + s] == 9) {
                            suma++;
                        }
                    }
                    for (int s = -1; s <= 1; s++) {
                        if ((j + s >= 0) && (j + s < 20) && tablica[i - 1][j + s] == 9) {
                            suma++;
                        }
                    }
                    if ((j - 1 >= 0) && tablica[i][j- 1] == 9 ) {
                        suma++;
                    }
                    if ((j+1 <=19) && tablica[i ][j+ 1] == 9) {
                        suma++;
                    }
                }
                if (tablica[i][j] != 9) {
                    tablica[i][j] = suma;
                }

            }
        }
    }
    public void initializeTablica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializeTablica'");
    }
}
