public class FilosofosComelones {
    public static void main(String[] args) {
        final int NUM_FILOSOFOS = 5;
        Object[] tenedores = new Object[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            tenedores[i] = new Object();
        }

        Thread[] filosofos = new Thread[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            final Object tenedorIzquierdo = tenedores[i];
            final Object tenedorDerecho = tenedores[(i + 1) % NUM_FILOSOFOS];
            filosofos[i] = new Thread(new Filosofo(i + 1, tenedorIzquierdo, tenedorDerecho));
        }

        // Iniciar los hilos de los filósofos
        for (Thread filosofo : filosofos) {
            filosofo.start();
        }
    }
}