public class Filosofo implements Runnable {
    private final int id;
    private final Object tenedorIzquierdo;
    private final Object tenedorDerecho;

    public Filosofo(int id, Object tenedorIzquierdo, Object tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            System.out.println("Filósofo " + id + " se prepara para comer...");
            tomarTenedores();
            comer();
            dejarTenedores();
        }
    }

    private void pensar() {
        System.out.println("Filósofo " + id + " está pensando...");
        try {
            //Simula el tiempo que están pensando
            Thread.sleep((long) (Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tomarTenedores() {
        synchronized (tenedorIzquierdo) {
            System.out.println("Filósofo " + id + " toma su tenedor izquierdo...");
            synchronized (tenedorDerecho) {
                System.out.println("Filósofo " + id + " toma su tenedor derecho...");
            }
        }
    }

    private void comer() {
        System.out.println("Filósofo " + id + " está comiendo...");
        try {
            //Simula el tiempo que están comiendo
            Thread.sleep((long) (Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dejarTenedores() {
        synchronized (tenedorIzquierdo) {
            System.out.println("Filósofo " + id + " deja su tenedor izquierdo");
            synchronized (tenedorDerecho) {
                System.out.println("Filósofo " + id + " deja su tenedor derecho");
            }
        }
    }
}