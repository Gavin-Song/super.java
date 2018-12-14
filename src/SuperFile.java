/**
 * SuperFile class - extended File class that supports
 * reading, writing, moving, etc...
 */

import java.io.*;
import java.net.URI;
import java.nio.file.Path;

/**
 * <h1>SuperFile</h1>
 * Extends the default functionality of File handling in java.
 * Many common methods are implemented, for ease of use. To create
 * a SuperFile, simply do<br>
 * {@code SuperFile s = new SuperFile("file/path/here.file");}
 *
 * Not a FileUtil class, use java's FileUtil for most other purposes.
 *
 * @author  Gavin Song
 * @version 1.0.0
 * @since   2018-12-04
 */
public class SuperFile
{
    private boolean loadEntireFileToCache;
    private String data;
    private File file;

    /**
     * Constructor. Input a file name, with
     * an optional parameter to save the entire
     * file to memory (Recommended for small files
     * only)
     *
     * @param filename  Filename to load
     * @param cache     Cache the file for future read?
     */
    public SuperFile(String filename, boolean cache) {
        this.file = new File(filename);
        this.loadEntireFileToCache = cache;
    }

    /**
     * Constructor. Input a file name, with
     * an optional parameter to save the entire
     * file to memory (Recommended for small files
     * only)
     *
     * @param filename  Filename to load
     */
    public SuperFile(String filename) {
        this(filename, false);
    }

    /**
     * Creates the file if it doesn't exist
     * @throws IOException
     */
    public void createIfNotExist() throws IOException {
        if (!this.exists())
            this.createNewFile();
    }

    /**
     * Creates the file if it doesn't exist
     */
    public void createIfNotExistIE() {
        if (!this.exists())
            this.createNewFileIE();
    }

    /**
     * isEmpty - is the file empty? (Only whitespace)
     * @param overrideCache override the cache
     * @return              Is the file empty?
     * @throws IOException
     */
    public boolean isEmpty(boolean overrideCache) throws IOException {
        return this.read(overrideCache).replaceAll("\\s+", "").length() == 0;
    }

    /**
     * isEmpty - is the file empty? (Only whitespace)
     * @return              Is the file empty?
     * @throws IOException
     */
    public boolean isEmpty() throws IOException{
        return this.read().replaceAll("\\s+", "").length() == 0;
    }

    /**
     * isEmptyIE - is the file empty? (Only whitespace)
     * Returns true if IOException occurs
     * @return              Is the file empty?
     */
    public boolean isEmptyIE() {
        try { return this.isEmpty(); }
        catch(IOException e) {}
        return true;
    }

    /**
     * isEmptyIE - is the file empty? (Only whitespace)
     * Returns true if IOException occurs.
     * Returns true if IOException occurs
     *
     * @param overrideCache override the cache
     * @return              Is the file empty?
     */
    public boolean isEmptyIE(boolean overrideCache) {
        try { return this.isEmpty(overrideCache); }
        catch(IOException e) {}
        return true;
    }

    /**
     * read - Reads a string from a file, and returns
     * it. Mutates this.data to match new value if not
     * using the cache.
     *
     * @param overrideCache Force reload instead of using cache
     * @return File contents
     * @throws IOException
     */
    public String read(boolean overrideCache) throws IOException {
        /* Load data from cache if allowed */
        if (this.loadEntireFileToCache && !overrideCache && this.data != null)
            return data;

        /* Reset data and re-read file */
        this.data = "";

        BufferedReader r = new BufferedReader(new FileReader(this.file));
        String line = r.readLine();
        while (line != null){
            this.data += line + "\n";
            line = r.readLine();
        }

        r.close();
        return this.data;
    }

    /**
     * read - Reads a string from a file, and returns
     * it. Mutates this.data to match new value if not
     * using the cache.
     *
     * @param start         Start pos to read from file
     * @param len           Length to read
     * @param overrideCache Force reload instead of using cache
     * @return File contents
     *
     * @throws IOException
     */
    public String read(int start, int len, boolean overrideCache) throws IOException {
        /* Load data from cache if allowed */
        if (this.loadEntireFileToCache && !overrideCache && this.data != null)
            return data;

        /* Reset data and re-read file */
        char[] data = new char[len];

        BufferedReader r = new BufferedReader(new FileReader(this.file));
        r.read(data, start, len);
        r.close();

        this.data = String.valueOf(data);
        return this.data;
    }

    /**
     * read - Reads a file from a string. Default: overrides
     * the cache and re-reads the file.
     *
     * @param start         Start pos to read from file
     * @param length        Length to read
     * @return File contents
     * @throws IOException
     */
    public String read(int start, int length) throws IOException {
        return this.read(start, length, true);
    }

    /**
     * Read lines instead of just as a string
     * @param noCache Don't use the cached data?
     * @return File, split by new lines
     * @throws IOException
     */
    public String[] readLines(boolean noCache) throws IOException {
        return this.read(noCache).split("\n");
    }

    /**
     * Read lines instead of just as a string
     * @return File, split by new lines
     * @throws IOException
     */
    public String[] readLines() throws IOException {
        return this.readLines(false);
    }

    /**
     * read - Reads a file from a string. Default: overrides
     * the cache and re-reads the file.
     * @throws IOException
     */
    public String read() throws IOException {
        return this.read(true);
    }

    public String readIE(boolean overrideCache) {
        try { return this.read(overrideCache); }
        catch(IOException e) {}
        return null;
    }

    public String readIE(int start, int len, boolean overrideCache) {
        try { return this.read(start, len, overrideCache); }
        catch(IOException e) {}
        return null;
    }

    public String readIE(int start, int length) {
        try { return this.read(start, length, true); }
        catch(IOException e) {}
        return null;
    }

    public String[] readLinesIE(boolean noCache) {
        try { return this.read(noCache).split("\n"); }
        catch(IOException e) {}
        return null;
    }

    public String[] readLinesIE() {
        try { return this.readLines(false); }
        catch(IOException e) {}
        return null;
    }

    /**
     * write - Write a string to a file
     *
     * @param data   Data to write
     * @param append Append or overwrite?
     * @throws IOException
     */
    public void write(String data, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, append));
        writer.write(data);
        writer.close();
    }

    /**
     * write - Write a string to a file
     * @param data
     * @throws IOException
     */
    public void write(String data) throws IOException {
        this.write(data, false);
    }

    /**
     * Write a string array to file, 1 per line
     * @param data                    String[] array to write
     * @param append                  Append to file?
     * @throws IOException
     */
    public void write(String[] data, boolean append) throws IOException {
        this.write(String.join("\n", data), append);
    }


    /**
     * Write a string array to file, 1 per line
     * @param data                    String[] array to write
     * @throws IOException
     */
    public void write(String[] data) throws IOException {
        this.write(data, true);
    }

    /**
     * append - Append to a file
     *
     * @param data  Data to write
     * @throws IOException
     */
    public void append(String data) throws IOException  {
        this.write(data, true);
    }

    /**
     * Writes to a file, and does nothing if IOException occurs
     * @param data   Data to write
     * @param append Append or overwrite?
     * @return       Was an exception thrown?
     */
    public boolean writeIE(String data, boolean append) {
        try{
            this.write(data, append);
            return true;
        }
        catch(IOException e) {
            return false;
        }
    }

    public boolean writeIE(String data) {
        return this.writeIE(data, false);
    }

    public boolean writeIE(String[] data, boolean append) {
        return this.writeIE(String.join("\n", data), append);
    }

    public boolean writeIE(String[] data) {
        return this.writeIE(data, true);
    }

    public boolean appendIE(String data) {
        return this.writeIE(data, true);
    }

    public void move(String newDir) {
        this.file.renameTo(new File(newDir));
    }

    /**
     * Rename the FILE (not directory)
     * @param newName New name of the file, ie test.txt
     */
    public void rename(String newName) {
        String path = this.getCanonicalPathIE();
        int end = path.lastIndexOf(File.separator);
        String dirs = path.substring(0, end + 1);
        this.renameTo(new File( dirs + newName ));
     }

    /**
     * ---- Duplicating functionality of ------
     * java.io.File. All methods are identical.
     * See https://docs.oracle.com/javase/7/docs/api/java/io/File.html
     */
    public boolean canExecute() {
        return this.file.canExecute();
    }
    public boolean canRead() {
        return this.file.canRead();
    }
    public boolean canWrite() {
        return this.file.canWrite();
    }
    public int compareTo(File pathname) {
        return this.file.compareTo(pathname);
    }
    public int compareTo(String pathname) {
        return this.file.compareTo(new File(pathname));
    }
    public boolean createNewFile() throws IOException {
        return this.file.createNewFile();
    }
    public boolean createNewFileIE() {
        try { return this.file.createNewFile(); }
        catch(IOException e) { return false; }
    }
    public static File createTempFile(String prefix, String suffix) throws IOException {
        return File.createTempFile(prefix, suffix);
    }
    public static File createTempFileIE(String prefix, String suffix) {
        try { return File.createTempFile(prefix, suffix); }
        catch(IOException e) { return null; }
    }
    public boolean delete() {
        return this.file.delete();
    }
    public void deleteOnExit() {
        this.file.deleteOnExit();
    }
    public boolean equals(Object other) {
        return this.file.equals(other);
    }
    public boolean exists() {
        return this.file.exists();
    }
    public File getAbsoluteFile() {
        return this.file.getAbsoluteFile();
    }
    public String getAbsolutePath() {
        return this.file.getAbsolutePath();
    }
    public File getCanonicalFile() throws IOException {
        return this.file.getCanonicalFile();
    }
    public String getCanonicalPath() throws IOException {
        return this.file.getCanonicalPath();
    }
    public File getCanonicalFileIE() {
        try { return this.file.getCanonicalFile(); }
        catch(IOException e) { return null; }
    }
    public String getCanonicalPathIE() {
        try { return this.file.getCanonicalPath(); }
        catch(IOException e) { return null; }
    }
    public long getFreeSpace() {
        return this.file.getFreeSpace();
    }
    public String getName() {
        return this.file.getName();
    }
    public String getParent() {
        return this.file.getParent();
    }
    public File getParentFile() {
        return this.file.getParentFile();
    }
    public String getPath() {
        return this.file.getPath();
    }
    public long getTotalSpace() {
        return this.file.getTotalSpace();
    }
    public long getUsableSpace() {
        return this.file.getUsableSpace();
    }
    public int hashCode() {
        return this.file.hashCode();
    }
    public boolean isAbsolute() {
        return this.isAbsolute();
    }
    public boolean isDirectory() {
        return this.file.isDirectory();
    }
    public boolean isFile() {
        return this.file.isFile();
    }
    public boolean isHidden() {
        return this.file.isHidden();
    }
    public long lastModified() {
        return this.file.lastModified();
    }
    public long length() {
        return this.file.length();
    }
    public String[] list() {
        return this.file.list();
    }
    public String[] list(FilenameFilter filter) {
        return this.file.list(filter);
    }
    public File[] listFiles() {
        return this.file.listFiles();
    }
    public File[] listFiles(FilenameFilter filter) {
        return this.file.listFiles(filter);
    }
    public File[] listFiles(FileFilter filter) {
        return this.file.listFiles(filter);
    }
    public static File[] listRoots() {
        return File.listRoots();
    }
    public boolean mkdir() {
        return this.file.mkdir();
    }
    public boolean mkdirs() {
        return this.file.mkdirs();
    }
    public boolean renameTo(File dest) {
        return this.file.renameTo(dest);
    }
    public boolean setExecutable(boolean executable) {
        return this.file.setExecutable(executable);
    }
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        return this.file.setExecutable(executable, ownerOnly);
    }
    public boolean setLastModified(long time) {
        return this.file.setLastModified(time);
    }
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        return this.file.setReadable(readable, ownerOnly);
    }
    public boolean setReadOnly() {
        return this.file.setReadOnly();
    }
    public boolean setReadable(boolean readable) {
        return this.file.setReadable(readable);
    }
    public boolean setWritable(boolean writable) {
        return this.file.setReadable(writable);
    }
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        return this.file.setReadable(writable, ownerOnly);
    }
    public Path toPath() {
        return this.file.toPath();
    }
    public String toString() {
        return this.file.toString();
    }
    public URI toURI() {
        return this.file.toURI();
    }
}
