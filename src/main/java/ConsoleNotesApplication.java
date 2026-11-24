package com.example.consolenotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class ConsoleNotesApplication implements CommandLineRunner {
    private final NoteService noteService;

    public ConsoleNotesApplication(NoteService noteService) {
        this.noteService = noteService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsoleNotesApplication.class, args);
    }

    @Override
    public void run(String... args)
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Simple Note App (Type 'exit' to quit) ===");

        while (true) {
            System.out.print("Enter a note: ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            noteService.addNote(input);
        }

        System.out.println("\nYour saved notes:");
        noteService.getAllNotes().forEach(n -> System.out.println("- " + n));
    }
}
