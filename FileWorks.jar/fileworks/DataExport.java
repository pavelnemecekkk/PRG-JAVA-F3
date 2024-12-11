package FileWorks.jar.fileworks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataExport {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fileworks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    public class DataExport {
        private BufferedWriter fileWrite;

        public DataExport(String fileName) {
            try {
                this.fileWrite = new BufferedWriter(new FileWriter(fileName));
            } catch (IOException var3) {
                System.err.println("File could not be created | IO vyjimka, konzultujte vyucujiciho ;)");
            }

        }

        public void writeString(String string) {
            try {
                this.fileWrite.write(string);
            } catch (IOException var3) {
                System.err.println("IO error occured");
            }

        }

        public void writeNewLine() {
            try {
                this.fileWrite.newLine();
            } catch (IOException var2) {
                System.err.println("IO error occured");
            }

        }

        public void writeLine(String line) {
            try {
                this.fileWrite.write(line);
                this.fileWrite.newLine();
            } catch (IOException var3) {
                System.err.println("IO error occured");
            }

        }

        public void finishExport() {
            try {
                this.fileWrite.close();
            } catch (IOException var2) {
                System.err.println("IO error occured");
            }

        }
    }

}
