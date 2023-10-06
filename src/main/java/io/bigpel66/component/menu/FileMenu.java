package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu_item.AbstractMenuItem;
import io.bigpel66.component.text_area.AbstractStatefulTextArea;
import io.bigpel66.utility.ConfigLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Optional;

public final class FileMenu extends AbstractMenu {
    private static final String TITLE = "File";

    private static final int INDEX = 0;

    private final ActionListener newConsumer = (e) -> Notepad.execute(ConfigLoader.load(true));

    private final ActionListener openConsumer = (e) -> {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(getContext());
        if (option != JFileChooser.APPROVE_OPTION) {
            return;
        }
        for (Component component : getContext().getContentPane().getComponents()) {
            if (!(component instanceof JScrollPane)) {
                continue;
            }
            AbstractStatefulTextArea textArea = (AbstractStatefulTextArea) ((JScrollPane) component).getViewport().getView();
            textArea.setText("");
            File selectedFile = chooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                while (true) {
                    Optional<String> line = Optional.ofNullable(br.readLine());
                    if (line.isEmpty()) {
                        break;
                    }
                    textArea.append(line.get());
                }
            } catch (IOException ex) {
                throw new RuntimeException("file cannot be opened");
            }
        }
    };

    private final ActionListener saveConsumer = (e) -> {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(getContext());
        if (option != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File selectedFile = chooser.getSelectedFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile.getPath()))) {
            bw.write(getContext().getStateTracker().getContents());
            getContext().getStateTracker().setTitle(selectedFile.getName());
            getContext().setTitle(selectedFile.getName());
        } catch (IOException ex) {
            throw new RuntimeException("file cannot be saved");
        }
    };

    public static void registerTo(final Notepad context) {
        new FileMenu(context);
    }

    private FileMenu(final Notepad context) {
        super(context, TITLE);
        AbstractMenuItem.builder()
                .title("New")
                .index(INDEX)
                .context(context)
                .actionListener(newConsumer)
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_DOWN_MASK))
                .build();
        AbstractMenuItem.builder()
                .title("Open")
                .index(INDEX)
                .context(context)
                .actionListener(openConsumer)
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_DOWN_MASK))
                .build();
        AbstractMenuItem.builder()
                .title("Save")
                .index(INDEX)
                .context(context)
                .actionListener(saveConsumer)
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_DOWN_MASK))
                .build();
    }

    @Override
    public String toString() {
        return "Name : FileMenu\n" +
                "Title : " + TITLE + "\n" +
                "Index : " + INDEX;
    }

}