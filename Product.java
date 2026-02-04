public class Product {
    private String nameProduct;
    private String dateProductCreate;
    private String creatorProduct;
    private String countryCreate;
    private int priceProduct;
    private boolean buyerReservation;

    public Product(String _nameProduct, String _dateProductCreate, String _creatorProduct,
                   String _countryCreate, int _priceProduct, boolean _buyerReservation) {
        nameProduct = _nameProduct;
        dateProductCreate = _dateProductCreate;
        creatorProduct = _creatorProduct;
        countryCreate = _countryCreate;
        priceProduct = _priceProduct;
        buyerReservation = _buyerReservation;
    }

    public String toString() {
        return "Название: " + nameProduct + "\n" +
                "Дата производства: " + dateProductCreate + "\n" +
                "Производитель: " + creatorProduct + "\n" +
                "Страна Происхождения: " + countryCreate + "\n" +
                "Цена: " + priceProduct + " р\n" +
                "Состояние брони покупателем: " + buyerReservation;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Стол из ясеня", "26.05.2020",
                "Мебельный Завод", "Россия", 2000,
                true);
        System.out.println(product1);

        Park myPark = new Park("Центральный парк", 1);
        myPark.addAttraction(0, "Американские горки", "12:00-20:00", 1000);
        myPark.displayParkInfo();
    }

    public static void main2(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, false);
        productsArray[1] = new Product("Samsung S24 Ultra", "25.01.2025", "Samsung Corp.", "Korea", 5499, true);
        productsArray[2] = new Product("Samsung S23 Ultra", "01.01.2025", "Samsung Corp.", "Korea", 5099, true);
        productsArray[3] = new Product("Samsung S22 Ultra", "15.12.2024", "Samsung Corp.", "Korea", 4999, true);
        productsArray[4] = new Product("Samsung S21 Ultra", "25.7.2024", "Samsung Corp.", "Korea", 4699, true);

    }

}

class Park {
    private String parkName;
    private Attraction[] attractions;

    public Park(String _parkName, int attractionCount) {
        parkName = _parkName;
        attractions = new Attraction[attractionCount];
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private int price;

        public Attraction(String _attractionName, String _workingHours, int _price) {
            attractionName = _attractionName;
            workingHours = _workingHours;
            price = _price;
        }

        public String toString() {
            return "Аттракцион: " + attractionName + "\n" +
                    "Время работы: " + workingHours + "\n" +
                    "Стоимость: " + price + " р\n";
        }
    }

    public void addAttraction(int index, String name, String hours, int price) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, hours, price);
        }
    }

    public void displayParkInfo() {
        System.out.println();
        System.out.println(parkName);
        for (int i = 0; i < attractions.length; i++) {
            if (attractions[i] != null) {
                System.out.println(attractions[i]);
            }
        }
    }
}

