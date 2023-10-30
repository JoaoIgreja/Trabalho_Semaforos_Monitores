public class MaquinaDeCafeComControle {

    private boolean emUso = false;

    public synchronized void fazerCafeComControle() {
        while (emUso) {
            try {
                wait(); // Aguarda até que a máquina de café esteja disponível
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        emUso = true;
        System.out.println(Thread.currentThread().getName() + " está usando a máquina de café.");
        System.out.println("Preparando café...");
        System.out.println("Café pronto para " + Thread.currentThread().getName());

        emUso = false;
        notify(); // Notifica outras threads que a máquina de café está disponível novamente
    }

    public static void main(String[] args) {
        MaquinaDeCafeComControle maquina = new MaquinaDeCafeComControle();

        Thread pessoa1 = new Thread(() -> {
            maquina.fazerCafeComControle();
        });

        Thread pessoa2 = new Thread(() -> {
            maquina.fazerCafeComControle();
        });

        pessoa1.start();
        pessoa2.start();
    }
}
