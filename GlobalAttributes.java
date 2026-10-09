public class GlobalAttributes {
    public static void clean() {
        try {
            if(System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch(Exception e) {
            System.out.println("Failed to clean".repeat(50));
        }
    }

    public static void sleepManager() {
        try {
            Thread.sleep(50);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}