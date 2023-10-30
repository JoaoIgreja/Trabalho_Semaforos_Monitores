public class MaquinaDeCafeSemControle {

    public void fazerCafeSemControle() {
        System.out.println(Thread.currentThread().getName() + " está usando a máquina de café.");
        System.out.println("Preparando café...");
        try {
            Thread.sleep(1000); // Simula um atraso na preparação do café
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Café pronto para " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MaquinaDeCafeSemControle maquina = new MaquinaDeCafeSemControle();

        Thread pessoa1 = new Thread(() -> {
            maquina.fazerCafeSemControle();
        });

        Thread pessoa2 = new Thread(() -> {
            maquina.fazerCafeSemControle();
        });

        pessoa1.start();
        pessoa2.start();
    }
}
