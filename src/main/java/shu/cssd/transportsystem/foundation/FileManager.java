package shu.cssd.transportsystem.foundation;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class FileManager implements Serializable {

    private File fileManager;

    /**
     * Create an instance of the FileManager using the provided path
     *
     * @param path {@link String} Path of the file path
     */
    public FileManager(String path)
    {
        this.fileManager = new File(path);
    }
    
    /**
     * Check for the Existence of the file
     *
     * @return boolean
     */
    public boolean exists()
    {
        return this.fileManager.exists();
    }
    
    /**
     * Create a new data store for the given path
     *
     * @return boolean
     */
    public boolean create()
    {
        try {

            // create a new file with the correct name
            return this.fileManager.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
