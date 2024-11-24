import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
/**
 * This program demonstrates file compression and decompression using Java's built-in utilities.
 */
public class FileCompressionDecompression {

    public static void main(String[] args) {
        String inputPath = "D:\\ExampleDirectory\\logo.jpg"; // Original file to compress
        String compressedPath = "D:\\ExampleDirectory\\compressedLogo.txt"; // Compressed file path
        String decompressedPath = "D:\\ExampleDirectory\\decompressedLogo.jpg"; // Decompressed file path

        // Compress the file
        compressFile(inputPath, compressedPath);

        // Decompress the file
        decompressFile(compressedPath, decompressedPath);
    }

    /**
     * Compresses the specified input file and writes the compressed data to the output file.
     *
     * @param inputPath  Path to the file to be compressed.
     * @param outputPath Path where the compressed file will be saved.
     */
    public static void compressFile(String inputPath, String outputPath) {
        try (
                FileInputStream inputStream = new FileInputStream(inputPath);
                FileOutputStream outputStream = new FileOutputStream(outputPath);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream)
        ) {
            int byteData;

            // Read and write data byte-by-byte
            while ((byteData = inputStream.read()) != -1) {
                deflaterOutputStream.write(byteData); // Write compressed data
            }

            System.out.println("File compression completed successfully.");
        } catch (IOException e) {
            System.err.println("Error during file compression: " + e.getMessage());
        }
    }

    /**
     * Decompresses the specified compressed file and writes the original data to the output file.
     *
     * @param inputPath  Path to the compressed file.
     * @param outputPath Path where the decompressed file will be saved.
     */
    public static void decompressFile(String inputPath, String outputPath) {
        try (
                FileInputStream inputStream = new FileInputStream(inputPath);
                InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
                FileOutputStream outputStream = new FileOutputStream(outputPath)
        ) {
            int byteData;

            // Read and write data byte-by-byte
            while ((byteData = inflaterInputStream.read()) != -1) {
                outputStream.write(byteData); // Write decompressed data
            }

            System.out.println("File decompression completed successfully.");
        } catch (IOException e) {
            System.err.println("Error during file decompression: " + e.getMessage());
        }
    }
}

