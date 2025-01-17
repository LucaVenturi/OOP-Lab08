package it.unibo.oop.lab.mvcio;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 */
public class Controller implements Serializable {
    private static final long serialVersionUID = -1295964518006405011L;
    private File file;
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */
    public Controller() {
        super();
        this.file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt");
    }
    public Controller(final File file) {
        super();
        this.file = file;
    }
    /**
     * @return
     *      returns current file.
     */
    public File getFile() {
        return file;
    }
    /**
     * @param file
     *      The file that will be used by the class.
     */
    public void setFile(final File file) {
        this.file = file;
    }
    /**
     * @return
     *      Path of the current file.
     */
    public String getPath() {
        return this.file.getPath();
    }
    /**
     * @param s
     *      String to write in the file
     * @throws IOException
     */
    public void writeOnFile(final String s) throws IOException {
        final OutputStream file = new FileOutputStream(this.file);
        final DataOutputStream out = new DataOutputStream(file);
        out.writeUTF(s);
        out.close();
        file.close();

    }

}
