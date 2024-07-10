//CODE REVIEW
//Mes commentaires correspondent à ceux que j'aurai mis sur Discord

public class OrderProcessor {
    private Database database;
    private EmailService emailService;
    private InventorySystem inventorySystem;

    public OrderProcessor() {
        this.database = new Database();
        this.emailService = new EmailService();
        this.inventorySystem = new InventorySystem();
    }

    public void processOrder(Order order) {
        // Je pense que l'inventorySystem devrait directement prendre en argument
        // l'order et faire tout le processus à l'intérieur de celui-ci
        inventorySystem.checkIfOneOfItemIsNotAvailable(order);

        // Enregistrer la commande dans la base de données
        // Rendre plus clair le nom des méthodes
        database.saveOrderIntoDatabase(order);

        // Pourquoi créer une variable 'message', ce n'est pas le job de OrderProcessor
        emailService.sendEmailOrderSucessful(order.getCustomerEmail());

        // Même principe que le reste
        inventorySystem.updateInventoryDueToAnOrder(order);

        // Appliquer une remise pour les clients fidèles
        // Selon moi ce n'est pas La commande qui est fidèle mais le Client donc je ne comprends pas
        // Pourquoi on regarde cela sur la commande. Autant ajouter un booléen dans le client qui d
        if (order.getCustomer() instanceof LoyalCustomer) {
            order.applyTenPercentDiscount();
        }
    }
}

public class LoyalCustomer extends Client {
    @Override
    public void applyTenPercentDiscount() {
        // Pas de magic numbers s'il vous plaît
        setTotalPrice(getTotalPrice() * 0.9);
    }
}
