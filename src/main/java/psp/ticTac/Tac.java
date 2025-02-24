package psp.ticTac;

class Tac extends Thread {

    public void run() {
        while (true) {
            System.out.println("TAC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}