package aed;

class Funciones {
    int cuadrado(int x) {
        x*=x;
        return x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    boolean esPar(int n) {
        return n%2 == 0;
    }

    boolean esBisiesto(int n) {
        if (n%4 == 0 && n%100 != 0){
            return true;
        }
        else if (n%400 == 0){
            return true;
        }
        return false;
    }

    int factorialIterativo(int n) {
        int calculoFactorial = 1;
        for (int i = 2; i <= n; i++){
            calculoFactorial *= i;                
        }
        return calculoFactorial;
    }

    int factorialRecursivo(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursivo(n-1);
    }

    boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++){
            if (n%i==0) return false;
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int resultado = 0;
        for (int n : numeros){
            resultado+=n;
        }
        return resultado;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i<numeros.length; i++){
            if (numeros[i] == buscado){
                return i;
            }
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int n : numeros){
            if (esPrimo(n)) return true;
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int n : numeros){
            if (!esPar(n)) return false;
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        return esPrefijo(revertirString(s1), revertirString(s2));
    }

    String revertirString(String s){
        String stringRevertido = "";
        for (int i = s.length()-1; i >= 0; i--){
            stringRevertido+=s.charAt(i);
        }
        return stringRevertido;
    }

}
