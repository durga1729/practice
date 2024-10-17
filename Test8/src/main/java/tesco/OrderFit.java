package tesco;

class Container {
    private int id;
    private int length;
    private int breadth;
    private int height;
    private int volume;

    public Container(int id, int length, int breadth, int height) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.volume = length * breadth * height;
    }

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }
}

class Product {
    private int productId;
    private int length;
    private int breadth;
    private int height;
    private int volume;

    public Product(int productId, int length, int breadth, int height) {
        this.productId = productId;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.volume = length * breadth * height;
    }

    public int getVolume() {
        return volume;
    }
}

public class OrderFit {
    public static void main(String[] args) {
        // Define containers
        Container[] containers = {
                new Container(1, 10, 20, 30),  // SMALL
                new Container(2, 50, 60, 70),  // MEDIUM
                new Container(3, 100, 200, 300) // LARGE
        };

        // Define products
        Product[] products = {
                new Product(1, 2, 4, 10),  // Product 1
                new Product(2, 10, 30, 4), // Product 2
                new Product(3, 5, 6, 7)    // Product 3
        };

        // Define the order
        int[][] order = {
                {1, 3},  // productId 1, quantity 3
                {2, 7}   // productId 2, quantity 7
        };

        // Calculate total volume required for the order
        int totalVolumeRequired = calculateTotalVolume(order, products);

        // Find and print the fitting container ID
        Integer fittingContainerId = findFittingContainer(containers, totalVolumeRequired);
        System.out.println(fittingContainerId != null ? fittingContainerId : "No fitting container found");
    }

    private static int calculateTotalVolume(int[][] order, Product[] products) {
        int totalVolume = 0;
        for (int[] item : order) {
            int productId = item[0] - 1; // Adjust for 0-based index
            int quantity = item[1];
            totalVolume += products[productId].getVolume() * quantity;
        }
        return totalVolume;
    }

    private static Integer findFittingContainer(Container[] containers, int totalVolume) {
        for (Container container : containers) {
            if (container.getVolume() >= totalVolume) {
                return container.getId();
            }
        }
        return null;
    }
}

