package FileWorks.jar.fileworks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataImport {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fileworks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

    public class DataImport {
        private BufferedReader fileRead;
        private String importPath;

        public DataImport(String fileName) {
            try {
                this.fileRead = new BufferedReader(new FileReader(fileName));
                this.importPath = fileName;
            } catch (FileNotFoundException var3) {
                System.err.println("File " + fileName + " cannot be found | Soubor nenalezen, zkontrolujte cestu");
                System.err.println(var3);
            }

        }

        public void reinitializeRead() throws IOException {
            this.fileRead.close();
            this.fileRead = new BufferedReader(new FileReader(this.importPath));
        }

        public void printFile() {
            try {
                this.reinitializeRead();

                String line;
                while((line = this.fileRead.readLine()) != null) {
                    System.out.println(line);
                }

                this.reinitializeRead();
            } catch (IOException var2) {
                System.err.println("IO error occured");
            }

        }

        protected int countLines() {
            try {
                this.reinitializeRead();

                int counter;
                for(counter = 0; this.fileRead.readLine() != null; ++counter) {
                }

                this.reinitializeRead();
                return counter;
            } catch (Exception var3) {
                System.err.println("IO error occured");
                return -1;
            }
        }

        public char readChar() {
            try {
                return (char)this.fileRead.read();
            } catch (IOException var2) {
                System.err.println("IO error occured");
                return '\u0000';
            }
        }

        public boolean hasNext() {
            try {
                return this.fileRead.ready();
            } catch (IOException var2) {
                System.err.println("IO error occured");
                return false;
            }
        }

        public String readLine() {
            try {
                return this.fileRead.readLine();
            } catch (IOException var2) {
                System.err.println("IO error occured");
                return null;
            }
        }

        public void finishImport() {
            try {
                this.fileRead.close();
            } catch (IOException var2) {
                System.err.println("IO error occured");
            }

        }
    }

}
