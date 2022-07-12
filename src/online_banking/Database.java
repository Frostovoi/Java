package online_banking;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/OnlineBanking";
    static final String USER = "postgres";
    static final String PASS = "admin";

    private Connection connection;

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public Client findClient(String login, String password) throws SQLException {
        String sql = "SELECT * FROM \"Clients\" WHERE login = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        Client client = null;
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String phone = resultSet.getString("phone");
            client = new Client(name, surname, login, password, phone, id);
            statement.close();
            var accounts = findAccounts(id);
            for(Account account : accounts){
                client.addAccount(account);
            }
        }
        return client;
    }

    public ArrayList<Account> findAccounts(int id) throws SQLException {
        String sql = "SELECT * FROM \"Accounts\" WHERE client_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<Account> accounts = new ArrayList<>();
        while(resultSet.next()){
            int accountId = resultSet.getInt("id");
            String number = resultSet.getString("number");
            int balance = resultSet.getInt("balance");
            Account account = new Account(accountId, number, balance);
            accounts.add(account);
        }
        statement.close();
        return accounts;
    }

    public boolean isUniqueNumber(String accountNumber) throws SQLException {
        String sql = "SELECT number FROM \"Accounts\" WHERE number = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        try (statement) {
            statement.setString(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        }
        return true;
    }

    public void addAccount(Client client, Account account) throws SQLException {
        String sql = "INSERT INTO \"Accounts\" (number, balance, client_id) VALUES (?, ?, ?) RETURNING id";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, account.getNumber());
        statement.setInt(2,0);
        statement.setInt(3, client.getId());

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        account.setId(resultSet.getInt(1));
        statement.close();
    }

    public void updateAccount(Account account) throws SQLException {
        String sql = "UPDATE \"Accounts\" SET balance = ? WHERE number = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, account.getBalance());
        statement.setString(2, account.getNumber());
        statement.executeUpdate();
    }

}
