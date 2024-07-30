public class RealImage implements Image {
    private String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }
    private void loadImageFromDisk() {
        System.out.println("Loading " + fileName);
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
