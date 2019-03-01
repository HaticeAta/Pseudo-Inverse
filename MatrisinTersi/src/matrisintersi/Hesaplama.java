/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrisintersi;

/**
 *
 * @author Hatice
 */
public class Hesaplama {

    static int satir;   // A matrisinin satır sayisi
    static int sutun;   // A matrisinin sutun sayisi

    static double[][] amatrisi; // A matrisi
    static double[][] transpozematrisi; // A matrisinin transpozesi
    static double[][] axtranspoze; // amatrisi x transpozematrisi
    static double determinant;   // carpim matrisinin determinantı
    static double[][] axtranspozetersi;
    static double[][] amatrisinintersi;
    static double[][] birimmatris;
    static String yazi, yazi1, yazi2, yazi6, yazi7, yazi10, yazi11, yazi12, yazi13, yazi15;

    public static void matrisial(double[][] gelen) {
        satir = gelen.length;
        sutun = gelen[0].length;
        amatrisi = new double[satir][sutun];
        yazi1 = "A = ";
        for (int i = 0; i < satir; i++) {
            yazi1 += "[ ";
            for (int j = 0; j < sutun; j++) {
                amatrisi[i][j] = gelen[i][j];
                yazi1 += amatrisi[i][j];
                if (j != sutun - 1) {
                    yazi1 += "   ";
                }
            }
            yazi1 += " ]\n      ";
        }

        if (satir > sutun) {

            transpoze();
            yazmbuyukn1();
            axtranspozeislemi(transpozematrisi, amatrisi);
            determinant();
            axtranspozetersibul("(A^T x A)");

            yazi11 = "A^-1 = ";
            amatrisinintersi(axtranspozetersi, transpozematrisi);
            yazmbuyukn2();
            yazi13 = "\nA^-1 x A = I olmalıdır..\n\n";
            yazi15 = "A^-1 x A = I = ";
            birimmatris(amatrisinintersi, amatrisi);
            yazmbuyukn3();

        } else if (satir < sutun) {
            transpoze();
            yaznbuyukm1();
            axtranspozeislemi(amatrisi, transpozematrisi);
            determinant();
            axtranspozetersibul("(A x A^T)");

            yazi11 = "A^-1 = ";
            amatrisinintersi(transpozematrisi, axtranspozetersi);
            yaznbuyukm2();
            yazi13 = "\nA x A^-1 = I olmalıdır..\n\n";
            yazi15 = "A x A^-1 = I = ";
            birimmatris(amatrisi, amatrisinintersi);
            yaznbuyukm3();
        }
    }

    public static void yazmbuyukn1() {
        yazi = "";
        yazi = "A Matrisi " + satir + " satır ve " + sutun + " sutundan oluşur." + " Bu nedenle A matrisinin tersi "
                + sutun + " satırdan ve " + satir + " sutundan oluşmalıdır.\n\n"
                + "A^-1 = ( A^T x A )^-1 x A^T\n";

        yazi7 = "A^T x A =  [ ";

        for (int i = 0; i < satir; i++) {
            if (i == 0) {
                for (int j = 0; j < satir; j++) {
                    yazi7 += transpozematrisi[i][j] + " ";
                }
                yazi7 += "]  *  [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi7 += amatrisi[i][k] + " ";
                }
                yazi7 += " ] \n";
            } else if (i > 0 && i < sutun && sutun > 1) {
                yazi7 += "                  [ ";
                for (int k = 0; k < satir; k++) {
                    yazi7 += transpozematrisi[i][k] + " ";
                }
                yazi7 += "]     [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi7 += amatrisi[i][k] + " ";
                }
                yazi7 += "] \n";

            } else if (i >= sutun) {
                yazi7 += "                     ";
                for (int j = 0; j < satir; j++) {
                    yazi7 += "      ";
                }
                yazi7 += "     [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi7 += amatrisi[i][k] + " ";
                }
                yazi7 += "] \n";
            }
        }

        yazi6 = "A^T x A = ";

    }

    public static void yazmbuyukn2() {
        yazi12 = "A^-1 = ( A x A^T )^-1 x A^T\n\n";
        yazi12 += "( A x A^T )^-1 x A^T = [ ";

        for (int i = 0; i < sutun; i++) {
            if (i == 0) {
                for (int j = 0; j < sutun; j++) {
                    yazi12 += axtranspozetersi[i][j] + "  ";
                }
                yazi12 += "]  *  [ ";
                for (int k = 0; k < satir; k++) {
                    yazi12 += transpozematrisi[i][k] + "  ";
                }
                yazi12 += "] \n";
            } else if (i > 0 && i < sutun && sutun > 1) {
                yazi12 += "	            [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi12 += axtranspozetersi[i][k] + "  ";
                }
                yazi12 += "]     [ ";
                for (int k = 0; k < satir; k++) {
                    yazi12 += transpozematrisi[i][k] + "  ";
                }
                yazi12 += "] \n";

            } else if (i >= sutun) {
                yazi12 += "	            [ ";
                for (int j = 0; j < satir; j++) {
                    yazi12 += "        ";
                }
                yazi12 += "[ ";
                for (int k = 0; k < satir; k++) {
                    yazi12 += transpozematrisi[i][k] + "  ";
                }
                yazi12 += "] \n";
            }
        }
    }

    public static void yaznbuyukm1() {
        yazi = "";
        yazi7 = "";
        yazi = "A Matrisi  " + satir + " satır ve " + sutun + " sutundan oluşur." + " Bu nedenle A matrisinin tersi "
                + sutun + " satırdan ve " + satir + " sutundan oluşmalıdır.\n\n"
                + "A^-1 = A^T x ( A x A^T )^-1\n";

        yazi7 = "";
        yazi7 = "A x A^T = [ ";

        for (int i = 0; i < sutun; i++) {
            if (i == 0) {
                for (int j = 0; j < sutun; j++) {
                    yazi7 += amatrisi[i][j] + " ";
                }
                yazi7 += "]  *  [ ";
                for (int k = 0; k < satir; k++) {
                    yazi7 += transpozematrisi[i][k] + " ";
                }
                yazi7 += "] \n";
            } else if (i > 0 && i < satir && sutun > 1) {
                yazi7 += "                 [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi7 += amatrisi[i][k] + " ";
                }
                yazi7 += "]     [ ";
                for (int k = 0; k < satir; k++) {
                    yazi7 += transpozematrisi[i][k] + " ";
                }
                yazi7 += "] \n";

            } else if (i >= satir) {
                yazi7 += "                    ";
                for (int j = 0; j < sutun; j++) {
                    yazi7 += "      ";
                }
                yazi7 += "     [ ";
                for (int k = 0; k < satir; k++) {
                    yazi7 += transpozematrisi[i][k] + " ";
                }
                yazi7 += "] \n";
            }
        }

        yazi6 = "A x A^T = ";

    }

    public static void yaznbuyukm2() {
        yazi12 = "A^-1 = A^T x ( A x A^T )^-1\n\n";
        yazi12 += "A^T x ( A x A^T )^-1 = [ ";

        for (int i = 0; i < sutun; i++) {
            if (i == 0) {
                for (int j = 0; j < satir; j++) {
                    yazi12 += transpozematrisi[i][j] + "  ";
                }
                yazi12 += "]  *  [ ";
                for (int k = 0; k < satir; k++) {
                    yazi12 += axtranspozetersi[i][k] + "  ";
                }
                yazi12 += "] \n";
            } else if (i > 0 && i < satir && satir > 1) {
                yazi12 += "	             [ ";
                for (int k = 0; k < satir; k++) {
                    yazi12 += transpozematrisi[i][k] + "  ";
                }
                yazi12 += "]     [ ";
                for (int k = 0; k < satir; k++) {
                    yazi12 += axtranspozetersi[i][k] + "  ";
                }
                yazi12 += "] \n";

            } else if (i >= satir) {
                yazi12 += "	             [ ";
                for (int j = 0; j < satir; j++) {
                    yazi12 += transpozematrisi[i][j] + "  ";

                }
                yazi12 += "] \n";

            }
        }
    }

    public static void yazmbuyukn3() {
        yazi13 += "A^-1 x A = [ ";

        for (int i = 0; i < satir; i++) {
            if (i == 0) {
                for (int j = 0; j < satir; j++) {
                    yazi13 += amatrisinintersi[i][j] + "  ";
                }
                yazi13 += "]  *  [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi13 += amatrisi[i][k] + "  ";
                }
                yazi13 += "] \n";
            } else if (i > 0 && i < sutun && sutun > 1) {
                yazi13 += "                  [ ";
                for (int k = 0; k < satir; k++) {
                    yazi13 += amatrisinintersi[i][k] + "  ";
                }
                yazi13 += "]     [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi13 += amatrisi[i][k] + "  ";
                }
                yazi13 += "] \n";

            } else if (i >= sutun) {
                yazi13 += "                   ";
                for (int j = 0; j < satir; j++) {
                    yazi13 += "                                        ";
                }
                yazi13 += "     [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi13 += amatrisi[i][k] + "  ";
                }
                yazi13 += "] \n";
            }
        }
    }

    public static void yaznbuyukm3() {
        yazi13 += "A x A^-1 = [ ";

        for (int i = 0; i < sutun; i++) {
            if (i == 0) {
                for (int j = 0; j < sutun; j++) {
                    yazi13 += amatrisi[i][j] + " ";
                }
                yazi13 += "]  *  [ ";
                for (int k = 0; k < satir; k++) {
                    yazi13 += amatrisinintersi[i][k] + " ";
                }
                yazi13 += "] \n";
            } else if (i > 0 && i < satir && satir > 1) {
                yazi13 += "                  [ ";
                for (int k = 0; k < sutun; k++) {
                    yazi13 += amatrisi[i][k] + " ";
                }
                yazi13 += "]     [ ";
                for (int k = 0; k < satir; k++) {
                    yazi13 += amatrisinintersi[i][k] + " ";
                }
                yazi13 += "] \t\n";

            } else if (i >= satir) {
                yazi13 += "                     ";
                for (int j = 0; j < sutun; j++) {
                    yazi13 += "      ";
                }
                yazi13 += "      [ ";
                for (int k = 0; k < satir; k++) {
                    yazi13 += amatrisinintersi[i][k] + " ";
                }
                yazi13 += "] \t\n";
            }
        }
    }

    public static void transpoze() {
        yazi2 = "A^T : ";
        transpozematrisi = new double[sutun][satir];
        for (int i = 0; i < sutun; i++) {
            yazi2 += "[ ";
            for (int j = 0; j < satir; j++) {
                transpozematrisi[i][j] = amatrisi[j][i];
                yazi2 += transpozematrisi[i][j];
                if (j != satir - 1) {
                    yazi2 += "   ";
                }
            }
            yazi2 += " ]\n         ";
        }

    }

    public static void axtranspozeislemi(double[][] birinci, double[][] ikinci) {

        int satir1 = birinci.length;
        int sutun1 = birinci[0].length;
        int satir2 = ikinci.length;
        int sutun2 = ikinci[0].length;
        double toplam = 0;
        axtranspoze = new double[satir1][sutun2];

        for (int i = 0; i < satir1; i++) {

            for (int j = 0; j < sutun2; j++) {
                for (int k = 0; k < sutun1; k++) {
                    toplam += (birinci[i][k] * ikinci[k][j]);
                }
                axtranspoze[i][j] = toplam;
                toplam = 0;
            }
        }
        for (int i = 0; i < axtranspoze.length; i++) {
            yazi6 += "[ ";
            for (int j = 0; j < axtranspoze[i].length; j++) {
                yazi6 += Math.round(axtranspoze[i][j] * 100000000.0) / 100000000.0;
                if (j != axtranspoze[i].length - 1) {
                    yazi6 += "    ";
                }
            }
            yazi6 += " ]\n                 ";
        }
    }

    public static void determinant() {

        int boyut = axtranspoze.length;

        if (boyut == 1) {
            determinant = axtranspoze[0][0];
        } else if (boyut == 2) {
            determinant = ((axtranspoze[0][0] * axtranspoze[1][1]) - (axtranspoze[0][1] * axtranspoze[1][0]));

        } else if (boyut == 3) {

            determinant = (((axtranspoze[0][0] * axtranspoze[1][1] * axtranspoze[2][2])
                    + (axtranspoze[0][1] * axtranspoze[1][2] * axtranspoze[2][0])
                    + (axtranspoze[0][2] * axtranspoze[1][0] * axtranspoze[2][1]))
                    - ((axtranspoze[0][2] * axtranspoze[1][1] * axtranspoze[2][0])
                    + (axtranspoze[0][0] * axtranspoze[1][2] * axtranspoze[2][1])
                    + (axtranspoze[0][1] * axtranspoze[1][0] * axtranspoze[2][2])));

        } else if (boyut == 4) {

            determinant = ((axtranspoze[0][0] * axtranspoze[1][1] * axtranspoze[2][2] * axtranspoze[3][3])
                    - (axtranspoze[0][0] * axtranspoze[1][1] * axtranspoze[2][3] * axtranspoze[3][2])
                    - (axtranspoze[0][0] * axtranspoze[1][2] * axtranspoze[2][1] * axtranspoze[3][3])
                    + (axtranspoze[0][0] * axtranspoze[1][2] * axtranspoze[2][3] * axtranspoze[3][1])
                    + (axtranspoze[0][0] * axtranspoze[1][3] * axtranspoze[2][1] * axtranspoze[3][2])
                    - (axtranspoze[0][0] * axtranspoze[1][3] * axtranspoze[2][2] * axtranspoze[3][1])
                    - (axtranspoze[0][1] * axtranspoze[1][0] * axtranspoze[2][2] * axtranspoze[3][3])
                    + (axtranspoze[0][1] * axtranspoze[1][0] * axtranspoze[2][3] * axtranspoze[3][2])
                    + (axtranspoze[0][1] * axtranspoze[1][2] * axtranspoze[2][0] * axtranspoze[3][3])
                    - (axtranspoze[0][1] * axtranspoze[1][2] * axtranspoze[2][3] * axtranspoze[3][0])
                    - (axtranspoze[0][1] * axtranspoze[1][3] * axtranspoze[2][0] * axtranspoze[3][2])
                    + (axtranspoze[0][1] * axtranspoze[1][3] * axtranspoze[2][2] * axtranspoze[3][0])
                    + (axtranspoze[0][2] * axtranspoze[1][0] * axtranspoze[2][1] * axtranspoze[3][3])
                    - (axtranspoze[0][2] * axtranspoze[1][0] * axtranspoze[2][3] * axtranspoze[3][1])
                    - (axtranspoze[0][2] * axtranspoze[1][1] * axtranspoze[2][0] * axtranspoze[3][3])
                    + (axtranspoze[0][2] * axtranspoze[1][1] * axtranspoze[2][3] * axtranspoze[3][0])
                    + (axtranspoze[0][2] * axtranspoze[1][3] * axtranspoze[2][0] * axtranspoze[3][1])
                    - (axtranspoze[0][2] * axtranspoze[1][3] * axtranspoze[2][1] * axtranspoze[3][0])
                    - (axtranspoze[0][3] * axtranspoze[1][0] * axtranspoze[2][1] * axtranspoze[3][2])
                    + (axtranspoze[0][3] * axtranspoze[1][0] * axtranspoze[2][2] * axtranspoze[3][1])
                    + (axtranspoze[0][3] * axtranspoze[1][1] * axtranspoze[2][0] * axtranspoze[3][2])
                    - (axtranspoze[0][3] * axtranspoze[1][1] * axtranspoze[2][2] * axtranspoze[3][0])
                    - (axtranspoze[0][3] * axtranspoze[1][2] * axtranspoze[2][0] * axtranspoze[3][1])
                    + (axtranspoze[0][3] * axtranspoze[1][2] * axtranspoze[2][1] * axtranspoze[3][0]));

        }

    }

    static double[][] A, Akare, Akup, BRM, trAmatris, bir, iki, uc, dort, sonuc;

    public static void axtranspozetersibul(String matris) {
        int boyut = axtranspoze.length;
        yazi10 = "";
        axtranspozetersi = new double[axtranspoze.length][axtranspoze.length];
        if (boyut == 1) {
            axtranspozetersi[0][0] = (1.0 / determinant);
            yazi10 += matris + "^-1  = [ " + axtranspozetersi[0][0] + " ]\n";
        } else if (boyut == 2) {
            axtranspozetersi[0][0] = (axtranspoze[1][1] / determinant);
            axtranspozetersi[0][1] = (-axtranspoze[0][1] / determinant);
            axtranspozetersi[1][0] = (-axtranspoze[1][0] / determinant);
            axtranspozetersi[1][1] = (axtranspoze[0][0] / determinant);

            yazi10 += "" + matris + "^-1  =  [ " + axtranspozetersi[0][0] + "     " + axtranspozetersi[0][1] + " ] \n"
                    + "\t  [ " + axtranspozetersi[1][0] + "     " + axtranspozetersi[1][1] + " ]\n";
        } else if (boyut == 3) {

            //      axtranspoze=A
            //      axtranspozetersi = 1/det
            //          *[(1/2*((trA)^2-(tr(A*A)))I)  => bir
            //          -((A)(trA))     =   iki
            //          +(A*A)]         =   uc
            A = new double[3][3];
            Akare = new double[3][3];
            BRM = new double[3][3];
            bir = new double[3][3];
            iki = new double[3][3];
            uc = new double[3][3];
            sonuc = new double[3][3];
            A = axtranspoze;
            Akare = carpmaislemi(A, A);
            double trA = trbul(A);
            double trAkare = trbul(Akare);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        BRM[i][j] = 1;
                    } else {
                        BRM[i][j] = 0;
                    }
                }
            }

            double sayibir = 0.5 * ((trA * trA) - trAkare);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bir[i][j] = sayibir * BRM[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    iki[i][j] = A[i][j] * trA;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    uc[i][j] = Akare[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sonuc[i][j] = bir[i][j] - iki[i][j] + uc[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    axtranspozetersi[i][j] = ((1.0 / determinant) * sonuc[i][j]);
                }
            }

            yazi10 += matris + "^-1 = " + "  [ " + axtranspozetersi[0][0] + "     " + axtranspozetersi[0][1] + "     " + axtranspozetersi[0][2] + " ] \n"
                    + "\t  [ " + axtranspozetersi[1][0] + "     " + axtranspozetersi[1][1] + "     " + axtranspozetersi[1][2] + " ] \n"
                    + "\t  [ " + axtranspozetersi[2][0] + "     " + axtranspozetersi[2][1] + "     " + axtranspozetersi[2][2] + " ] \n";

        } else if (boyut == 4) {
            // axtranspoze = A;
            //  axtranspozetersi= 1/detA[
            // 1/6 *  (  (trA)^3 - 3*(trA)*(trA^2) + 2*tr(A^3) ) * I  => bir
            // - 1/2 * A *((trA)^2 - tr(A^2))        => iki
            //+(A^2 * trA)           =>uc
            // -(A^3)                =>dort
            // ]
            A = new double[4][4];
            Akare = new double[4][4];
            Akup = new double[4][4];
            BRM = new double[4][4];
            bir = new double[4][4];
            iki = new double[4][4];
            uc = new double[4][4];
            dort = new double[4][4];
            sonuc = new double[4][4];
            A = axtranspoze;
            Akare = carpmaislemi(A, A);
            Akup = carpmaislemi(Akare, A);

            double trA = trbul(A);
            double trAkare = trbul(Akare);
            double trAkup = trbul(Akup);

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == j) {
                        BRM[i][j] = 1;
                    } else {
                        BRM[i][j] = 0;
                    }
                }
            }

            double sayibir = ((1.0 / 6.0) * ((trA * trA * trA) - (3 * trA * trAkare) + (2 * trAkup)));

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    bir[i][j] = sayibir * BRM[i][j];
                }
            }

            double sayiiki = (trA * trA) - trAkare;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    iki[i][j] = (0.5) * A[i][j] * sayiiki;
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    uc[i][j] = Akare[i][j] * trA;
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dort[i][j] = Akup[i][j];
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    sonuc[i][j] = (bir[i][j] - iki[i][j] + uc[i][j] - dort[i][j]);
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    axtranspozetersi[i][j] = ((1.0 / determinant) * sonuc[i][j]);
                }
            }

            yazi10 += matris + "^-1 = " + "  [ " + axtranspozetersi[0][0] + "    " + axtranspozetersi[0][1] + "    " + axtranspozetersi[0][2] + "    " + axtranspozetersi[0][3] + " ] \n"
                    + "\t  [ " + axtranspozetersi[1][0] + "    " + axtranspozetersi[1][1] + "    " + axtranspozetersi[1][2] + "    " + axtranspozetersi[1][3] + " ] \n"
                    + "\t  [ " + axtranspozetersi[2][0] + "    " + axtranspozetersi[2][1] + "    " + axtranspozetersi[2][2] + "    " + axtranspozetersi[2][3] + " ] \n"
                    + "\t  [ " + axtranspozetersi[3][0] + "    " + axtranspozetersi[3][1] + "    " + axtranspozetersi[3][2] + "    " + axtranspozetersi[3][3] + " ]\n";

        }

    }

    public static double trbul(double[][] matris) {
        double toplam = 0.0;
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                if (i == j) {
                    toplam += matris[i][j];
                }
            }
        }
        return toplam;
    }

    static double[][] carpım;

    public static double[][] carpmaislemi(double[][] matris1, double[][] matris2) {
        int satir1 = matris1.length;
        int sutun1 = matris1[0].length;
        int satir2 = matris2.length;
        int sutun2 = matris2[0].length;
        double toplam = 0;
        carpım = new double[satir1][sutun2];

        for (int i = 0; i < satir1; i++) {
            for (int j = 0; j < sutun2; j++) {
                for (int k = 0; k < sutun1; k++) {
                    toplam += (matris1[i][k] * matris2[k][j]);
                }
                carpım[i][j] = toplam;
                toplam = 0;

            }
        }
        return carpım;
    }

    public static void amatrisinintersi(double[][] matris1, double[][] matris2) {
        int satir1 = matris1.length;
        int sutun1 = matris1[0].length;
        int satir2 = matris2.length;
        int sutun2 = matris2[0].length;
        double toplam = 0;
        amatrisinintersi = new double[satir1][sutun2];

        for (int i = 0; i < satir1; i++) {

            for (int j = 0; j < sutun2; j++) {
                for (int k = 0; k < sutun1; k++) {
                    toplam += (matris1[i][k] * matris2[k][j]);

                }

                amatrisinintersi[i][j] = toplam;
                toplam = 0;

            }

        }
        for (int i = 0; i < amatrisinintersi.length; i++) {
            yazi11 += " [ ";
            for (int j = 0; j < amatrisinintersi[i].length; j++) {
                //yazi11 += Math.round(amatrisinintersi[i][j] * 100000000.0) / 100000000.0;
                yazi11 += amatrisinintersi[i][j];
                if (j != amatrisinintersi[i].length - 1) {
                    yazi11 += "    ";
                }
            }
            yazi11 += " ]\n            ";
        }
    }

    public static void birimmatris(double[][] matris1, double[][] matris2) {
        int satir1 = matris1.length;
        int sutun1 = matris1[0].length;
        int satir2 = matris2.length;
        int sutun2 = matris2[0].length;
        double toplam = 0;
        birimmatris = new double[satir1][sutun2];

        for (int i = 0; i < satir1; i++) {

            for (int j = 0; j < sutun2; j++) {
                for (int k = 0; k < sutun1; k++) {
                    toplam += (matris1[i][k] * matris2[k][j]);

                }

                birimmatris[i][j] = toplam;
                toplam = 0;

            }

        }
        for (int i = 0; i < birimmatris.length; i++) {
            yazi15 += "[ ";
            for (int j = 0; j < birimmatris[i].length; j++) {
                yazi15 += Math.round(birimmatris[i][j] * 100000000.0) / 100000000.0;
                if (j != birimmatris[i].length - 1) {
                    yazi15 += "    ";
                }
            }
            yazi15 += " ]\n                       ";
        }

    }

}
