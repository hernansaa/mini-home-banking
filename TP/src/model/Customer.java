package model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
//    private List<Account> accounts;
//    private List<Card> cards;

    public Customer(String username, String firstName, String lastName, int nationalId, String email, String address,
			String password) {
        super(username, firstName, lastName, nationalId, email, address, password);
//        this.accounts = new ArrayList<>();
//        this.cards = new ArrayList<>();
    }

    @Override
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Business methods
//    public void transfer(Account from, Account to, double amount) {
//        from.debit(amount, "Transfer to " + to.getAlias());
//        to.credit(amount, "Transfer from " + from.getAlias());
//    }

    // Getters and setters
//    public List<Account> getAccounts() { return accounts; }
//    public void addAccount(Account account) { accounts.add(account); }
//
//    public List<Card> getCards() { return cards; }
//    public void addCard(Card card) { cards.add(card); }
}
