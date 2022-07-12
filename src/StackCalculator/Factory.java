package StackCalculator;

import StackCalculator.Commands.IBaseCommand;
import StackCalculator.Exceptions.IncorrectCommandName;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Factory {
    private Properties properties;

    public Factory() throws IOException {
        properties = new Properties();
        ClassLoader loader = Factory.class.getClassLoader();
        InputStream stream = loader.getResourceAsStream("Settings.properties");
        assert stream != null;
        properties.load(stream);
    }

    public IBaseCommand create(String commandName) throws Exception {
        try {
            String className = properties.getProperty(commandName);
            Class cl = null;
            cl = Class.forName("StackCalculator.Commands." + className);
            return (IBaseCommand) cl.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
           throw new IncorrectCommandName();
        }



    }
}
