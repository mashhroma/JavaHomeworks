package Homework06;

public class Notebook {

    private String model;
    private int memoryRAM;
    private int memoryHard;
    private String notebookOS;
    private int screenSize;
    private String brand;
    private String color;

    public Notebook(String model, int memoryRAM, int memoryHard, String notebookOS, int screenSize) {
        this.model = model;
        this.memoryRAM = memoryRAM;
        this.memoryHard = memoryHard;
        this.notebookOS = notebookOS;
        this.screenSize = screenSize;
    }

    public Notebook(String model, int memoryRAM, int memoryHard, String notebookOS, int screenSize, String brand,
            String color) {
        this(model, memoryRAM, memoryHard, notebookOS, screenSize);
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format(
                " Модель: %s,\n Оперативная память: %d,\n Жесткий диск: %d,\n Операционная система: %s,\n Размер экрана: %d,\n Производитель: %s,\n Цвет: %s\n",
                model, memoryRAM, memoryHard, notebookOS, screenSize, brand, color);
    }

    public String getModel() {
        return model;
    }

    public int getRAM() {
        return memoryRAM;
    }

    public int getHard() {
        return memoryHard;
    }

    public String getOS() {
        return notebookOS;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}
