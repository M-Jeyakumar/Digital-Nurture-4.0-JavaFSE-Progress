package Week_1.Design_Patterns_and_Principles.Exercise_3_Implementing_the_Builder_Pattern;

// BuilderPatternExample.java
public class BuilderPatternExample {

    // Product Class: Computer
    static class Computer {
        // Required attributes
        private String CPU;
        private String RAM;
        private String Storage;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        // Private Constructor to force building via Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage +
                    ", GraphicsCard=" + isGraphicsCardEnabled + ", Bluetooth=" + isBluetoothEnabled + "]";
        }

        // Static Nested Builder Class
        static class Builder {
            // Required attributes
            private String CPU;
            private String RAM;
            private String Storage;

            // Optional attributes
            private boolean isGraphicsCardEnabled;
            private boolean isBluetoothEnabled;

            // Constructor for required parameters
            public Builder(String CPU, String RAM, String Storage) {
                this.CPU = CPU;
                this.RAM = RAM;
                this.Storage = Storage;
            }

            public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
                return this;
            }

            public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Main method for testing the Builder Pattern
    public static void main(String[] args) {
        // Create a Gaming Computer
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB", "1TB SSD")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        // Create a Office Computer
        Computer officePC = new Computer.Builder("Intel i5", "16GB", "512GB SSD")
                .setGraphicsCardEnabled(false)
                .setBluetoothEnabled(true)
                .build();

        // Display Computers
        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}
