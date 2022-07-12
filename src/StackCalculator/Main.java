package StackCalculator;

import StackCalculator.Commands.IBaseCommand;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       //String s = Paths.get(".").toAbsolutePath().normalize().toString();

        try (BufferedReader reader = new BufferedReader(new FileReader("commands.txt"))){
            Factory factory = new Factory();
            Context context = new Context();
            String line;
            while ((line = reader.readLine()) != null){
                String[] params = line.split("s++");
                IBaseCommand command = factory.create(params[0]);
                List<String> newArgs = new
                        ArrayList<>(Arrays.asList(
                        Arrays.copyOfRange(params, 1, params.length)));
                command.execute(newArgs,context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
